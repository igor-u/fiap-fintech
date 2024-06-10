package com.fintech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fintech.database.dao.ContaDAO;
import com.fintech.database.dao.DAOFactory;
import com.fintech.model.conta.Movimentacao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/transferencia")
public class ServletTransferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContaDAO contaDao = DAOFactory.getContaDAO();
	private List<Movimentacao> movimentacoes = new ArrayList<>();
    /**
     * Default constructor. 
     */
    public ServletTransferencia() {
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
		
		float valor;
		String origem = request.getParameter("origem");
		String destino = request.getParameter("destino");
		
		 try {
		        valor = Float.parseFloat(request.getParameter("valor").replace(",", "."));
		    } catch (NumberFormatException e) {
		        response.sendRedirect("transferencia.jsp?erro=valor_invalido");
		        return;
		    }
		
		movimentacoes.add(new Movimentacao(LocalDate.now(), "Transferência", valor, origem + " -> " + destino));
		
		try {
			contaDao.transferir(valor, origem, destino);
			
			HttpSession session = request.getSession();
			session.setAttribute("movimentacoes", movimentacoes);
			
			response.sendRedirect("movimentacoes.jsp");
		} catch (SQLException e) {
			response.sendRedirect("transferencia.jsp?erro=conta_inexistente");
			e.printStackTrace();
		}

	}

}
