package com.fintech.servlet;

import java.io.IOException;

import com.fintech.database.dao.DAOFactory;
import com.fintech.database.dao.UsuarioDAO;
import com.fintech.model.usuario.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
    /**
     * Default constructor. 
     */
    public ServletLogin() {
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
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario user = userDao.findByEmail(email);
		
		if (user != null && senha.equals(user.getHashSenha())) {
	        HttpSession session = request.getSession();
	        session.setAttribute("nome_usuario", user.getNome());
			response.sendRedirect("index.jsp");
		} else {
	        response.sendRedirect("login.html");
	    }
	}

}
