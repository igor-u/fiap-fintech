package com.fintech.service.command.impl.contacorrente;

import java.util.Map;

import com.fintech.model.conta.Conta;
import com.fintech.service.interfaces.ContaCorrenteOperation;

public class Depositar extends ContaCorrenteCommand {

	public Depositar(ContaCorrenteOperation service) {
		super(service);
	}
	
    @Override
    public void executar(Map<String, Object> params) {
    	float valor = (float) params.get("valor");
        Conta conta = (Conta) params.get("conta");
        service.depositar(valor, conta);

    }

}
