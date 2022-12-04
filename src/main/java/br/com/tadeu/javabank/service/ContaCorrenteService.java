package br.com.tadeu.javabank.service;

import br.com.tadeu.javabank.model.ContaCorrente;
import br.com.tadeu.javabank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import java.time.Clock;

@Service
@Validated
public class ContaCorrenteService extends ContaService {

	@Autowired
	public ContaCorrenteService(ContaRepository contaRepository, ClienteService clienteService,
			BancoService bancoService, Clock clock) {
		super(contaRepository, clienteService, bancoService, clock);
	}

	public ContaCorrente salvar(@Valid ContaCorrente contaCorrente) {
		return (ContaCorrente) super.salvar(contaCorrente);
	}
}
