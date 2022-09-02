package br.com.tadeu.javabank.service;

import br.com.tadeu.javabank.model.ContaPoupanca;
import br.com.tadeu.javabank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Clock;

@Service
@Validated
public class ContaPoupancaService extends ContaService {

	@Autowired
	public ContaPoupancaService(ContaRepository contaRepository, ClienteService clienteService,
			BancoService bancoService, Clock clock) {
		super(contaRepository, clienteService, bancoService, clock);
	}

	public ContaPoupanca salvar(@Valid ContaPoupanca contaPoupanca) {
		return (ContaPoupanca) super.salvar(contaPoupanca);
	}
}
