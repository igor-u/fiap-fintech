package com.fintech.service.command.impl.contacorrente;

import java.util.Map;

import com.fintech.service.command.Command;
import com.fintech.service.interfaces.ContaCorrenteOperation;

abstract class ContaCorrenteCommand implements Command {
	
	protected ContaCorrenteOperation service;
	
	protected ContaCorrenteCommand(ContaCorrenteOperation service) {
		this.service = service;
	}
	
    @Override
    public abstract void executar(Map<String, Object> params);

}
