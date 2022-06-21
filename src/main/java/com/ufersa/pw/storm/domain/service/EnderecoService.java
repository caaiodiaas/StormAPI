package com.ufersa.pw.storm.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufersa.pw.storm.api.dto.EnderecoDTO;
import com.ufersa.pw.storm.domain.entity.Endereco;
import com.ufersa.pw.storm.domain.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	EnderecoRepository repository;

    public EnderecoDTO adicionar(Endereco endereco){
        return mapper.map(repository.save(endereco), EnderecoDTO.class);
    }

    public List<EnderecoDTO> listarTodos(){
		List<EnderecoDTO> list = new ArrayList<EnderecoDTO>();
		for (Endereco endereco : repository.findAll()) {
			list.add(mapper.map(endereco, EnderecoDTO.class));
		}
        return list;
    }
	
	public void excluir (Endereco endereco) {
		repository.delete(endereco);
	}
	
	public ResponseEntity<Endereco> editar(Long enderecoId, Endereco endereco){
		if(!repository.existsById(enderecoId)) {
			return ResponseEntity.notFound().build();
		}
		endereco = repository.save(endereco);
		return ResponseEntity.ok(endereco);
	}
	
	public ResponseEntity<Endereco> buscar(Long enderecoId){
		return repository.findById(enderecoId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
