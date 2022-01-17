package br.com.pubfuture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pubfuture.models.Conta;
@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	

}
