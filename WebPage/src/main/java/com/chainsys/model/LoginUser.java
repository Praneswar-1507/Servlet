package com.chainsys.model;

public class LoginUser {
String username,email,phonenumber;
int id;

public String getUsername() {
	return username;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhonenumber() {
	return phonenumber;
}

public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}



public LoginUser(String username, String email, String phonenumber, int id) {
	super();
	this.username = username;
	this.email = email;
	this.phonenumber = phonenumber;
	this.id = id;
}

public LoginUser() {
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "LoginUser [username=" + username + ", email=" + email + ", phonenumber=" + phonenumber + ", id=" + id + "]";
}




}
