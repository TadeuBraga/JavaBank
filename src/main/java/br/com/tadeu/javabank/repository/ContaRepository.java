package br.com.tadeu.javabank.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tadeu.javabank.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	public List<Conta> findBySaldoGreaterThan(BigDecimal saldo);

	public List<Conta> findByClienteNomeContaining(String parte);

	public List<Conta> findByClienteNomeStartsWith(String primeiroNome);

	@Query("SELECT c FROM Conta c WHERE c.dataCriacao >= ?1 and c.dataCriacao <= ?2")
	List<Conta> findByDate(Date dtInicial, Date dtFinal);

	@Query("SELECT c FROM Conta c WHERE c.dataCriacao >= :inicial and c.dataCriacao <= :final")
	List<Conta> findByDate2(@Param("inicial") Date dtInicial, @Param("final") Date dtFinal);

	@Query(value = "SELECT c FROM t_conta c "
			+ "WHERE CONVERT(VARCHAR(8), data_criacao, 112) "
			+ ">= CONVERT(VARCHAR(20), ?1, 112) "
			+ "and CONVERT(VARCHAR(8), data_criacao, 112) "
			+ "<= CONVERT(VARCHAR(8), ?2, 112)", nativeQuery = true)
	List<Conta> findByDateNativo(Date inicial, Date dtFinal);
	
	public List<Conta> findByAtivaTrue();
	
}
