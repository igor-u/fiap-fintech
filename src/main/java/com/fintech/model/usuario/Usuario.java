package com.fintech.model.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.fintech.model.conta.Conta;

public class Usuario {

	private String id;
	private String nome;
	private String telefone;
	private String email;
	private String hashSenha;
	private TipoUsuario tipo;
	private List<Conta> contas = new ArrayList<Conta>();

	@Override
	public String toString() {
		return "User{" +
				"id: " + this.id + ";" +
				"\n" + "nome: " + this.nome + ";" +
				"\n" + "telefone: " + this.telefone + ";" +
				"\n" + "email: " + this.email + ";" +
				"\n" + "tipo: " + this.tipo + "}\n";
	}
	
	public String contasToString() {
		StringJoiner contasString = new StringJoiner(", ");
		for (Conta conta : contas) {
			contasString.add(conta.getNumeroConta() +";") ;
		}
		return contasString.toString();
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() { return email;}
	public void setEmail(String email) { this.email = email; }
	public String getHashSenha() { return hashSenha; }
	public void setHashSenha(String hashSenha) { this.hashSenha = hashSenha; }
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

}
