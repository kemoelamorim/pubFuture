package br.com.pubfuture.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.pubfuture.models.Conta;
import br.com.pubfuture.models.Receita;
import br.com.pubfuture.models.TipoReceita;

public class ReceitaDto {
	private Long id;
	private double valor;
	private LocalDateTime dataRecebimento;
	private LocalDateTime  dataRecebimentoEsperado;
	private String descricao;
	private TipoReceita tipoReceita;
	private Conta conta;
	
	public ReceitaDto(Receita receita) {
		
		this.id = receita.getId();
		this.valor = receita.getValor();
		this.dataRecebimento = receita.getDataRecebimento();
		this.dataRecebimentoEsperado = receita.getDataRecebimento();
		this.descricao = receita.getDescricao();
		this.tipoReceita = receita.getTipoReceita();
		this.conta = receita.getConta();
	}
	public Long getId() {
		return id;
	}
	public double getValor() {
		return valor;
	}
	public LocalDateTime getDataRecebimento() {
		return dataRecebimento;
	}
	public LocalDateTime getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}
	public String getDescricao() {
		return descricao;
	}
	public static List<ReceitaDto> converter(List<Receita> receitas) {
		
		return receitas.stream().map(ReceitaDto::new).collect(Collectors.toList());
	}
	public Conta getConta() {
		return conta;
	}
	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}
}
