package com.fintech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.fintech.database.dao.ContaDAO;
import com.fintech.database.dao.DAOFactory;
import com.fintech.model.conta.Conta;
import com.fintech.model.conta.ContaCorrente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class VincularConta
 */
@WebServlet("/vincular_conta_bancaria")
public class ServletVincularContaBancaria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContaDAO contaDao = DAOFactory.getContaDAO();

    /**
     * Default constructor. 
     */
    public ServletVincularContaBancaria() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idConta = request.getParameter("idConta");
		String numeroConta = request.getParameter("numeroConta");
		String numeroAgencia = request.getParameter("numeroAgencia");
		String codigoBanco = request.getParameter("codigoBanco");
		
		Conta conta = new ContaCorrente(idConta, codigoBanco, numeroAgencia, numeroConta);
		
		try {

			float saldo = Float.parseFloat(request.getParameter("saldo").replace(",", "."));
			conta.setSaldo(saldo);

			contaDao.insert(conta);
			
			HttpSession session = request.getSession();
			session.setAttribute("conta", conta);
			
			response.sendRedirect("index.jsp");
		} catch (RuntimeException | SQLException e) {
			response.sendRedirect("vincular_conta_bancaria.jsp?erro=campo_invalido");
			e.printStackTrace();
		}
		
	}

}
