package br.com.tadeu.javabank.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.tadeu.javabank.model.Cliente;
import br.com.tadeu.javabank.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {
	public static final String NOME = "Mario da Silva";
	public static final String NUMERO_SOCIAL = "34802203047";
	public static final Cliente CLIENTE = Cliente.builder().nome(NOME).numeroSocial(NUMERO_SOCIAL).build();
	@Mock
	ClienteRepository clienteRepository;
	@InjectMocks
	ClienteService clienteService;

	@Test
	void deve_EncontrarPorNome_Quando_QualquerEhDado() {

		when(clienteRepository.findByNome(NOME)).thenReturn(Optional.of(CLIENTE));

		var resultado = clienteService.findByNome(NOME);

		assertThat(resultado.get(), equalTo(CLIENTE));
	}

	@Test
	void deve_EncontrarPorNumeroSocial_Quando_QualquerEhDado() {
		when(clienteRepository.findByNumeroSocial(NUMERO_SOCIAL)).thenReturn(Optional.of(CLIENTE));

		var resultado = clienteService.findByNumeroSocial(NUMERO_SOCIAL);

		assertThat(resultado.get(), equalTo(CLIENTE));
	}

	@Test
	void deve_salvarOuObter_Quando_NovoBanco() {
		when(clienteRepository.findByNumeroSocial(NUMERO_SOCIAL)).thenReturn(Optional.empty());

		clienteService.salvaOuObtemCliente(CLIENTE);

		verify(clienteRepository).save(CLIENTE);
	}

	@Test
	void deve_salvarOuObter_Quando_BancoExistente() {
		when(clienteRepository.findByNumeroSocial(NUMERO_SOCIAL)).thenReturn(Optional.of(CLIENTE));

		var resultado = clienteService.salvaOuObtemCliente(CLIENTE);

		assertAll(() -> verify(clienteRepository, never()).save(CLIENTE),
				() -> assertThat(resultado, equalTo(CLIENTE)));
	}

}
