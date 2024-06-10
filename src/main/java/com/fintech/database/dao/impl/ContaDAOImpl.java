package com.fintech.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fintech.database.FintechDBManager;
import com.fintech.database.dao.ContaDAO;
import com.fintech.model.conta.Conta;
import com.fintech.model.conta.ContaCorrente;
import com.fintech.model.conta.ContaPoupanca;

public class ContaDAOImpl implements ContaDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void insert(Conta conta) throws SQLException {

			conexao = FintechDBManager.obterConexao();
			pstmt = conexao.prepareStatement("INSERT INTO CONTAS "
					+ "(ID_CONTA, SALDO, AGENCIA, CODIGO_BANCO, NUMERO, TIPO_CONTA) " + 
					"VALUES (?, ?, ?, ?, ?, ?)");

			pstmt.setString(1, conta.getIdConta());
			pstmt.setFloat(2, conta.getSaldo());
			pstmt.setString(3, conta.getNumeroAgencia());
			pstmt.setString(4, conta.getCodigoBanco());
			pstmt.setString(5, conta.getNumeroConta());
			pstmt.setString(6, conta.getTipo());

			pstmt.executeUpdate();

	}

	@Override
	public List<Conta> getAll() {
		List<Conta> contas = new ArrayList<Conta>();
		ResultSet resultSet = null;
		conexao = FintechDBManager.obterConexao();

		try {
			pstmt = conexao.prepareStatement("SELECT * FROM CONTAS");
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {

				Conta conta = null;

				if (resultSet.getString("TIPO_CONTA").contains("1")) {
					conta = new ContaCorrente(
							resultSet.getString("ID_CONTA"),
							resultSet.getString("CODIGO_BANCO"),
							resultSet.getString("AGENCIA"),
							resultSet.getString("NUMERO"));
				}
				else
					if (resultSet.getString("TIPO_CONTA").contains("2")) {
						conta = new ContaPoupanca(
								resultSet.getString("ID_CONTA"),
								resultSet.getString("CODIGO_BANCO"),
								resultSet.getString("AGENCIA"),
								resultSet.getString("NUMERO"));
					}

				conta.setSaldo(resultSet.getFloat("SALDO"));

				contas.add(conta);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contas;
	}
	
	@Override
	public Conta findById(String id) {
		Conta account = new ContaCorrente();
		ResultSet resultSet = null;
		conexao = FintechDBManager.obterConexao();

		try {
			pstmt = conexao.prepareStatement(String.format("SELECT * FROM CONTAS WHERE ID_CONTA = '%s'", id));
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {

				Conta conta = new ContaCorrente();

					conta.setIdConta(resultSet.getString("ID_CONTA"));

						account = conta;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;

	}

	@Override
	public void transferir(float valor, String origem, String destino) throws SQLException {
		
		if (findById(origem).getIdConta() == null || findById(destino).getIdConta() == null) {
			throw new SQLException();
		}
		
		conexao = FintechDBManager.obterConexao();
		pstmt = conexao.prepareStatement("UPDATE CONTAS SET SALDO = SALDO - ? WHERE ID_CONTA = ?");
		
		pstmt.setFloat(1, valor);
		pstmt.setString(2, origem);
		
		pstmt.executeUpdate();
		
		pstmt = conexao.prepareStatement("UPDATE CONTAS SET SALDO = SALDO + ? WHERE ID_CONTA = ?");
		
		pstmt.setFloat(1, valor);
		pstmt.setString(2, destino);
		
		pstmt.executeUpdate();
		
	}

}
