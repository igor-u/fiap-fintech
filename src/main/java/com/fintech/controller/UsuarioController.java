package com.fintech.controller;

import com.fintech.model.conta.Conta;
import com.fintech.model.usuario.Usuario;
import com.fintech.repository.UsuarioRepository;

public class UsuarioController {

	private UsuarioRepository repository;

	private UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
	}

	private static UsuarioController instance;

	public static UsuarioController getInstance(UsuarioRepository repository){
		if(instance==null){
			instance = new UsuarioController(repository);
		}
		return instance;
	}

	public void inserir(Usuario user) {
		repository.inserir(user);
	}
	
	public void excluir(Usuario user) {
		repository.excluir(user);
	}

	public void vincularConta(Usuario user, Conta conta) { repository.vincularConta(user, conta); }

	public void desvincularConta(Usuario user, String codigooConta) {
		repository.desvincularConta(user, codigooConta);
	}

	public void listarUsuarios() {
		repository.listarUsuarios().forEach(System.out::println);;
	}
	
}
