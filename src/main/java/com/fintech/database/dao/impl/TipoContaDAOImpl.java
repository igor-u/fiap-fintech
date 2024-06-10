package com.fintech.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fintech.database.FintechDBManager;
import com.fintech.database.dao.TipoContaDAO;
import com.fintech.model.conta.TipoConta;

public class TipoContaDAOImpl implements TipoContaDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void insert(TipoConta tipo) {

		try {
			conexao = FintechDBManager.obterConexao();
			pstmt = conexao.prepareStatement("INSERT INTO TIPOS_CONTA "
					+ "(ID_TIPO, DESCRICAO) " + 
					"VALUES (?, ?)");


			pstmt.setString(1, tipo.get());
			pstmt.setString(2, tipo.toString());


			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<TipoConta> getAll() {
		List<TipoConta> tipos = new ArrayList<TipoConta>();
		ResultSet resultSet = null;
		conexao = FintechDBManager.obterConexao();

		try {
			pstmt = conexao.prepareStatement("SELECT * FROM TIPOS_CONTA");
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {

				TipoConta tipoConta = null;

				if (resultSet.getString("ID_TIPO").contains("1")) {
					tipoConta = TipoConta.CONTA_CORRENTE;
				}
				else
					if (resultSet.getString("ID_TIPO").contains("2")) {						
						tipoConta = TipoConta.CONTA_POUPANCA;
					}

				tipos.add(tipoConta);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tipos;
	}

}
