package com.fintech.model.conta;

public class ContaCorrente extends Conta {

	public ContaCorrente(String idConta, String codigoBanco, String numeroAgencia, String numeroConta) {
		super(idConta, codigoBanco, numeroAgencia, numeroConta);
	}

	public ContaCorrente() {
	}

	@Override
	public String getTipo() {
		return "1";
	}

}
