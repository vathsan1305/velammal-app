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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@SuppressWarnings("rawtypes")
	private Dao dao;
	
    public WelcomeServlet() throws SQLException {
        super();
        // TODO Auto-generated constructor stub
        dao = new StudentDaoImplementation(MySqlSConnection.getMySqlConnection());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("<h1 style='text-align:center'>Velammal Main School</h1>");//can send response
		
		request.setAttribute("title","Velammal Main School" );
		
		try {
			request.setAttribute("list",dao.findAll());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); //can receive response
	}

}
