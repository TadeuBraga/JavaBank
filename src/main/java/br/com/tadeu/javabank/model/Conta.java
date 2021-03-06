package br.com.tadeu.javabank.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	private Date dataCriacao;
	private Boolean ativa = true;	
}
