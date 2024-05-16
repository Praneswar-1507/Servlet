package com.chainsys.model;

public class LoginPage {
	String firstname,lastname,password,gender,email,phoneno,course;
	public LoginPage()
	{
		
	}
	

	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public LoginPage(String firstname, String lastname, String course, String gender, String email, String phoneno,String password
			) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.course = course;
		this.gender = gender;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		
	}



}
