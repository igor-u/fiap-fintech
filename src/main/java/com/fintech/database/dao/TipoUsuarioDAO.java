package com.fintech.database.dao;

import java.util.List;

import com.fintech.model.usuario.TipoUsuario;

public interface TipoUsuarioDAO {
	
	void insert(TipoUsuario tipo);
	
	List<TipoUsuario> getAll();

}
