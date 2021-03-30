package br.com.tadeu.javabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tadeu.javabank.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findByNome(String nome);
}
