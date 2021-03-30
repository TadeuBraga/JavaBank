package br.com.tadeu.javabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tadeu.javabank.model.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long> {
	Banco findByNome(String nome);
}
