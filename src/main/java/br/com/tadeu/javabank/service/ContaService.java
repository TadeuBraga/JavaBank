package br.com.tadeu.javabank.service;

import br.com.tadeu.javabank.model.Conta;
import br.com.tadeu.javabank.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Primary
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContaService {
	private final ContaRepository contaRepository;
	private final ClienteService clienteService;
	private final BancoService bancoService;
	private final Clock clock;

	public List<Conta> encontraMilionarios() {
		return contaRepository.findBySaldoGreaterThan(new BigDecimal(1000000L));
	}

	public List<Conta> buscarTodos() {
		return contaRepository.findAll();
	}

	public List<Conta> buscarAtivas() {
		return contaRepository.findByAtivaTrue();
	}

	public Conta buscarPorId(Long id) {
		return contaRepository.findById(id).orElse(null);
	}

	public Conta salvar(@Valid Conta conta) {
		conta.setDataCriacao(LocalDateTime.now(clock));
		conta.setCliente(clienteService.salvaOuObtemCliente(conta.getCliente()));
		conta.setBanco(bancoService.salvaOuObtemBanco(conta.getBanco()));
		return contaRepository.save(conta);
	}

	public void deletarPorId(Long id) {
		var contaOp = contaRepository.findById(id);
		if (contaOp.isPresent()) {
			var conta = contaOp.get();
			conta.setAtiva(false);
			contaRepository.save(conta);
		}
	}
}
