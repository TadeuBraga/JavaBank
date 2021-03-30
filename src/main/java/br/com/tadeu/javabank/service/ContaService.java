package br.com.tadeu.javabank.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tadeu.javabank.model.Banco;
import br.com.tadeu.javabank.model.Cliente;
import br.com.tadeu.javabank.model.Conta;
import br.com.tadeu.javabank.repository.BancoRepository;
import br.com.tadeu.javabank.repository.ClienteRepository;
import br.com.tadeu.javabank.repository.ContaRepository;

@Service
@Validated
public class ContaService {
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private BancoRepository bancoRepository;

	public Conta salvar(@Valid Conta conta) {
		conta.setDataCriacao(new Date());
		Cliente cliente = clienteRepository.findByNome(conta.getCliente().getNome());
		if(cliente != null) {
			conta.setCliente(cliente);
		}
		Banco banco = bancoRepository.findByNome(conta.getBanco().getNome());
		if(banco != null) {
			conta.setBanco(banco);
		}
		return contaRepository.save(conta);
	}

	public List<Conta> encontraMilionarios() {
		return contaRepository.findBySaldoGreaterThan(new BigDecimal(1000000L));
	}

	public List<Conta> buscarTodos() {
		return contaRepository.findAll();
	}

	public Conta buscarPorId(Long id) {
		return contaRepository.findById(id).orElse(null);
	}
}
