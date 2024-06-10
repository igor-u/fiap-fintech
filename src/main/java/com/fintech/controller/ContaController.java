package com.fintech.controller;

import com.fintech.model.conta.Conta;
import com.fintech.repository.ContaRepository;

public class ContaController {
	
	private ContaRepository repository;

	private ContaController(ContaRepository repository) {
		this.repository = repository;
	}

	private static ContaController instance;

	public static ContaController getInstance(ContaRepository repository){
		if(instance==null){
			instance = new ContaController(repository);
		}
		return instance;
	}

	public void inserir(Conta conta) {
		repository.inserir(conta);
	}
	
	public void excluir(String codigoConta) {
		repository.excluir(codigoConta);
	}
	
}
