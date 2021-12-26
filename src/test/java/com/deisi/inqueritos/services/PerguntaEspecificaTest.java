package com.deisi.inqueritos.services;

import com.deisi.inqueritos.dto.PerguntaEspecificaDTO;
import com.deisi.inqueritos.repository.PerguntaEspecificaRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class PerguntaEspecificaTest {
    @Mock
    private PerguntaEspecificaRepository repository;
    @Mock
    private DisciplinaService disciplinaService;
    @InjectMocks
    private PerguntaEspecificaService perguntaEspecificaService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        perguntaEspecificaService = new PerguntaEspecificaService(repository,disciplinaService);
    }



    @Test
    public void shouldSaveOpenQuestion(){
        PerguntaEspecificaDTO perguntaEspecificaDTO = buildDTO1();
        perguntaEspecificaService.saveDTO(perguntaEspecificaDTO);

        verify(repository,times(1)).save(any());

    }

    @Test
    public void shouldSaveClosedQuestion(){
        PerguntaEspecificaDTO perguntaEspecificaDTO = buildDTO2();
        perguntaEspecificaService.saveDTO(perguntaEspecificaDTO);

        verify(repository,times(1)).save(any());
    }

    //builders
    private PerguntaEspecificaDTO buildDTO1(){
        return new PerguntaEspecificaDTO("discId",null,null,"enunciado","",null,"",null);
    }
    private PerguntaEspecificaDTO buildDTO2(){
        return new PerguntaEspecificaDTO("discId",null,null,"enunciado","uno","dos","tres","cuatro");
    }


}
