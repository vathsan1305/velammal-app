package impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.Student;
import utils.MySqlSConnection;
import ifaces.Dao;

@SuppressWarnings("unused")
public class StudentDaoImplementation implements Dao<Student> {
	
	private Connection con;
	
	String FINDALL="select * from student_details";//queries calling only once has a separate interface
	String INSERT="insert into student_details values(?,?,?,?)";//queries calling many time has a separate interface
	String FINDBYID="select * from student_details where roll_no = ?";
	String DELETE="delete from student_details where roll_no=?";
	String UPDATE="update student_details SET first_name=?,date_of_birth=?,marks_scored=? where roll_no=?"; //these are all place holders
	
	public StudentDaoImplementation(Connection con) {
		super();
		this.con = con;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Student t) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = con.prepareStatement(INSERT);
		pstmt.setInt(1,t.getRollNumber());
		pstmt.setString(2,t.getFirstName()); 
		pstmt.setInt(3, t.getMarkScored());
		pstmt.setDate(4, Date.valueOf(t.getDateOfBirth())); //type casting
//		pstmt.setString(3,t.getFirstName()); 
//		pstmt.setInt(4, t.getMarkScored());
//		
		int rowAdded = pstmt.executeUpdate();
		
		
		return rowAdded ==1?true:false; 
	}

	@Override
	public Student findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = con.prepareStatement(FINDBYID);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		Student obj = null;
		
		if(rs.next()) {
			 obj=mapperRowToObject(rs);
		}
		
		return obj;
	}

	@Override
	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		 
		PreparedStatement pstmt = con.prepareStatement(FINDALL);
		ResultSet result = pstmt.executeQuery();
		
		List<Student> list = new ArrayList<>(); //to print all the student details
		
		while(result.next()) {
			
		/*int rollNumber = result.getInt("roll_no");
		String firstName = result.getString("first_name");
		Date dob = result.getDate("date_of_birth");
		LocalDate dateOfBirth = dob.toLocalDate();
		int	markScored = result.getInt("marks_scored");
			
			Student student = new Student(rollNumber,firstName,markScored,dateOfBirth);
			
			list.add(student);*/
			list.add(mapperRowToObject(result));
		}
		
		return list; 
	}

	@Override
	public boolean delete(Student t) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = con.prepareStatement(DELETE);
		pstmt.setInt(1,t.getRollNumber());
		int rowDeleted = pstmt.executeUpdate();
		
		
		return rowDeleted ==1?true:false;
	}

	@Override
	public Student update(Student t) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = con.prepareStatement(UPDATE);
		pstmt.setString(1,t.getFirstName());
		pstmt.setDate(2, Date.valueOf(t.getDateOfBirth())); //type casting 
		pstmt.setInt(3, t.getMarkScored());
		pstmt.setInt(4,t.getRollNumber());
		int rowUpdated = pstmt.executeUpdate();
		return rowUpdated ==1?findById(t.getRollNumber()):null;
		
		 

	}
	
	private Student mapperRowToObject(ResultSet rs) throws SQLException {
		
			
			int rollNumber = rs.getInt("roll_no");
			String firstName = rs.getString("first_name");
			Date dob = rs.getDate("date_of_birth");
			LocalDate dateOfBirth = dob.toLocalDate();
			int	markScored = rs.getInt("marks_scored");
				
				Student student = new Student(rollNumber,firstName,markScored,dateOfBirth);
				return student;
				
			}
		
	
	/*public static void main(String[] args) {
		
		try {
			new StudentDaoImplementation(MySqlSConnection.getMySqlConnection()).findAll().forEach(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
