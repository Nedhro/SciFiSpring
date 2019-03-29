package com.scifisoft.SciFiSpring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students", catalog = "scifidb")
public class Student {

	private String studentID;
	private String studentName;
	private String studentClass;
	private String studentAddress;

	@Id
	@Column(name = "student_id", unique = true, nullable = false, length = 255)
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	@Column(name = "student_name", length = 255)
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "student_class", length = 255)
	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	@Column(name = "student_address", length = 255)
	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

}
