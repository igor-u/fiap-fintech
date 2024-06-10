package com.fintech.service;

import java.util.Map;
import java.util.Optional;

import com.fintech.service.command.Command;
import com.fintech.service.command.factory.ContaPoupancaCommandFactory;
import com.fintech.service.command.operacao.OperacoesContaPoupanca;
import com.fintech.service.interfaces.ContaPoupancaOperation;

public class ContaPoupancaService {

	private ContaPoupancaOperation service;

	private ContaPoupancaService(ContaPoupancaOperation service) {
		this.service = service;
	}

	private static ContaPoupancaService instance;

	public static ContaPoupancaService getInstance(ContaPoupancaOperation service){
		if(instance==null){
			instance = new ContaPoupancaService(service);
		}
		return instance;
	}
	
	public void executar(OperacoesContaPoupanca operacao, Map<String, Object> params) {
		Optional<Command> command = ContaPoupancaCommandFactory.getInstance(service).getCommand(operacao);
		if(command.isPresent()){
			command.get().executar(params);
		}
		else{
			System.out.println("Command not found for the operation " + operacao);
		}

	}
	
}
