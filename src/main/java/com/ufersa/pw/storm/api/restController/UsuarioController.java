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

import com.ufersa.pw.storm.api.dto.UsuarioDTO;
import com.ufersa.pw.storm.domain.entity.Usuario;
import com.ufersa.pw.storm.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	UsuarioService service;
	
	@GetMapping
	public List<UsuarioDTO> listar(){
		return service.listarTodos();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDTO cadastrar(@Valid @RequestBody Usuario usuario) {
		return service.adicionar(usuario);
	}
	
	@PutMapping("/{usuarioId}")
	public ResponseEntity<Usuario> editar(@PathVariable Long usuarioId, @RequestBody Usuario usuario){
		return service.editar(usuarioId, usuario);
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId){
		return service.buscar(usuarioId);
	}
}
