package com.fintech.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fintech.database.FintechDBManager;
import com.fintech.database.dao.BancoDAO;
import com.fintech.model.banco.Banco;

public class BancoDAOImpl implements BancoDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void insert(Banco banco) {

		try {
		conexao = FintechDBManager.obterConexao();
		pstmt = conexao.prepareStatement("INSERT INTO BANCOS "
				+ "(CODIGO, NOME) " + 
				"VALUES (?, ?)");


		pstmt.setString(1, banco.getCodigo());
		pstmt.setString(2, banco.getNome());

		
		pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Banco> getAll() {
		List<Banco> bancos = new ArrayList<Banco>();
		ResultSet resultSet = null;
		conexao = FintechDBManager.obterConexao();
		
		try {
		pstmt = conexao.prepareStatement("SELECT * FROM BANCOS");
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				
				Banco banco = new Banco(resultSet.getString("CODIGO"), resultSet.getString("NOME"));
				
				bancos.add(banco);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bancos;
	}

}
