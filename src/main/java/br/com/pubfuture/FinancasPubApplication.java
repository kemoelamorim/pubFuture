package br.com.pubfuture;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pubfuture.Repository.ContaRepository;
import br.com.pubfuture.Repository.DespesaRepository;
import br.com.pubfuture.Repository.ReceitaRepository;
import br.com.pubfuture.models.Conta;
import br.com.pubfuture.models.Despesa;
import br.com.pubfuture.models.Receita;
import br.com.pubfuture.models.TipoConta;
import br.com.pubfuture.models.TipoDespesa;
import br.com.pubfuture.models.TipoReceita;

@SpringBootApplication
public class FinancasPubApplication implements CommandLineRunner{
	
	@Autowired
	private final ContaRepository contaRepository;
	@Autowired
	private final ReceitaRepository receitaRepositorio;
	@Autowired
	private final DespesaRepository despesaRepository;

	public FinancasPubApplication(ContaRepository contaRepository, ReceitaRepository receitaRepositorio, DespesaRepository despesaRepository) {
		this.contaRepository = contaRepository;
		this.despesaRepository = despesaRepository;
		this.receitaRepositorio = receitaRepositorio;
	}

	public static void main(String[] args) {
		SpringApplication.run(FinancasPubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Conta conta = setandoConta(new Conta());
		Despesa despesa = setandoDespesa(new Despesa(), conta);
		Receita receita = setandoReceita(new Receita(), conta);
		
		contaRepository.save(conta);
		receitaRepositorio.save(receita);
		despesaRepository.save(despesa);
		
	}
	
	private Conta setandoConta(Conta conta) {
		conta.setTipoConta(TipoConta.CONTA_POUPANCA);
		conta.setSaldo(1500.90);
		conta.setInstituicaoFinanceira("Caixa Economica");
		Conta contaSetada = conta;
		return contaSetada;
	}
	
	private Despesa setandoDespesa(Despesa despesa, Conta conta) {
		LocalDateTime dataDespesa = LocalDateTime.now();
		despesa.setDataPagamento(dataDespesa);
		despesa.setDataPagamentoEsperado(dataDespesa.plusDays(1));
		despesa.setTipoDespesa(TipoDespesa.EDUCACAO);
		despesa.setConta(conta);
		despesa.setValor(100);
		Despesa despesaSetada = despesa;
		return despesaSetada;
	}
	
	private Receita setandoReceita(Receita receita, Conta conta) {
		LocalDateTime dataReceita = LocalDateTime.now();
		receita.setDataRecebimento(dataReceita);
		receita.setDataRecebimentoEsperado(dataReceita.plusDays(2));
		receita.setDescricao("Venda de produto");
		receita.setTipoReceita(TipoReceita.OUTROS);
		receita.setConta(conta);
		receita.setValor(109.0);
		Receita receitaSetada = receita;
		return receitaSetada;
	}

}
