package br.com.pubfuture.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.pubfuture.models.Conta;
import br.com.pubfuture.models.Despesa;
import br.com.pubfuture.models.TipoDespesa;

public class DespesaDto {
	
	private Long id;
	private double valor;
	private LocalDateTime dataPagamento;
	private LocalDateTime dataPagamentoEsperado;
	private TipoDespesa tipoDespesa;
	private Conta conta;

	public DespesaDto(Despesa despesa) {
		
		this.id = despesa.getId();
		this.valor = despesa.getValor();
		this.dataPagamento = despesa.getDataPagamento();
		this.dataPagamentoEsperado = despesa.getDataPagamentoEsperado();
		this.conta = despesa.getConta();
		this.tipoDespesa = despesa.getTipoDespesa();
	}
	
	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}
	
	public Long getId() {
		return id;
	}
	public double getValor() {
		return valor;
	}
	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}
	public LocalDateTime getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}
	public Conta getConta() {
		return conta;
	}
	public static List<DespesaDto> converter(List<Despesa> despesas) {
		
		return despesas.stream().map(DespesaDto::new).collect(Collectors.toList());
	}
}
