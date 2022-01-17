package br.com.pubfuture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pubfuture.Repository.ReceitaRepository;
import br.com.pubfuture.controller.dto.ReceitaDto;
import br.com.pubfuture.models.Receita;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
	
	@Autowired
	ReceitaRepository receitaRepository;
	
	// Lista Total de receitas
	@GetMapping
	public List<ReceitaDto> lista(){
		List<Receita> receitas = receitaRepository.findAll();
		return ReceitaDto.converter(receitas);
	}
	
	//Cadastrar receitas
	//Editar receitas
	//Remover receitas
	//Listar Filtro por período (dataInicial – dataFinal)
	//Listar Filtro por tipo de receita
	
	

}
