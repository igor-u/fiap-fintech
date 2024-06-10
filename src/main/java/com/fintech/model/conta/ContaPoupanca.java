package com.fintech.model.conta;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String idConta, String codigoBanco, String numeroAgencia, String numeroConta) {
		super(idConta, codigoBanco, numeroAgencia, numeroConta);
	}
	
	public ContaPoupanca() {
	}

	@Override
	public String getTipo() {
		return "2";
	}

}
