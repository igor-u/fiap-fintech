package com.fintech.app;

import com.fintech.database.dao.ContaDAO;
import com.fintech.database.dao.DAOFactory;
import com.fintech.database.dao.UsuarioContaDAO;
import com.fintech.database.dao.UsuarioDAO;

public class TesteConexaoSelect {

	public static void main(String[] args) {
		
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		userDao.getAll().forEach(System.out::println);
		
		ContaDAO contaDao = DAOFactory.getContaDAO();
		contaDao.getAll().forEach(System.out::println);
		
		UsuarioContaDAO userContaDao = DAOFactory.getUsuarioContaDAO();
		userContaDao.getAll().forEach(System.out::println);

	}

}
