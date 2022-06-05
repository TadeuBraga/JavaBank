package br.com.tadeu.javabank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tadeu.javabank.model.Banco;
import br.com.tadeu.javabank.repository.BancoRepository;
import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BancoService {
	private final BancoRepository bancoRepository;

	public Optional<Banco> findByNome(String nome) {
		return bancoRepository.findByNome(nome);
	}

	public Optional<Banco> findByCodigoInternacional(String codigoInternacional) {
		return bancoRepository.findByCodigoInternacional(codigoInternacional);
	}

	public Banco salvaOuObtemBanco(Banco banco) {
		return findByCodigoInternacional(banco.getCodigoInternacional()).orElseGet(() -> bancoRepository.save(banco));
	}

}
