package br.com.tadeu.javabank.controller;

import br.com.tadeu.javabank.base.ContaPoupancaBaseTest;
import br.com.tadeu.javabank.model.ContaPoupanca;
import br.com.tadeu.javabank.service.ContaPoupancaService;
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

@WebMvcTest(ContaPoupancaController.class)
@ExtendWith(SpringExtension.class)
class ContaPoupancaControllerTest extends ContaPoupancaBaseTest {

    @MockBean
    ContaPoupancaService contaPoupancaService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;


    @Test
    void deve_saldar_Quando_Chamado() throws Exception {
        when(contaPoupancaService.salvar(CONTA_POUPANCA)).thenReturn(CONTA_POUPANCA);

        var result = mockMvc.perform(post("/contas-poupanca")
                        .content(objectMapper.writeValueAsString(CONTA_POUPANCA)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        var conta = objectMapper.readValue(result.getResponse().getContentAsString(),
              ContaPoupanca.class);

        assertThat(conta, equalTo(CONTA_POUPANCA));
    }

}