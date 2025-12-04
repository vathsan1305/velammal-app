package com.training.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.MySqlSConnection;

import java.io.IOException;
import java.sql.SQLException;

import ifaces.Dao;
import impl.StudentDaoImplementation;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("rawtypes")
	private Dao dao;

	// ❗ Constructor must NOT open database connection
	public WelcomeServlet() {
		super();
	}

	// ❗ Correct place to initialize DAO
	@Override
	public void init() throws ServletException {
		try {
			dao = new StudentDaoImplementation(MySqlSConnection.getMySqlConnection());
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("title","Velammal Main School" );
		
		try {
			request.setAttribute("list",dao.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
