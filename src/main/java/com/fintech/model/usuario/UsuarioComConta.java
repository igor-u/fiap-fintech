package com.fintech.model.usuario;

public class UsuarioComConta {
	
	String usuario;
	String agenciaConta;
	String codigoBancoConta;
	String numeroConta;
	
	public UsuarioComConta(String usuario, String agenciaConta, String codigoBancoConta, String numeroConta) {
		super();
		this.usuario = usuario;
		this.agenciaConta = agenciaConta;
		this.codigoBancoConta = codigoBancoConta;
		this.numeroConta = numeroConta;
	}

	@Override
	public String toString() {
		return "User_Conta{" +
				"id_user: " + this.usuario + ";" +
				"\n" + "nr_agnc_conta: " + this.agenciaConta + ";" +
				"\n" + "cd_banco_conta: " + this.codigoBancoConta + ";" +
				"\n" + "nr_conta: " + this.numeroConta + "}\n";
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getAgenciaConta() {
		return agenciaConta;
	}
	public void setAgenciaConta(String agenciaConta) {
		this.agenciaConta = agenciaConta;
	}
	public String getCodigoBancoConta() {
		return codigoBancoConta;
	}
	public void setCodigoBancoConta(String codigoBancoConta) {
		this.codigoBancoConta = codigoBancoConta;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

}
