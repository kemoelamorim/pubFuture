package br.com.pubfuture.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pubfuture.models.Conta;
import br.com.pubfuture.models.TipoConta;

public class ContaDto {

	private Long id;
	private double saldo;
	private String instituicaoFinanceira;
	private TipoConta tipoConta;
	
	public ContaDto(Conta conta) {
		
		this.id = conta.getId();
		this.saldo = conta.getSaldo();
		this.instituicaoFinanceira = conta.getInstituicaoFinanceira();
		this.tipoConta = conta.getTipoConta();
	}
	
	public Long getId() {
		return id;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public static List<ContaDto> converter(List<Conta> contas) {
		
		return contas.stream().map(ContaDto::new).collect(Collectors.toList());
	}

	
}
