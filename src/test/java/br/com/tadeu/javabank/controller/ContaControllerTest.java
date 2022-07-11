package br.com.tadeu.javabank.controller;

import br.com.tadeu.javabank.model.Banco;
import br.com.tadeu.javabank.model.Cliente;
import br.com.tadeu.javabank.model.Conta;
import br.com.tadeu.javabank.model.ContaCorrente;
import br.com.tadeu.javabank.service.ContaCorrenteService;
import br.com.tadeu.javabank.service.ContaPoupancaService;
import br.com.tadeu.javabank.service.ContaService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContaController.class)
@ExtendWith(SpringExtension.class)
class ContaControllerTest {
    public static final String NOME_BANCO = "Banco Java";
    public static final String CODIGO = "JAVA";
    public static final Banco BANCO = Banco.builder().nome(NOME_BANCO).codigoInternacional(CODIGO).build();
    public static final String NOME = "Mario da Silva";
    public static final String NUMERO_SOCIAL = "34802203047";
    public static final Cliente CLIENTE = Cliente.builder().nome(NOME).numeroSocial(NUMERO_SOCIAL).build();
    public static final Conta CONTA = ContaCorrente.builder().cliente(CLIENTE).banco(BANCO).build();
    @MockBean(name = "contaService")
    ContaService contaService;
    @MockBean
    ContaCorrenteService contaCorrenteService;
    @MockBean
    ContaPoupancaService contaPoupancaService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @Test
    void deve_BuscarTodos_Quando_Chamado() throws Exception {
        when(contaService.buscarTodos()).thenReturn(List.of(CONTA));

        var result = mockMvc.perform(get("/contas/")).andExpect(status().isOk()).andReturn();
        var contas = objectMapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<ContaCorrente>>(){});

        assertThat(contas, equalTo(List.of(CONTA)));
    }

    @Test
    void deve_BuscarAtivas_Quando_Chamado() throws Exception {
        when(contaService.buscarAtivas()).thenReturn(List.of(CONTA));

        var result = mockMvc.perform(get("/contas/ativas")).andExpect(status().isOk()).andReturn();
        var contas = objectMapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<ContaCorrente>>(){});

        assertThat(contas, equalTo(List.of(CONTA)));
    }

    @Test
    void deve_BuscarPorId_Quando_Chamado() throws Exception {
        long id = 1L;
        when(contaService.buscarPorId(id)).thenReturn(CONTA);

        var result = mockMvc.perform(get("/contas/" + id)).andExpect(status().isOk()).andReturn();
        var conta = objectMapper.readValue(result.getResponse().getContentAsString(), ContaCorrente.class);

        assertThat(conta, equalTo(List.of(CONTA)));
    }

    @Test
    void deve_DeletarPorId_Quando_Chamado() throws Exception {
        long id = 1L;

        mockMvc.perform(delete("/contas/" + id)).andExpect(status().isOk());

        verify(contaService).deletarPorId(1L);
    }

    @Test
    void deve_EncontrarMilionarios_Quando_Chamado() throws Exception {
        when(contaService.encontraMilionarios()).thenReturn(List.of(CONTA));

        var result = mockMvc.perform(get("/contas/milionarios")).andExpect(status().isOk()).andReturn();
        var contas = objectMapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<ContaCorrente>>(){});

        assertThat(contas, equalTo(List.of(CONTA)));
    }

}