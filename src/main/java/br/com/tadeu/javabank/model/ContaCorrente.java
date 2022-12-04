package br.com.tadeu.javabank.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_conta_corrente")
public final class ContaCorrente extends Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal limiteEspecial;

	@Builder
	public ContaCorrente(Long id, Cliente cliente, Banco banco, BigDecimal saldo, LocalDateTime dataCriacao, Boolean ativa,
						 BigDecimal limiteEspecial) {
		super(id, cliente, banco, saldo, dataCriacao, ativa);
		this.limiteEspecial = limiteEspecial;
	}

}
