package com.fintech.database.dao;

import java.util.List;

import com.fintech.model.conta.TipoConta;

public interface TipoContaDAO {
	
	void insert(TipoConta tipo);
	
	List<TipoConta> getAll();

}
