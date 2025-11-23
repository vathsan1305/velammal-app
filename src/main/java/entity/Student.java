package entity;

import java.time.LocalDate;

public class Student {
	
	private int rollNumber;
	private String firstName;
	private int markScored;
	private LocalDate dateOfBirth;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int rollNumber, String firstName, int markScored, LocalDate dateOfBirth) {
		super();
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.markScored = markScored;
		this.dateOfBirth = dateOfBirth;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getMarkScored() {
		return markScored;
	}

	public void setMarkScored(int markScored) {
		this.markScored = markScored;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", firstName=" + firstName + ", markScored=" + markScored
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	

}
