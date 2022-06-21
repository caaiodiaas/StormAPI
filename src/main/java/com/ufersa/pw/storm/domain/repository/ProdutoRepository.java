package com.ufersa.pw.storm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufersa.pw.storm.domain.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
