package com.fintech.model.usuario;

import java.util.List;

import com.fintech.model.conta.Conta;

public class UsuarioBuilder {

	private Usuario user = new Usuario();
	
	public UsuarioBuilder comTipo(TipoUsuario tipo){
		user.setTipo(tipo);
		return this;
	}

	public UsuarioBuilder comId(String id){
		user.setId(id);
		return this;
	}
	
	public UsuarioBuilder comNome(String nome){
		user.setNome(nome);
		return this;
	}
	
	public UsuarioBuilder comEmail(String email){
		user.setEmail(email);
		return this;
	}
	
	public UsuarioBuilder comHashSenha(String hashSenha){
		user.setHashSenha(hashSenha);
		return this;
	}
	
	public UsuarioBuilder comTelefone(String telefone){
		user.setTelefone(telefone);
		return this;
	}

	public UsuarioBuilder comContas(List<Conta> contas){
		user.setContas(contas);
		return this;
	}

	public Usuario build(){
		return user;
	}
	
}
