package br.com.pubfuture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pubfuture.models.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	
	

}
