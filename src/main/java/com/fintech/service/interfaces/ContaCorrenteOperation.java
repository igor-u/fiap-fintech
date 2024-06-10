package com.fintech.service.interfaces;

import com.fintech.model.conta.Conta;
import com.fintech.model.conta.ContaCorrente;

public interface ContaCorrenteOperation {
	
	public void depositar(float valor, Conta conta);
	
	public void sacar(float valor, Conta conta);

	public void transferir(float valor, ContaCorrente contaOrigem, Conta contaDestino);

}
