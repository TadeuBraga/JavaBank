package br.com.tadeu.javabank.controller.dto.request;

import java.math.BigDecimal;

import br.com.tadeu.javabank.model.ContaPoupanca;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Conta Poupança")
public record ContaPoupancaRequestDto(ClienteRequestDto cliente, BancoRequestDto banco, BigDecimal saldo,
		BigDecimal taxaRendimento) {
	public ContaPoupanca toModel() {
		return ContaPoupanca.builder().cliente(cliente.toModel()).banco(banco.toModel()).ativa(true).saldo(saldo)
				.taxaRendimento(taxaRendimento).build();
	}
}
