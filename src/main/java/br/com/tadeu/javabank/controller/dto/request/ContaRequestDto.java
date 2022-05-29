package br.com.tadeu.javabank.controller.dto.request;

import java.math.BigDecimal;

import br.com.tadeu.javabank.model.Conta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Conta Bancária")
public record ContaRequestDto(ClienteRequestDto cliente, BancoRequestDto banco, BigDecimal saldo) {
	public Conta toModel() {
		return Conta.builder().cliente(cliente.toModel()).banco(banco.toModel()).saldo(saldo).build();
	}
}
