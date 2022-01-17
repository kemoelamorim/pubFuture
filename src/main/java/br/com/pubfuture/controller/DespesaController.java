package br.com.pubfuture.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pubfuture.Repository.ContaRepository;
import br.com.pubfuture.Repository.DespesaRepository;
import br.com.pubfuture.controller.dto.DespesaDto;
import br.com.pubfuture.controller.form.DespesaForm;
import br.com.pubfuture.models.Despesa;	

@RestController
@RequestMapping("/despesas")
public class DespesaController {

	@Autowired
	DespesaRepository despesaRepository;
	@Autowired
	ContaRepository contaRepository;
	
	//Listar despesas
	@GetMapping
	public List<DespesaDto> listar(){
		List <Despesa> despesas = despesaRepository.findAll();
		return DespesaDto.converter(despesas);
	}
	
	//Cadastrar despesas
	@PostMapping
	public ResponseEntity<DespesaDto> cadastrar(@RequestBody DespesaForm form, UriComponentsBuilder uriBuilder) {
		Despesa despesa = form.converter(contaRepository);
		despesaRepository.save(despesa);
		
		URI uri = uriBuilder.path("/despesas/{id}").buildAndExpand(despesa.getId()).toUri();
		return ResponseEntity.created(uri).body(new DespesaDto(despesa));
	}
	//Editar despesas
	//Remover despesas
	//Listar Filtro por período (dataInicial – dataFinal)
	//Listar Filtro por tipo de despesa
}
