package com.fintech.service.command.impl.contapoupanca;

import java.util.Map;

import com.fintech.model.conta.Conta;
import com.fintech.service.interfaces.ContaPoupancaOperation;

public class Sacar extends ContaPoupancaCommand {

	public Sacar(ContaPoupancaOperation service) {
		super(service);
	}
	
    @Override
    public void executar(Map<String, Object> params) {
    	float valor = (float) params.get("valor");
        Conta conta = (Conta) params.get("conta");
        service.sacar(valor, conta);

    }	
}
