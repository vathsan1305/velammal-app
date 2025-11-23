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
import java.time.LocalDate;

import entity.Student;
import ifaces.Dao;
import impl.StudentDaoImplementation;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Dao<Student> dao;
    public AddStudentServlet() throws SQLException{
        super();
        // TODO Auto-generated constructor stub
        dao = new StudentDaoImplementation(MySqlSConnection.getMySqlConnection());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rollNumber=Integer.parseInt(request.getParameter("rollNumber"));
		String firstName=request.getParameter("firstName");
		LocalDate dateOfBirth=LocalDate.parse(request.getParameter("dateOfBirth"));
		int markScored = Integer.parseInt(request.getParameter("markScored"));
		
		try {
			boolean result=dao.add(new Student(rollNumber,firstName,markScored,dateOfBirth));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		request.setAttribute("result", "one attribute added");
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

}
