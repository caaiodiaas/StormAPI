package com.ufersa.pw.storm.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ufersa.pw.storm.domain.entity.Produto;
import com.ufersa.pw.storm.domain.entity.Usuario;

public class CarrinhoDTO {

    private Long id;
    private UUID uuid;
    private List<Produto> produtos = new ArrayList<Produto>();
    private Usuario comprador;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    public Usuario getComprador() {
        return comprador;
    }
    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }
    
}
