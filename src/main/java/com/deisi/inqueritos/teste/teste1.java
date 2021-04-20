//package com.deisi.inqueritos.teste;
//
//import com.deisi.inqueritos.dto.CsvSeedDTO;
//import com.deisi.inqueritos.dto.ProfessorDTO;
//import com.deisi.inqueritos.dto.ProfessorDisciplinaDTO;
//import com.deisi.inqueritos.model.Professor;
//import com.deisi.inqueritos.repository.ProfessorRepository;
//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@Component
//public class teste1 {
//    @Autowired
//    private ApplicationContext context;
//
//    private List<CsvSeedDTO> csvConverter(String path) {
//
//        List<CsvSeedDTO> csvSeedDTOList = new ArrayList<>();
//        List<ProfessorDisciplinaDTO> todosPDDTO = new ArrayList<>();
//        List<String> todasDisciplinas = new ArrayList<>();
//
//        try {
//            CSVReader reader = new CSVReader(new FileReader(path));
//            String[] nextLine;
//            int line = 2;
//            while (Objects.nonNull(nextLine = reader.readNext())) {
//                line++;
//                String[] splittedLine = nextLine[0].split(";");
//                ProfessorDTO professorDTO = new ProfessorDTO();
//                professorDTO.setProfessor(splittedLine[0]);
//                professorDTO.setEmail(splittedLine[1]);
//                List<String> sublistaDeDisciplinas = Arrays.asList(splittedLine).subList(2, splittedLine.length);
//                List<String> listaFiltrada = sublistaDeDisciplinas.stream().filter(
//                        disciplina -> !(disciplina.equals("x") || disciplina.isEmpty())).collect(Collectors.toList());
//
//                professorDTO.setDisciplinas(listaFiltrada);
//
//                professorDTO.setId("p" + line);
//
//
//                filtraDisciplina(professorDTO, listaFiltrada, todasDisciplinas, todosPDDTO);
//
//
//                CsvSeedDTO csvSeedDTO = new CsvSeedDTO();
//                csvSeedDTOList.add(csvSeedDTO);
//            }
//        } catch (CsvValidationException | IOException e) {
//            e.printStackTrace();
//        }
//        return csvSeedDTOList;
//    }
//
//    private void tipoReplace(String disciplina, ProfessorDisciplinaDTO professorDisciplinaDTO, List<String> todasDisciplinas, String tag, String tipo, List<ProfessorDisciplinaDTO> todosPDDTO) {
//        if (disciplina.contains(tag)) {
//            professorDisciplinaDTO.setTipo(tipo);
//            String replaced = disciplina.replace(tag, "");
//            todasDisciplinas.add(replaced.trim());
//            todosPDDTO.add(professorDisciplinaDTO);
//        }
//    }
//
//    private void filtraDisciplina(ProfessorDTO professor, List<String> disciplinas,
//                                  List<String> todasDisciplinas, List<ProfessorDisciplinaDTO> todosPDDTO) {
//        String[] tipos = {"T", "P", "T+P", "T+TP"};
//        disciplinas.forEach(disciplina -> {
//            ProfessorDisciplinaDTO professorDisciplinaDTO = new ProfessorDisciplinaDTO();
//            professorDisciplinaDTO.setProfessorId(professor.getId());
//
//            Arrays.asList(tipos).forEach(tipo -> {
//                tipoReplace(disciplina, professorDisciplinaDTO, todasDisciplinas, "(" + tipo + ")", tipo, todosPDDTO);
//            });
//        });
//    }
//
//   /* @PostConstruct
//   /* public void testando() {
//     //   List<CsvSeedDTO> csvSeedDTOS = csvConverter("C:\\Users\\marce\\Documentos\\deisi_tabela.csv");
//        ProfessorRepository repo = context.getBean(ProfessorRepository.class);
//        Professor professor = new Professor();
//        //professor.setId(001L);
//        professor.setEmail("email@.com");
//        //professor.setId_lusofona(829L);
//        professor.setNome("Kagimura");
//        repo.save(professor);
//    }*/
//}
