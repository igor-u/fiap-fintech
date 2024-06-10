package com.fintech.service.interfaces.impl;

import com.fintech.model.conta.Conta;
import com.fintech.service.interfaces.ContaPoupancaOperation;

public class ContaPoupancaOperationImpl implements ContaPoupancaOperation {
	
	private static final ContaPoupancaOperationImpl instance = new ContaPoupancaOperationImpl();

	private ContaPoupancaOperationImpl() {

	}

	public static ContaPoupancaOperationImpl getInstance(){
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

}
