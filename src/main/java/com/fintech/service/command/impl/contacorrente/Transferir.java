package com.fintech.service.command.impl.contacorrente;

import java.util.Map;

import com.fintech.model.conta.Conta;
import com.fintech.model.conta.ContaCorrente;
import com.fintech.service.interfaces.ContaCorrenteOperation;

public class Transferir extends ContaCorrenteCommand {
	
	public Transferir(ContaCorrenteOperation service) {
		super(service);
	}
	
    @Override
    public void executar(Map<String, Object> params) {
    	float valor = (float) params.get("valor");
        ContaCorrente contaOrigem = (ContaCorrente) params.get("contaOrigem");
        Conta contaDestino = (Conta) params.get("contaDestino");
        service.transferir(valor, contaOrigem, contaDestino);

    }	

}
