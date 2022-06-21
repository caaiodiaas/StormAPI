package com.ufersa.pw.storm.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ufersa.pw.storm.api.dto.CompraDTO;
import com.ufersa.pw.storm.domain.entity.Compra;
import com.ufersa.pw.storm.domain.repository.CompraRepository;

@Service
public class CompraService {
	@Autowired
	private ModelMapper mapper;
    @Autowired
    CompraRepository repository;

    public CompraDTO adicionar(Compra compra){
        return mapper.map(repository.save(compra), CompraDTO.class);
    }

    public List<CompraDTO> listarTodos(){
		List<CompraDTO> list = new ArrayList<CompraDTO>();
		for (Compra compra : repository.findAll()) {
			list.add(mapper.map(compra, CompraDTO.class));
		}
        return list;
    }

    public void excluir (Compra compra) {
		repository.delete(compra);
	}

    public ResponseEntity<Compra> editar(@PathVariable Long compraId, @RequestBody Compra compra){
		if(!repository.existsById(compraId)) {
			return ResponseEntity.notFound().build();
		}
		compra = repository.save(compra);
		return ResponseEntity.ok(compra);
	}

    public ResponseEntity<Compra> buscar(@PathVariable Long compraId){
		return repository.findById(compraId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
