package br.com.tadeu.javabank.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
			Date dataCriacao, Boolean ativa, BigDecimal taxaRendimento) {
		super(id, cliente, banco, saldo, dataCriacao, ativa);
		this.taxaRendimento = taxaRendimento;
	}
}
