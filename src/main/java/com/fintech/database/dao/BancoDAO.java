package com.fintech.database.dao;

import java.util.List;

import com.fintech.model.banco.Banco;

public interface BancoDAO {
	
	void insert(Banco banco);
	
	List<Banco> getAll();

}
