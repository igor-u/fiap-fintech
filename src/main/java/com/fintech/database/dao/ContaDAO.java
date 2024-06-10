package com.fintech.database.dao;

import java.sql.SQLException;
import java.util.List;

import com.fintech.model.conta.Conta;

public interface ContaDAO {

	void insert(Conta conta) throws SQLException;
	
	List<Conta> getAll();
	
	void transferir(float valor, String origem, String destino) throws SQLException;

	Conta findById(String id);
	
}
