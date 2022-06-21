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

import com.ufersa.pw.storm.api.dto.CompraDTO;
import com.ufersa.pw.storm.domain.entity.Compra;
import com.ufersa.pw.storm.domain.service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {
	@Autowired
	CompraService service;
	
	@GetMapping
	public List<CompraDTO> listar(){
		return service.listarTodos();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CompraDTO cadastrar(@Valid @RequestBody Compra compra) {
		return service.adicionar(compra);
	}
	
	@PutMapping("/{compraId}")
	public ResponseEntity<Compra> editar(@PathVariable Long compraId, @RequestBody Compra compra){
		return service.editar(compraId, compra);
	}
	
	@GetMapping("/{compraId}")
	public ResponseEntity<Compra> buscar(@PathVariable Long compraId){
		return service.buscar(compraId);
	}
}
