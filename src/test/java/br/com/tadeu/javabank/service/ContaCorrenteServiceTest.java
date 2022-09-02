package br.com.tadeu.javabank.service;

import br.com.tadeu.javabank.model.Banco;
import br.com.tadeu.javabank.model.Cliente;
import br.com.tadeu.javabank.model.ContaCorrente;
import br.com.tadeu.javabank.repository.ContaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContaCorrenteServiceTest {
    public static final ContaCorrente CONTA_CORRENTE = ContaCorrente.builder()
            .cliente(Cliente.builder().build()).banco(Banco.builder().build()).build();
    public static final Instant NOW = Instant.now();
    @Mock
    private ContaRepository contaRepository;
    @Mock
    private ClienteService clienteService;
    @Mock
    private BancoService bancoService;
    @Mock
    private Clock clock;

    @InjectMocks
    private ContaCorrenteService contaCorrenteService;

    @BeforeEach
    void setUp() {
        CONTA_CORRENTE.setDataCriacao(null);
        when(clock.instant()).thenReturn(NOW);
        when(clock.getZone()).thenReturn(ZoneId.of("UTC"));
    }

    void mockServices() {
        when(clienteService.salvaOuObtemCliente(any())).thenReturn(CONTA_CORRENTE.getCliente());
        when(bancoService.salvaOuObtemBanco(any())).thenReturn(CONTA_CORRENTE.getBanco());
    }
    @Test
    void deve_Salvar_Quando_Chamado() {
        mockServices();
        contaCorrenteService.salvar(CONTA_CORRENTE);
        assertAll(() -> verify(contaRepository).save(CONTA_CORRENTE),
                () -> verify(clienteService).salvaOuObtemCliente(CONTA_CORRENTE.getCliente()),
                () -> verify(bancoService).salvaOuObtemBanco(CONTA_CORRENTE.getBanco()),
                () -> assertThat(CONTA_CORRENTE.getDataCriacao(), equalTo(LocalDateTime.ofInstant(NOW, ZoneOffset.UTC))));
    }

}