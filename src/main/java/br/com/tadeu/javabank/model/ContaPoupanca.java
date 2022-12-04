package br.com.tadeu.javabank.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
@Table(name = "t_conta_poupanca")
public final class ContaPoupanca extends Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal taxaRendimento;

	@Builder
	public ContaPoupanca(Long id, Cliente cliente, Banco banco, BigDecimal saldo,
						 LocalDateTime dataCriacao, Boolean ativa, BigDecimal taxaRendimento) {
		super(id, cliente, banco, saldo, dataCriacao, ativa);
		this.taxaRendimento = taxaRendimento;
	}
}
