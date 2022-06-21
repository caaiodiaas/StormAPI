package com.ufersa.pw.storm.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ufersa.pw.storm.domain.entity.Carrinho;
import com.ufersa.pw.storm.domain.entity.Compra;
import com.ufersa.pw.storm.domain.entity.Endereco;

public class UsuarioDTO{
	private Long id;
	private UUID uuid;
	private String nome;
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private String email;
	private String senha;
	private List<Compra> compras = new ArrayList<Compra>();
	private Carrinho carrinho;
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
    public List<Endereco> getEnderecos() {
        return enderecos;
    }
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public List<Compra> getCompras() {
        return compras;
    }
    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
    public Carrinho getCarrinho() {
        return carrinho;
    }
    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
