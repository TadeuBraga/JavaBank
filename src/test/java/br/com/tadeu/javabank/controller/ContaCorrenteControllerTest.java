package br.com.tadeu.javabank.controller;

import br.com.tadeu.javabank.base.ContaCorrenteBaseTest;
import br.com.tadeu.javabank.model.ContaCorrente;
import br.com.tadeu.javabank.service.ContaCorrenteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContaCorrenteController.class)
@ExtendWith(SpringExtension.class)
class ContaCorrenteControllerTest extends ContaCorrenteBaseTest {
    @MockBean
    ContaCorrenteService contaCorrenteService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;


    @Test
    void deve_saldar_Quando_Chamado() throws Exception {
        when(contaCorrenteService.salvar(CONTA_CORRENTE)).thenReturn(CONTA_CORRENTE);

        var result = mockMvc.perform(post("/contas-corrente")
                        .content(objectMapper.writeValueAsString(CONTA_CORRENTE)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        var conta = objectMapper.readValue(result.getResponse().getContentAsString(),
              ContaCorrente.class);

        assertThat(conta, equalTo(CONTA_CORRENTE));
    }

}