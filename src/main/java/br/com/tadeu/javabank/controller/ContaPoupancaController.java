package br.com.tadeu.javabank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tadeu.javabank.controller.dto.request.ContaPoupancaRequestDto;
import br.com.tadeu.javabank.model.ContaPoupanca;
import br.com.tadeu.javabank.service.ContaPoupancaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contas-poupanca")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContaPoupancaController {
	private final ContaPoupancaService contaPoupancaService;

	@PostMapping
	public ContaPoupanca criar(@RequestBody ContaPoupancaRequestDto contaPoupancaRequestDto) {
		return contaPoupancaService.salvar(contaPoupancaRequestDto.toModel());
	}
}