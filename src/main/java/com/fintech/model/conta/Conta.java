package com.fintech.model.conta;

import java.util.List;
import com.fintech.model.usuario.Usuario;

public abstract class Conta {
	
	protected String idConta;
	protected String numeroConta;
	protected String numeroAgencia;
	protected String codigoBanco;
	//saldo deveria ser BigDecimal, float para facilitar conexao com db
	protected float saldo;
	protected Usuario titular;
	protected List<Movimentacao> movimentacoes;
	protected List<Cartao> cartoes;
	
	public Conta(String idConta, String codigoBanco, String numeroAgencia, String numeroConta) {
		this.idConta = idConta;
		this.codigoBanco = codigoBanco;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.saldo = 0;
	}
	
	public Conta() {
	}
	
	@Override
	public String toString() {
		return "Conta{" +
				"cd_banco: " + this.codigoBanco + ";" +
				"\n" + "nr_agencia: " + this.numeroAgencia + ";" +
				"\n" + "nr_Conta: " + this.numeroConta + ";" +
				"\n" + "saldo: " + this.saldo + ";" +
				"\n" + "tipo: " + this.getTipo() + "}\n"; 
	}
	
	public String getIdConta() { return idConta; }
	public void setIdConta(String id) {
		this.idConta = id;
	}
	public String getNumeroAgencia() { return numeroAgencia; }
	public void setNumeroAgencia(String numeroAgencia) { this.numeroAgencia = numeroAgencia; }
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public Usuario getTitular() {
		return titular;
	}
	public void setTitular(Usuario titular) {
		this.titular = titular;
	}
	public String getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public List<Movimentacao> getMovimentacoes() { return movimentacoes; }
	public void setMovimentacoes(List<Movimentacao> movimentacoes) { this.movimentacoes = movimentacoes; }
	public List<Cartao> getCartoes() { return cartoes; }
	public void setCartoes(List<Cartao> cartoes) { this.cartoes = cartoes; }
	
	public String getTipo() {
		return null;
	}
}
