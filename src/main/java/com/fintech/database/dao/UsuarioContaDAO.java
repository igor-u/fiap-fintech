package com.fintech.database.dao;

import java.util.List;

import com.fintech.model.usuario.UsuarioComConta;

public interface UsuarioContaDAO {
	
	void insert(UsuarioComConta usuarioComConta);
	
	List<UsuarioComConta> getAll();

}
