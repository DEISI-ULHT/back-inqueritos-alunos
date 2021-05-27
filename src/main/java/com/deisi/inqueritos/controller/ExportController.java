package com.deisi.inqueritos.controller;

import com.deisi.inqueritos.data.AggregatedResponse;
import com.deisi.inqueritos.data.InqueritoResult;
import com.deisi.inqueritos.data.TeacherEvaluation;
import com.deisi.inqueritos.model.Resposta;
import com.deisi.inqueritos.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/api")
public class ExportController {

    @Value("${inqueritos.api.token}")
    private String token;

    @Autowired
    private RespostaService service;

    @GetMapping("export")
    public ResponseEntity<List<InqueritoResult>> export(@RequestParam("token") String tokenParam) {

        if (!token.equals(tokenParam)) {
            throw new RuntimeException("Invalid token");
        }

        List<Resposta> respostas = service.getAll();
        List<InqueritoResult> globalResult = new ArrayList<>();

        Map<String,List<Resposta>> respostasBySession = respostas.stream().collect(groupingBy(Resposta::getSession));

        Map<String,List<AggregatedResponse>> respostasByCourseId = new HashMap<>();

        for (List<Resposta> respostasEachSession : respostasBySession.values()) {
            AggregatedResponse response = new AggregatedResponse(respostas.get(0).getSession());

            Calendar c = Calendar.getInstance();
            c.set(2040, Calendar.JANUARY, 1);
            Date start = c.getTime();

            c.set(1900, Calendar.JANUARY, 1);
            Date end = c.getTime();

            String courseId = null;
            TeacherEvaluation theoreticalTeacher = null;
            TeacherEvaluation practicalTeacher = null;

            for (Resposta currentResposta : respostasEachSession) {

                if (courseId == null) {
                    courseId = currentResposta.getDisciplinaId();
                } else if (!courseId.equals(currentResposta.getDisciplinaId())) {
                    throw new RuntimeException("Error! Same session was used for two different courses");
                }

                if (currentResposta.getAnsweredAt().before(start)) {
                    start = currentResposta.getAnsweredAt();
                }

                if (currentResposta.getAnsweredAt().after(end)) {
                    end = currentResposta.getAnsweredAt();
                }

                switch (currentResposta.getPerguntaId()) {
                    case "0":  // qual o curso?
                        switch (currentResposta.getConteudo()) {
                            case "Engenharia Informatica":
                                response.setProgramme("LEI");
                                break;
                            case "Informatica Gestao":
                                response.setProgramme("LIG");
                                break;
                            case "LEIRT":
                                response.setProgramme("LEIRT");
                                break;
                            default:
                                throw new RuntimeException("Invalid programme: " + currentResposta.getConteudo());
                        }
                        break;
                    case "1":  // como te sentes?
                        switch (currentResposta.getConteudo()) {
                            case "Muito bem":
                                response.setMood(5);
                                break;
                            case "Bem":
                                response.setMood(4);
                                break;
                            case "Razoavel":
                                response.setMood(3);
                                break;
                            case "Mal":
                                response.setMood(2);
                                break;
                            case "Muito mal":
                                response.setMood(1);
                                break;
                            default:
                                throw new RuntimeException("Invalid mood: " + currentResposta.getConteudo());
                        }
                    case "3":  // o que correu bem?
                        response.setLikedMost(currentResposta.getConteudo());
                        break;
                    case "4":  // o que podia ser melhorado?
                        response.setCouldBeBetter(currentResposta.getConteudo());
                        break;
                    case "5":  // teóricas e práticas sincronizadas?
                        switch (currentResposta.getConteudo()) {
                            case "Muita ligação":
                                response.setSync(3);
                                break;
                            case "Pouca ligação":
                                response.setSync(2);
                                break;
                            case "Nenhuma Ligação":
                                response.setSync(1);
                                break;
                            case "Não faz sentido nessa disciplina":
                                response.setSync(-1);
                                break;
                            default:
                                throw new RuntimeException("Invalid sync: " + currentResposta.getConteudo());
                        }
                        break;
                    case "10":
                        if (theoreticalTeacher == null) {
                            theoreticalTeacher = new TeacherEvaluation(currentResposta.getProfessorId());
                            theoreticalTeacher.setExplanations(Integer.parseInt(currentResposta.getConteudo()));
                        } else {
                            practicalTeacher = new TeacherEvaluation(currentResposta.getProfessorId());
                            practicalTeacher.setExplanations(Integer.parseInt(currentResposta.getConteudo()));
                        }
                        break;
                    case "11":
                        if (theoreticalTeacher.getTeacherId().equals(currentResposta.getProfessorId())) {
                            theoreticalTeacher.setWellPrepared(Integer.parseInt(currentResposta.getConteudo()));
                        } else if (practicalTeacher.getTeacherId().equals(currentResposta.getProfessorId())) {
                            practicalTeacher.setWellPrepared(Integer.parseInt(currentResposta.getConteudo()));
                        } else {
                            throw new RuntimeException("Error! teacher is neither theoretical or practical!");
                        }
                        break;
                    case "12":
                        if (theoreticalTeacher.getTeacherId().equals(currentResposta.getProfessorId())) {
                            theoreticalTeacher.setAvailability(Integer.parseInt(currentResposta.getConteudo()));
                        } else if (practicalTeacher.getTeacherId().equals(currentResposta.getProfessorId())) {
                            practicalTeacher.setAvailability(Integer.parseInt(currentResposta.getConteudo()));
                        } else {
                            throw new RuntimeException("Error! teacher is neither theoretical or practical!");
                        }
                        break;
                    case "13":
                        if (theoreticalTeacher.getTeacherId().equals(currentResposta.getProfessorId())) {
                            theoreticalTeacher.setMaterial(Integer.parseInt(currentResposta.getConteudo()));
                        } else if (practicalTeacher.getTeacherId().equals(currentResposta.getProfessorId())) {
                            practicalTeacher.setMaterial(Integer.parseInt(currentResposta.getConteudo()));
                        } else {
                            throw new RuntimeException("Error! teacher is neither theoretical or practical!");
                        }
                        break;
                    case "14":
                        if (theoreticalTeacher.getTeacherId().equals(currentResposta.getProfessorId())) {
                            theoreticalTeacher.setAssessment(Integer.parseInt(currentResposta.getConteudo()));
                        } else if (practicalTeacher.getTeacherId().equals(currentResposta.getProfessorId())) {
                            practicalTeacher.setAssessment(Integer.parseInt(currentResposta.getConteudo()));
                        } else {
                            throw new RuntimeException("Error! teacher is neither theoretical or practical!");
                        }
                        break;
                    case "15":
                        if (theoreticalTeacher.getTeacherId().equals(currentResposta.getProfessorId())) {
                            theoreticalTeacher.setAgain(Integer.parseInt(currentResposta.getConteudo()));
                        } else if (practicalTeacher.getTeacherId().equals(currentResposta.getProfessorId())) {
                            practicalTeacher.setAgain(Integer.parseInt(currentResposta.getConteudo()));
                        } else {
                            throw new RuntimeException("Error! teacher is neither theoretical or practical!");
                        }
                        break;
                }
            }

            response.setTheoreticalTeacher(theoreticalTeacher);
            response.setPracticalTeacher(practicalTeacher);

            response.setStart(start);
            response.setEnd(end);

            List<AggregatedResponse> respostasForCourseId = respostasByCourseId.get(courseId);
            if (respostasForCourseId == null) {
                respostasForCourseId = new ArrayList<>();
            }
            respostasForCourseId.add(response);

            respostasByCourseId.put(courseId, respostasForCourseId);
        }

        for (Map.Entry<String,List<AggregatedResponse>> entry : respostasByCourseId.entrySet()) {
            InqueritoResult result = new InqueritoResult(entry.getKey(), entry.getValue());
            globalResult.add(result);
        }

        return new ResponseEntity<>(globalResult, HttpStatus.OK);
    }
}
