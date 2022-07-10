package br.com.tadeu.javabank.controller.dto.request;

import java.math.BigDecimal;

import br.com.tadeu.javabank.model.ContaCorrente;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Conta Corrente")
public record ContaCorrenteRequestDto(ClienteRequestDto cliente, BancoRequestDto banco, BigDecimal saldo,
		BigDecimal limiteEspecial) {
	public ContaCorrente toModel() {
		return ContaCorrente.builder().cliente(cliente.toModel()).banco(banco.toModel()).ativa(true).saldo(saldo)
				.limiteEspecial(limiteEspecial).build();
	}
}
