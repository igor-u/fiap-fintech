package com.fintech.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fintech.database.FintechDBManager;
import com.fintech.database.dao.UsuarioContaDAO;
import com.fintech.model.usuario.UsuarioComConta;

public class UsuarioContaDAOImpl implements UsuarioContaDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void insert(UsuarioComConta usuarioComConta) {

		try {
			conexao = FintechDBManager.obterConexao();
			pstmt = conexao.prepareStatement("INSERT INTO USUARIO_CONTA "
					+ "(USUARIO, AGENCIA_CONTA, CODIGO_BANCO_CONTA, NUMERO_CONTA) " + 
					"VALUES (?, ?, ?, ?)");


			pstmt.setString(1, usuarioComConta.getUsuario());
			pstmt.setString(2, usuarioComConta.getAgenciaConta());
			pstmt.setString(3, usuarioComConta.getCodigoBancoConta());
			pstmt.setString(4, usuarioComConta.getNumeroConta());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public List<UsuarioComConta> getAll() {
		List<UsuarioComConta> usuariosComConta = new ArrayList<UsuarioComConta>();
		ResultSet resultSet = null;
		conexao = FintechDBManager.obterConexao();

		try {

			pstmt = conexao.prepareStatement("SELECT * FROM USUARIO_CONTA");
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {
				
				UsuarioComConta userComConta = new UsuarioComConta(resultSet.getString("USUARIO"), 
						resultSet.getString("AGENCIA_CONTA"), resultSet.getString("CODIGO_BANCO_CONTA"),
						resultSet.getString("NUMERO_CONTA"));

				usuariosComConta.add(userComConta);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return usuariosComConta;
	}

}
