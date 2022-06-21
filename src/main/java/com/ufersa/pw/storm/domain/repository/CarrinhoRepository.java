package com.ufersa.pw.storm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufersa.pw.storm.domain.entity.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{
    
}
