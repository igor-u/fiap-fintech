package com.fintech.model.conta;

import java.time.LocalDate;

public class Movimentacao {
	
	private LocalDate data;
	private String descricao;
	private float valor;
	private String conta;

	public Movimentacao() {
		
	}
	
	public Movimentacao(LocalDate data, String descricao, float valor, String conta) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.conta = conta;
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}

}
