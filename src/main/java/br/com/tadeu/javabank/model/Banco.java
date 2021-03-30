package br.com.tadeu.javabank.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="t_banco")
public class Banco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	@OneToMany(mappedBy = "banco")
	@JsonIgnore
	private List<Conta> contas;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "banco_cliente", 
		joinColumns = @JoinColumn(name = "banco_id"), 
		inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	private List<Cliente> clientes;
}
