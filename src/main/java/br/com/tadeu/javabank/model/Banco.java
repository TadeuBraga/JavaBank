package br.com.tadeu.javabank.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
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
	
	private String codigoInternacional;

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
