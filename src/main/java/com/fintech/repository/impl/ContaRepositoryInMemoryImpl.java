package com.fintech.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.fintech.model.conta.Conta;
import com.fintech.model.usuario.Usuario;
import com.fintech.repository.ContaRepository;

public class ContaRepositoryInMemoryImpl implements ContaRepository {
	
	private List<Conta> contas = new ArrayList<Conta>();
	
	private static final ContaRepositoryInMemoryImpl instance = new ContaRepositoryInMemoryImpl();

	private ContaRepositoryInMemoryImpl() {

	}

	public static ContaRepositoryInMemoryImpl getInstance(){
		return instance;
	}


	@Override
	public Conta inserir(Conta conta) {
		contas.add(conta);
		return conta;
	}

	@Override
	public void excluir(String idConta) {
		Conta conta = contas.stream().filter(c -> (c.getNumeroAgencia() + c.getCodigoBanco() + c.getNumeroConta())
				== idConta).findFirst().get();
		Usuario titular = UsuarioRepositoryInMemoryImpl.getInstance().listarUsuarios().
				stream().filter(t -> t.getContas().contains(conta)).findFirst().get();
		titular.getContas().remove(conta);
		contas.remove(conta);
		
	}

}
