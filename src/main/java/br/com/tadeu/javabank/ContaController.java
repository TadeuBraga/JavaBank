package br.com.tadeu.javabank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tadeu.javabank.model.Conta;
import br.com.tadeu.javabank.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
	@Autowired
	private ContaService contaService;

	@PostMapping
	public Conta criar(@RequestBody Conta conta) {
		return contaService.salvar(conta);
	}

	@GetMapping(value = "/milionarios")
	public List<Conta> encontraMilionarios() {
		return contaService.encontraMilionarios();
	}
}