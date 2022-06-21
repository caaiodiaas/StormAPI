package com.ufersa.pw.storm.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_produtos")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private UUID uuid;

  @NotBlank(message = "Nome não pode ser vazio.")
  private String nome;

  @NotBlank(message = "Categoria não pode ser vazio.")
  private String categoria;

  // @NotBlank(message= "Valor não pode ser vazio.")
  private int valor;
  private String descricao;

  @OneToMany(mappedBy = "produto")
  private List<Compra> vendas = new ArrayList<Compra>();

  @ManyToMany(mappedBy = "produtos")
  private List<Carrinho> carrinhos = new ArrayList<Carrinho>();

  public Produto() {
    setUuid(UUID.randomUUID());
  }

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

  public List<Compra> getVendas() {
    return vendas;
  }

  public void setVendas(List<Compra> vendas) {
    this.vendas = vendas;
  }

  public List<Carrinho> getCarrinhos() {
    return carrinhos;
  }

  public void setCarrinhos(List<Carrinho> carrinhos) {
    this.carrinhos = carrinhos;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Produto other = (Produto) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
