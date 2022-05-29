package br.com.tadeu.javabank.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tadeu.javabank.model.Conta;
import br.com.tadeu.javabank.repository.ContaRepository;
import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContaService {
	private final ContaRepository contaRepository;
	private final ClienteService clienteService;
	private final BancoService bancoService;

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
		conta.setDataCriacao(new Date());
		processaClienteExistente(conta);
		processaBancoExistente(conta);
		return contaRepository.save(conta);
	}

	private void processaClienteExistente(Conta conta) {
		var cliente = clienteService.findByNome(conta.getCliente().getNome());
		if (cliente != null) {
			conta.setCliente(cliente);
		}
	}

	private void processaBancoExistente(Conta conta) {
		var banco = bancoService.findByNome(conta.getBanco().getNome());
		if (banco != null) {
			conta.setBanco(banco);
		}
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
