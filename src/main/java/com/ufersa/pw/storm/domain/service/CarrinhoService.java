package com.ufersa.pw.storm.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ufersa.pw.storm.api.dto.CarrinhoDTO;
import com.ufersa.pw.storm.domain.entity.Carrinho;
import com.ufersa.pw.storm.domain.repository.CarrinhoRepository;

@Service
public class CarrinhoService {
    @Autowired
	private ModelMapper mapper;
	@Autowired
    CarrinhoRepository repository;

    public CarrinhoDTO adicionar(Carrinho carrinho){
        return mapper.map(repository.save(carrinho), CarrinhoDTO.class);
    }

    public List<CarrinhoDTO> listarTodos(){
		List<CarrinhoDTO> list = new ArrayList<CarrinhoDTO>();
		for (Carrinho carrinho : repository.findAll()) {
			list.add(mapper.map(carrinho, CarrinhoDTO.class));
		}
        return list;
    }

    public void excluir (Carrinho carrinho) {
		repository.delete(carrinho);
	}

    public ResponseEntity<Carrinho> editar(@PathVariable Long carrinhoId, @RequestBody Carrinho carrinho){
		if(!repository.existsById(carrinhoId)) {
			return ResponseEntity.notFound().build();
		}
		carrinho = repository.save(carrinho);
		return ResponseEntity.ok(carrinho);
	}

    public ResponseEntity<Carrinho> buscar(@PathVariable Long carrinhoId){
		return repository.findById(carrinhoId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
