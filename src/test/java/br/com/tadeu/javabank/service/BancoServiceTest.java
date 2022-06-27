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

import br.com.tadeu.javabank.model.Banco;
import br.com.tadeu.javabank.repository.BancoRepository;

@ExtendWith(MockitoExtension.class)
class BancoServiceTest {
	public static final String NOME = "Banco Java";
	public static final String CODIGO = "JAVA";
	public static final Banco BANCO = Banco.builder().nome(NOME).codigoInternacional(CODIGO).build();
	@Mock
	BancoRepository bancoRepository;
	@InjectMocks
	BancoService bancoService;

	@Test
	void deve_EncontrarPorNome_Quando_QualquerEhDado() {

		when(bancoRepository.findByNome(NOME)).thenReturn(Optional.of(BANCO));

		var resultado = bancoService.findByNome(NOME);

		assertThat(resultado.get(), equalTo(BANCO));
	}

	@Test
	void deve_EncontrarPorCodigoInternacional_Quando_QualquerEhDado() {
		when(bancoRepository.findByCodigoInternacional(CODIGO)).thenReturn(Optional.of(BANCO));

		var resultado = bancoService.findByCodigoInternacional(CODIGO);

		assertThat(resultado.get(), equalTo(BANCO));
	}

	@Test
	void deve_salvarOuObter_Quando_NovoBanco() {
		when(bancoRepository.findByCodigoInternacional(CODIGO)).thenReturn(Optional.empty());

		bancoService.salvaOuObtemBanco(BANCO);

		verify(bancoRepository).save(BANCO);
	}

	@Test
	void deve_salvarOuObter_Quando_BancoExistente() {
		when(bancoRepository.findByCodigoInternacional(CODIGO)).thenReturn(Optional.of(BANCO));

		var resultado = bancoService.salvaOuObtemBanco(BANCO);

		assertAll(() -> verify(bancoRepository, never()).save(BANCO),
				() -> assertThat(resultado, equalTo(BANCO)));
	}

}
