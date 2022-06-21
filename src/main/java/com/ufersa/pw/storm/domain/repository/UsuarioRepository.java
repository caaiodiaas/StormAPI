package com.ufersa.pw.storm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufersa.pw.storm.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public Usuario findUserByEmail(String email);
}
