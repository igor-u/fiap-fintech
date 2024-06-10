package com.fintech.app;

import java.sql.SQLException;

import com.fintech.database.dao.BancoDAO;
import com.fintech.database.dao.ContaDAO;
import com.fintech.database.dao.DAOFactory;
import com.fintech.database.dao.TipoContaDAO;
import com.fintech.database.dao.TipoUsuarioDAO;
import com.fintech.database.dao.UsuarioContaDAO;
import com.fintech.database.dao.UsuarioDAO;
import com.fintech.model.banco.Banco;
import com.fintech.model.conta.Conta;
import com.fintech.model.conta.ContaCorrente;
import com.fintech.model.conta.ContaPoupanca;
import com.fintech.model.conta.TipoConta;
import com.fintech.model.usuario.TipoUsuario;
import com.fintech.model.usuario.Usuario;
import com.fintech.model.usuario.UsuarioBuilder;
import com.fintech.model.usuario.UsuarioComConta;

public class TesteConexaoInsert {

	public static void main(String[] args) throws SQLException {

		TipoUsuarioDAO tpUserDao = DAOFactory.getTipoUsuarioDAO();
		tpUserDao.insert(TipoUsuario.USUARIO_PESSOA);
		tpUserDao.insert(TipoUsuario.USUARIO_EMPRESA);
		
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		Usuario user1 = new UsuarioBuilder()
				.comTipo(TipoUsuario.USUARIO_PESSOA)
				.comId("123456789")
				.comNome("Joao")
				.comEmail("joao@email.com")
				.comHashSenha("4b245cabbf7775ef8fc5705a9f1f9b1g")
				.build();		
		Usuario user2 = new UsuarioBuilder()
				.comTipo(TipoUsuario.USUARIO_PESSOA)
				.comId("987654321")
				.comNome("Maria")
				.comEmail("maria@email.com")
				.comHashSenha("3c378baccf5555ed8fc5505a9f1f9s7m")
				.build();
		userDao.insert(user1);
		userDao.insert(user2);
		
		BancoDAO bancoDao = DAOFactory.getBancoDAO();
		Banco banco1 = new Banco("033", "Santander");
		Banco banco2 = new Banco("001", "Banco do Brasil");
		Banco banco3 = new Banco("260", "Nubank");
		bancoDao.insert(banco1);
		bancoDao.insert(banco2);
		bancoDao.insert(banco3);

		TipoContaDAO tpContaDao = DAOFactory.getTipoContaDAO();
		tpContaDao.insert(TipoConta.CONTA_CORRENTE);
		tpContaDao.insert(TipoConta.CONTA_POUPANCA);
		
		ContaDAO contaDao = DAOFactory.getContaDAO();
		Conta conta1 = new ContaCorrente("1", banco1.getCodigo(), "0123", "0123456789");
		Conta conta2 = new ContaPoupanca("2", banco2.getCodigo(), "0125", "1234567890");
		Conta conta3 = new ContaCorrente("3", banco3.getCodigo(), "2345", "2345678901");
		contaDao.insert(conta1);
		contaDao.insert(conta2);
		contaDao.insert(conta3);

		
		UsuarioComConta userComConta1 = new UsuarioComConta(user1.getId(), conta1.getNumeroAgencia(),
				conta1.getCodigoBanco(),
				conta1.getNumeroConta());
		UsuarioComConta userComConta2 = new UsuarioComConta(user2.getId(), conta2.getNumeroAgencia(),
				conta2.getCodigoBanco(),
				conta2.getNumeroConta());
		UsuarioComConta userComConta3 = new UsuarioComConta(user2.getId(), conta3.getNumeroAgencia(),
				conta3.getCodigoBanco(),
				conta3.getNumeroConta());

		UsuarioContaDAO usuarioContaDao = DAOFactory.getUsuarioContaDAO();
		usuarioContaDao.insert(userComConta1);
		usuarioContaDao.insert(userComConta2);
		usuarioContaDao.insert(userComConta3);

	}

}
