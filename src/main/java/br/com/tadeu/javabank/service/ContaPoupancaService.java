package br.com.tadeu.javabank.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tadeu.javabank.model.ContaPoupanca;
import br.com.tadeu.javabank.repository.ContaRepository;

@Service
@Validated
public class ContaPoupancaService extends ContaService {

	@Autowired
	public ContaPoupancaService(ContaRepository contaRepository, ClienteService clienteService,
			BancoService bancoService) {
		super(contaRepository, clienteService, bancoService);
	}

	public ContaPoupanca salvar(@Valid ContaPoupanca contaPoupanca) {
		return (ContaPoupanca) super.salvar(contaPoupanca);
	}
}
