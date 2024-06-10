package com.fintech.service.interfaces.impl;

import com.fintech.model.conta.Conta;
import com.fintech.model.conta.ContaCorrente;
import com.fintech.service.interfaces.ContaCorrenteOperation;

public class ContaCorrenteOperationImpl implements ContaCorrenteOperation {

	private static final ContaCorrenteOperationImpl instance = new ContaCorrenteOperationImpl();

	private ContaCorrenteOperationImpl() {

	}

	public static ContaCorrenteOperationImpl getInstance(){
		return instance;
	}
	
	@Override
	public void depositar(float valor, Conta conta) {
		conta.setSaldo(conta.getSaldo() + valor);
	}

	@Override
	public void sacar(float valor, Conta conta) {
		conta.setSaldo(conta.getSaldo() - valor);
		
	}

	@Override
	public void transferir(float valor, ContaCorrente contaOrigem, Conta contaDestino) {
		sacar(valor, contaOrigem);
		depositar(valor, contaDestino);
		
	}
	
}
