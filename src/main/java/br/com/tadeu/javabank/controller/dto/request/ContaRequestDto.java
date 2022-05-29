package br.com.tadeu.javabank.controller.dto.request;

import java.math.BigDecimal;

import br.com.tadeu.javabank.model.Conta;
import br.com.tadeu.javabank.model.ContaCorrente;
import br.com.tadeu.javabank.model.ContaPoupanca;
import br.com.tadeu.javabank.model.enums.TipoConta;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Conta Bancária")
public record ContaRequestDto(ClienteRequestDto cliente, BancoRequestDto banco, BigDecimal saldo, TipoConta tipoConta,
		BigDecimal taxaRendimento, BigDecimal limiteEspecial) {
	public Conta toModel() {
		return switch (tipoConta) {
		case CORRENTE -> ContaCorrente.builder().cliente(cliente.toModel()).banco(banco.toModel()).ativa(true)
				.saldo(saldo).limiteEspecial(limiteEspecial).build();
		case POUPANCA -> ContaPoupanca.builder().cliente(cliente.toModel()).banco(banco.toModel()).ativa(true)
				.saldo(saldo).taxaRendimento(taxaRendimento).build();
		default -> throw new IllegalArgumentException("Unexpected value: " + tipoConta);
		};
	}
}
