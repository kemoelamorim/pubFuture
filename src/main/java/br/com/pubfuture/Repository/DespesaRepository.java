package br.com.pubfuture.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pubfuture.models.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
