package br.com.tadeu.javabank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tadeu.javabank.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findByNome(String nome);
}
