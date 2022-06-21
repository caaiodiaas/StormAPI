package com.ufersa.pw.storm.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ufersa.pw.storm.api.dto.UsuarioDTO;
import com.ufersa.pw.storm.domain.entity.Usuario;
import com.ufersa.pw.storm.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	UsuarioRepository repository;

    public UsuarioDTO adicionar(Usuario usuario){
        return mapper.map(repository.save(usuario), UsuarioDTO.class);
    }

    public List<UsuarioDTO> listarTodos(){
		List<UsuarioDTO> list = new ArrayList<UsuarioDTO>();
		for (Usuario usuario : repository.findAll()) {
			list.add(mapper.map(usuario, UsuarioDTO.class));
		}
        return list;
    }

    public void excluir (Usuario usuario) {
		repository.delete(usuario);
	}

    public ResponseEntity<Usuario> editar(@PathVariable Long usuarioId, @RequestBody Usuario usuario){
		if(!repository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
		}
		usuario = repository.save(usuario);
		return ResponseEntity.ok(usuario);
	}

    public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId){
		return repository.findById(usuarioId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
