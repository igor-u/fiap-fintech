package com.fintech.service.command.impl.contacorrente;

import java.util.Map;

import com.fintech.model.conta.Conta;
import com.fintech.service.interfaces.ContaCorrenteOperation;

public class Sacar extends ContaCorrenteCommand {

	public Sacar(ContaCorrenteOperation service) {
		super(service);
	}
	
    @Override
    public void executar(Map<String, Object> params) {
    	float valor = (float) params.get("valor");
        Conta conta = (Conta) params.get("numeroConta");
        service.sacar(valor, conta);

    }	
}
