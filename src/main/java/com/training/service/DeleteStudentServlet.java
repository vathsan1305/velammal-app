package com.training.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.MySqlSConnection;

import java.io.IOException;
import java.sql.SQLException;

import entity.Student;
import ifaces.Dao;
import impl.StudentDaoImplementation;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/deletestudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Dao<Student> dao;
    public DeleteStudentServlet() throws SQLException {
        super();
        // TODO Auto-generated constructor stub
        
        dao = new StudentDaoImplementation(MySqlSConnection.getMySqlConnection());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int numberToFind=(Integer.parseInt(request.getParameter("id")));
		
		try {
			boolean result = dao.delete(dao.findById(numberToFind));
			if(result) {
				request.setAttribute("result", "one row deleted");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		/*Student student = new Student();
		student.setRollNumber(rollNumber);
		
		try {
			boolean result= dao.delete(student);
			if(result) {
				response.getWriter().println("Success");
			}
			else {
				response.getWriter().println("failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.setAttribute("result", "one attribute deleted");
		@SuppressWarnings("unused")
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");*/
		doGet(request, response);
	}

}
