package com.fintech.repository;

import java.util.List;

import com.fintech.model.conta.Conta;
import com.fintech.model.usuario.Usuario;

public interface UsuarioRepository {

	public Usuario inserir(Usuario user);
	
	public void excluir(Usuario user);

	public void vincularConta(Usuario user, Conta conta);

	public void desvincularConta(Usuario user, String numeroConta);

	public List<Usuario> listarUsuarios();
	
}
