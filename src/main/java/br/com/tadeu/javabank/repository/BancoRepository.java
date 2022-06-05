package br.com.tadeu.javabank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tadeu.javabank.model.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long> {
	Optional<Banco> findByNome(String nome);
	Optional<Banco> findByCodigoInternacional(String codigoInternacional);
}
