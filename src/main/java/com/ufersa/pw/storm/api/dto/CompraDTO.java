package com.ufersa.pw.storm.api.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ufersa.pw.storm.domain.entity.Produto;
import com.ufersa.pw.storm.domain.entity.Usuario;

public class CompraDTO {

    private Long id;
    private UUID uuid;
    private Produto produto;
    private Usuario comprador;
    private LocalDateTime data;
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
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Usuario getComprador() {
        return comprador;
    }
    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
