package com.fintech.database.dao;

import java.sql.SQLException;
import java.util.List;

import com.fintech.model.usuario.Usuario;

public interface UsuarioDAO {
	
	void insert(Usuario usuario) throws SQLException;
	
	Usuario findByEmail(String email);
	
	List<Usuario> getAll();

}
