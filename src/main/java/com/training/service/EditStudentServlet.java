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
import java.util.List;

import entity.Student;
import ifaces.Dao;
import impl.StudentDaoImplementation;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/editstudent")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Dao<Student> dao;
    public EditStudentServlet() throws SQLException {
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
		
		int numberToEdit=(Integer.parseInt(request.getParameter("id")));
		try {
			Student toEdit=dao.findById(numberToEdit);
			request.setAttribute("obj", toEdit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editstudent.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rollNumber=Integer.parseInt(request.getParameter("rollNumber"));
		String firstName=request.getParameter("firstName");
		LocalDate dateOfBirth=LocalDate.parse(request.getParameter("dateOfBirth"));
		int markScored = Integer.parseInt(request.getParameter("markScored"));
		
		try {
			Student edited = dao.update(new Student(rollNumber,firstName,markScored,dateOfBirth));
			request.setAttribute("list",List.of(edited));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

}
