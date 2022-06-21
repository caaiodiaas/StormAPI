package com.ufersa.pw.storm.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ufersa.pw.storm.api.dto.ProdutoDTO;
import com.ufersa.pw.storm.domain.entity.Produto;
import com.ufersa.pw.storm.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	ProdutoRepository repository;

    public ProdutoDTO adicionar(Produto produto){
        return mapper.map(repository.save(produto), ProdutoDTO.class);
    }

    public List<ProdutoDTO> listarTodos(){
		List<ProdutoDTO> list = new ArrayList<ProdutoDTO>();
		for (Produto produto : repository.findAll()) {
			list.add(mapper.map(produto, ProdutoDTO.class));
		}
        return list;
    }

    public void excluir (Produto produto) {
		repository.delete(produto);
	}

    public ResponseEntity<Produto> editar(@PathVariable Long produtoId, @RequestBody Produto produto){
		if(!repository.existsById(produtoId)) {
			return ResponseEntity.notFound().build();
		}
		produto = repository.save(produto);
		return ResponseEntity.ok(produto);
	}

    public ResponseEntity<Produto> buscar(@PathVariable Long produtoId){
		return repository.findById(produtoId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
