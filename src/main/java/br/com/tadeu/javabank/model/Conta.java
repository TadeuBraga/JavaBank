package br.com.tadeu.javabank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_conta")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Cliente cliente;
	@NotNull
	@Valid
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "banco_id")
	private Banco banco;
	@NotNull
	@Column(name = "saldo")
	private BigDecimal saldo;
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;
	private Boolean ativa = true;	
}
