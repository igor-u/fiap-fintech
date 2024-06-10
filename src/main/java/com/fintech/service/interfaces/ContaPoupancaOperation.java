package com.fintech.service.interfaces;

import com.fintech.model.conta.Conta;

public interface ContaPoupancaOperation {

	public void depositar(float valor, Conta conta);
	
	public void sacar(float valor, Conta conta);

}
