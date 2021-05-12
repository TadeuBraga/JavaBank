package br.com.tadeu.javabank.service;

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

	public Banco findByNome(String nome) {
		return bancoRepository.findByNome(nome);
	}

}
