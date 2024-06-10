package com.fintech.service.command.impl.contapoupanca;

import java.util.Map;

import com.fintech.service.command.Command;
import com.fintech.service.interfaces.ContaPoupancaOperation;

abstract class ContaPoupancaCommand implements Command {
	
	protected ContaPoupancaOperation service;
	
	protected ContaPoupancaCommand(ContaPoupancaOperation service) {
		this.service = service;
	}
	
    @Override
    public abstract void executar(Map<String, Object> params);

}
