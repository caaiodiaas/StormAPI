package com.ufersa.pw.storm.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ufersa.pw.storm.domain.entity.Carrinho;

public class ProdutoDTO {

	private Long id;
	private UUID uuid;
	private String nome;
    private String categoria;
    private int valor;
    private String descricao;
	private List<Carrinho> carrinhos = new ArrayList<Carrinho>();
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
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }
    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }
}
