package br.com.tadeu.javabank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tadeu.javabank.controller.dto.request.ContaCorrenteRequestDto;
import br.com.tadeu.javabank.model.ContaCorrente;
import br.com.tadeu.javabank.service.ContaCorrenteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contas-corrente")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContaCorrenteController {
	private final ContaCorrenteService contaCorrenteService;

	@PostMapping
	public ContaCorrente criar(@RequestBody ContaCorrenteRequestDto contaCorrenteRequest) {
		return contaCorrenteService.salvar(contaCorrenteRequest.toModel());
	}
}