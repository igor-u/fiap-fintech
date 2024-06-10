package com.fintech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.fintech.database.dao.DAOFactory;
import com.fintech.database.dao.UsuarioDAO;
import com.fintech.model.usuario.TipoUsuario;
import com.fintech.model.usuario.Usuario;
import com.fintech.model.usuario.UsuarioBuilder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/criar_conta")
public class ServletCriarConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
    /**
     * Default constructor. 
     */
    public ServletCriarConta() {
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
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario user = new UsuarioBuilder()
				.comTipo(TipoUsuario.USUARIO_PESSOA)
				.comId(cpf)
				.comNome(nome)
				.comEmail(email)
				.comHashSenha(senha)
				.build();
		
		try {
			userDao.insert(user);
			
			HttpSession session = request.getSession();
	        session.setAttribute("nome_usuario", user.getNome());
			
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			response.sendRedirect("criar_conta.html");
			e.printStackTrace();
		}

	}

}
