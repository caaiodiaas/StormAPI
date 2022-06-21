package com.ufersa.pw.storm.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private UUID uuid;

  @NotBlank(message = "Nome não pode ser vazio.")
  private String nome;

  @OneToMany(mappedBy = "usuario")
  private List<Endereco> enderecos = new ArrayList<Endereco>();

  @Column(unique = true)
  @NotBlank(message = "Email não pode ser vazio.")
  @Email(message = "Email deve ser válido.")
  private String email;

  @NotBlank(message = "Senha não pode ser vazia.")
  @Size(
    min = 6,
    max = 150,
    message = "Senha deve possuir de 6 a 150 caracteres."
  )
  private String senha;

  @OneToMany(mappedBy = "comprador")
  private List<Compra> compras = new ArrayList<Compra>();

  @OneToOne
  @JoinColumn(name = "id_carrinho")
  private Carrinho carrinho;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Usuario() {
    setUuid(UUID.randomUUID());
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public List<Endereco> getEndereco() {
    return enderecos;
  }

  public void setEndereco(List<Endereco> enderecos) {
    this.enderecos = enderecos;
  }

  public List<Compra> getCompras() {
    return compras;
  }

  public void setCompras(List<Compra> compras) {
    this.compras = compras;
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
    Usuario other = (Usuario) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
