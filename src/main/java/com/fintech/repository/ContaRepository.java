package com.fintech.repository;

import com.fintech.model.conta.Conta;

public interface ContaRepository {
	
	public Conta inserir(Conta conta);
	
	public void excluir(String numeroConta);

}
