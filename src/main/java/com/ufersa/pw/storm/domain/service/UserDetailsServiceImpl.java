package com.ufersa.pw.storm.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ufersa.pw.storm.domain.entity.Usuario;
import com.ufersa.pw.storm.domain.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		Usuario currentUser = repository.findUserByEmail(email);
		UserDetails user = new org.springframework.security.core
		          .userdetails.User(email, currentUser.getSenha(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
		return user;
	}
	

}
