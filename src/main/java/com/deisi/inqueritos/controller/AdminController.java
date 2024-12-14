package com.deisi.inqueritos.controller;

import com.deisi.inqueritos.apiclient.Course;
import com.deisi.inqueritos.apiclient.InnerTeacherCourse;
import com.deisi.inqueritos.apiclient.Teacher;
import com.deisi.inqueritos.apiclient.TeacherCourses;
import com.deisi.inqueritos.model.*;
import com.deisi.inqueritos.repository.*;
import com.deisi.inqueritos.services.APIClientService;
import com.deisi.inqueritos.utils.RandomStringGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.AccessDeniedException;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Value("${admin.token}")
    private String token;

    Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @Value("${inqueritos.current.semester}")
    private String currentSemester;

    @Value("${inqueritos.current.year}")
    private String currentYear;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorDisciplinaRepository professorDisciplinaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoDisciplinaRepository cursoDisciplinaRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private APIClientService apiClientService;

    @GetMapping("/")
    public String getSyncForm() {
        return "sync";
    }

    @PostMapping("/")
    public String sync() {

        LOG.info("Fetching courses from the API");

        List<Course> courses = apiClientService.fetchCourses(currentYear);

        LOG.info("Received " + courses.size() + " courses");

        for (Course course : courses) {
            if (!disciplinaRepository.existsById(course.getId())) {
                Disciplina disciplina = new Disciplina(course.getId(),
                        course.getName(),
                        course.getYear(),
                        "" + course.getSemester(),
                        RandomStringGenerator.generateRandomString());
                disciplinaRepository.save(disciplina);
                LOG.info("Saved " + disciplina.getId());

                for (String programme : course.getProgrammes()) {
                    Curso curso = cursoRepository.findCursoBySigla(programme);
                    if (curso == null) {
                        LOG.warn("Curso não existe na BD: " + programme);
                    } else {
                        if (!cursoDisciplinaRepository.existsByCursoAndAndDisciplina(curso, disciplina)) {
                            cursoDisciplinaRepository.save(new Curso_Disciplina(disciplina, curso));
                            LOG.info("Saved relation " + disciplina.getId() + " <-> " + curso.getSigla());
                        }
                    }
                }
            }
        }

        LOG.info("Fetching teachers from the API");

        List<Teacher> teachers = apiClientService.fetchTeachers(currentYear);

        LOG.info("Received " + teachers.size() + " teachers");

        for (Teacher teacher : teachers) {
            if (!professorRepository.existsByIdLusofona(teacher.getIdInqueritos())) {
                professorRepository.save(new Professor(teacher.getIdInqueritos(), teacher.getName(), "email"));
                LOG.info("Saved " + teacher.getIdInqueritos());
            }
        }

        LOG.info("Fetching teacher-courses from the API");

        List<TeacherCourses> teacherCourses = apiClientService.fetchTeachersCourse(currentYear, currentSemester);

        LOG.info("Received " + teacherCourses.size() + " teacher-courses");

        int currentYearDB = Integer.parseInt("20" + currentYear.substring(0, 2));
        for (TeacherCourses teacherCourse : teacherCourses) {

            Professor professor = professorRepository.findByIdLusofona(teacherCourse.getTeacherId());

            for (InnerTeacherCourse course : teacherCourse.getCourses()) {
                Disciplina disciplina = disciplinaRepository.getOne(course.getId());
                if (!professorDisciplinaRepository.existsByDisciplinaAndProfessorAndAnoAndSemestre(disciplina, professor,
                        currentYearDB, Integer.parseInt(currentSemester))) {
                    professorDisciplinaRepository.save(new ProfessorDisciplina(disciplina,
                            professor, course.isCoordinador(), course.isTheoretical(), course.isPractical(), currentYearDB,
                            Integer.parseInt(currentSemester)));
                    LOG.info("Saved " + professor.getId() + " <-> " + disciplina.getId() + " for " + currentYearDB + "/" + currentSemester);
                }
            }
        }

        return "success";
    }

    @GetMapping("/profs")
    public String profs(ModelMap modelMap,
                        @RequestParam(name = "token") String tokenParam) {

        if (!token.equals(tokenParam)) {
            throw new RuntimeException("Acesso não autorizado");
        }

        int currentYearDB = Integer.parseInt("20" + currentYear.substring(0, 2));
        List<ProfessorDisciplina> all = professorDisciplinaRepository.findAll();
        List<ProfessorDisciplina> result = all
                .stream()
                .filter((professorDisciplina -> professorDisciplina.getAno() == currentYearDB))
                .filter((professorDisciplina -> professorDisciplina.getSemestre() == Integer.parseInt(currentSemester)))
                .sorted(Comparator.comparing(pd -> pd.getDisciplina().getNome()))
                .collect(Collectors.toList());

        modelMap.put("result", result);
        return "profs";
    }

    @GetMapping("/disc")
    public String disc(ModelMap modelMap,
                       @RequestParam(name = "token") String tokenParam) {

        if (!token.equals(tokenParam)) {
            throw new RuntimeException("Acesso não autorizado");
        }

        // when the current survey started
        Calendar startSurvey = Calendar.getInstance();
        int currentYear = Year.now().getValue();
        if (currentSemester.equals("1")) {
            startSurvey.set(currentYear, Calendar.NOVEMBER, 1, 0, 0, 0);
        } else if (currentSemester.equals("2")) {
            startSurvey.set(currentYear, Calendar.MAY, 1, 0, 0, 0);
        } else {
            throw new IllegalArgumentException("Invalid semester: " + currentSemester);
        }

        List<Disciplina> all = disciplinaRepository.getDisciplinasBySemestreOrderByNome(currentSemester);
        List<Disciplina> result = all.stream()
//                        .filter((d) -> d.getAno() != 4)  // licenciaturas
//                        .filter((d) -> d.getAno() >= 4)  // mestrados
                        .collect(Collectors.toList());

        for (Disciplina disciplina : result) {
            List<Resposta> respostas = respostaRepository.getByDisciplinaIdAndAnsweredAtAfter(disciplina.getId(), startSurvey.getTime());
            long sessions = respostas.stream()
                    .map(Resposta::getSession)
                    .distinct()
                    .count();
            disciplina.setNumRespostas((int) sessions);
        }

        modelMap.put("result", result);
        return "disc";
    }

    @PostMapping("/generateProfsDisc")
    public String copyProfsDisc(@RequestParam int yearOrigin, @RequestParam int yearTarget, @RequestParam String semester) {

        List<ProfessorDisciplina> all = professorDisciplinaRepository.findAll();
        int maxId = all.stream()
                .mapToInt((pd) -> Integer.parseInt(pd.getId()))
                .max()
                .getAsInt();

        maxId++;

        List<ProfessorDisciplina> origin = professorDisciplinaRepository.getByAnoAndDisciplinaSemestre(yearOrigin, semester);

        for (ProfessorDisciplina originPD : origin) {
            ProfessorDisciplina newPD = new ProfessorDisciplina();
            newPD.setDisciplina(originPD.getDisciplina());
            newPD.setProfessor(originPD.getProfessor());
            newPD.setRegente(originPD.getRegente());
            newPD.setTeorico(originPD.getTeorico());
            newPD.setPratico(originPD.getPratico());
            newPD.setAno(yearTarget);
            newPD.setId(String.valueOf(maxId++));
            professorDisciplinaRepository.save(newPD);
        }

        return "redirect:/admin/profs?token=" + token;
    }

    @PostMapping("/removeTestAnswers")
    public String removeTestAnswers() {

        List<Resposta> all = respostaRepository.findAll();
        List<String> sessionsToDelete = all.stream()
                .filter((r) -> r.getPerguntaId().equals("2"))
                .filter((r) -> r.getConteudo().trim().startsWith("teste"))
                .map((r) -> r.getSession())
                .distinct()
                .collect(Collectors.toList());

        for (String s : sessionsToDelete) {
            respostaRepository.deleteBySession(s);
        }

        return "redirect:/admin/profs?token=" + token;
    }
}
