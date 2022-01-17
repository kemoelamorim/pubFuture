package br.com.pubfuture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pubfuture.Repository.ContaRepository;
import br.com.pubfuture.controller.dto.ContaDto;
import br.com.pubfuture.models.Conta;

@RestController
@RequestMapping("/contas")
public class ContaController {
	
	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping
	public List<ContaDto> listar() {
		List<Conta> contas = contaRepository.findAll();
		return ContaDto.converter(contas);
	}
	
	//Cadastrar conta
	//Editar conta
	//Remover conta
	//Transferir saldo entre contas
	//Listar saldo total
	
	
}
