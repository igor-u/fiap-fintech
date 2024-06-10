package com.fintech.database.dao;

import com.fintech.database.dao.impl.BancoDAOImpl;
import com.fintech.database.dao.impl.ContaDAOImpl;
import com.fintech.database.dao.impl.TipoContaDAOImpl;
import com.fintech.database.dao.impl.TipoUsuarioDAOImpl;
import com.fintech.database.dao.impl.UsuarioContaDAOImpl;
import com.fintech.database.dao.impl.UsuarioDAOImpl;

public abstract class DAOFactory {
	
	public static ContaDAO getContaDAO() {
		return new ContaDAOImpl();
	}
	
	public static TipoUsuarioDAO getTipoUsuarioDAO() {
		return new TipoUsuarioDAOImpl();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static BancoDAO getBancoDAO() {
		return new BancoDAOImpl();
	}
	
	public static TipoContaDAO getTipoContaDAO() {
		return new TipoContaDAOImpl();
	}

	public static UsuarioContaDAO getUsuarioContaDAO() {
		return new UsuarioContaDAOImpl();
	}

}
