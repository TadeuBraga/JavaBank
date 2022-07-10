package br.com.tadeu.javabank.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tadeu.javabank.model.ContaCorrente;
import br.com.tadeu.javabank.repository.ContaRepository;

@Service
@Validated
public class ContaCorrenteService extends ContaService {

	@Autowired
	public ContaCorrenteService(ContaRepository contaRepository, ClienteService clienteService,
			BancoService bancoService) {
		super(contaRepository, clienteService, bancoService);
	}

	public ContaCorrente salvar(@Valid ContaCorrente contaCorrente) {
		return (ContaCorrente) super.salvar(contaCorrente);
	}
}
