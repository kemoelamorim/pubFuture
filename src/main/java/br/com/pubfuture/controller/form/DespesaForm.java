package br.com.pubfuture.controller.form;

import java.time.LocalDateTime;


import br.com.pubfuture.Repository.ContaRepository;
import br.com.pubfuture.models.Conta;
import br.com.pubfuture.models.Despesa;
import br.com.pubfuture.models.TipoDespesa;

public class DespesaForm {

	private double valor;
	private LocalDateTime dataPagamentoEsperado;
	private TipoDespesa tipoDespesa;

	private Long conta;

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void setDataPagamentoEsperado(LocalDateTime dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}
	
	public Despesa converter(ContaRepository contaRepository) {
		Conta conta = contaRepository.getById(this.getConta());
		return new Despesa(valor, dataPagamentoEsperado,this.getTipoDespesa(), conta);
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}
	
	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	
	public Long getConta() {
		return conta;
	}

	public void setConta(Long conta) {
		this.conta = conta;
	}
}
