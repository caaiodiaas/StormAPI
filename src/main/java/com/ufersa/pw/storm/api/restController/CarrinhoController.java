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

import com.ufersa.pw.storm.api.dto.CarrinhoDTO;
import com.ufersa.pw.storm.domain.entity.Carrinho;
import com.ufersa.pw.storm.domain.service.CarrinhoService;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
	@Autowired
	CarrinhoService service;
	
	@GetMapping
	public List<CarrinhoDTO> listar(){
		return service.listarTodos();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CarrinhoDTO cadastrar(@Valid @RequestBody Carrinho carrinho) {
		return service.adicionar(carrinho);
	}
	
	@PutMapping("/{carrinhoId}")
	public ResponseEntity<Carrinho> editar(@PathVariable Long carrinhoId, @RequestBody Carrinho carrinho){
		return service.editar(carrinhoId, carrinho);
	}
	
	@GetMapping("/{carrinhoId}")
	public ResponseEntity<Carrinho> buscar(@PathVariable Long carrinhoId){
		return service.buscar(carrinhoId);
	}
}
