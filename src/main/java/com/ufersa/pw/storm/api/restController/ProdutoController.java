package com.ufersa.pw.storm.api.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ufersa.pw.storm.api.dto.ProdutoDTO;
import com.ufersa.pw.storm.domain.entity.Produto;
import com.ufersa.pw.storm.domain.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	ProdutoService service;
	
	@GetMapping
	public List<ProdutoDTO> listar(){
		return service.listarTodos();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoDTO cadastrar(@Valid @RequestBody Produto produto) {
		return service.adicionar(produto);
	}
	
	@PutMapping("/{produtoId}")
	public ResponseEntity<Produto> editar(@PathVariable Long produtoId, @RequestBody Produto produto){
		return service.editar(produtoId, produto);
	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<Produto> buscar(@PathVariable Long produtoId){
		return service.buscar(produtoId);
	}
}
