package com.fintech.service;

import java.util.Map;
import java.util.Optional;

import com.fintech.service.command.Command;
import com.fintech.service.command.factory.ContaCorrenteCommandFactory;
import com.fintech.service.command.operacao.OperacoesContaCorrente;
import com.fintech.service.interfaces.ContaCorrenteOperation;

public class ContaCorrenteService {

	private ContaCorrenteOperation service;

	private ContaCorrenteService(ContaCorrenteOperation service) {
		this.service = service;
	}

	private static ContaCorrenteService instance;

	public static ContaCorrenteService getInstance(ContaCorrenteOperation service){
		if(instance==null){
			instance = new ContaCorrenteService(service);
		}
		return instance;
	}
	
	public void executar(OperacoesContaCorrente operacao, Map<String, Object> params) {
		Optional<Command> command = ContaCorrenteCommandFactory.getInstance(service).getCommand(operacao);
		if(command.isPresent()){
			command.get().executar(params);
		}
		else{
			System.out.println("Command not found for the operation " + operacao);
		}

	}
	
}
