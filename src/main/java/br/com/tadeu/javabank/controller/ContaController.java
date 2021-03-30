package br.com.tadeu.javabank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tadeu.javabank.model.Conta;
import br.com.tadeu.javabank.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
	@Autowired
	private ContaService contaService;

	@GetMapping
	public List<Conta> buscarTodos() {
		return contaService.buscarTodos();
	}

	@GetMapping("/{id}")
	public Conta buscarPorId(@PathVariable Long id) {
		return contaService.buscarPorId(id);
	}

	@PostMapping
	public Conta criar(@RequestBody Conta conta) {
		return contaService.salvar(conta);
	}

	@GetMapping(value = "/milionarios")
	public List<Conta> encontraMilionarios() {
		return contaService.encontraMilionarios();
	}
}