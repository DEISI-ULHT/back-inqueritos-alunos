package com.deisi.inqueritos.services;

import com.deisi.inqueritos.dto.RespostaDTO;
import com.deisi.inqueritos.repository.RespostaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class RespostaServiceTest {


    @Mock
    private RespostaRepository respostaRepository;

    @InjectMocks
    private RespostaService respostaService;


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        respostaService = new RespostaService(respostaRepository);
    }

    @Test
    public void shouldCallSaveDTOMethod() {
        RespostaDTO respostaDTO = buildRespostaDTO();

        respostaService.saveDTO(respostaDTO);

        verify(respostaRepository,times(1)).save(any());
    }


    //builders
    public RespostaDTO buildRespostaDTO() {
        RespostaDTO respostaDTO = new RespostaDTO();
        respostaDTO.setPerguntaId("perguntaId-Test");
        respostaDTO.setSession("session-Test");
        respostaDTO.setConteudo("conteudo-Test");
        respostaDTO.setDisciplinaId("disciplinaId-Test");
        respostaDTO.setProfessorId("professorId-Test");
        return respostaDTO;
    }
}
