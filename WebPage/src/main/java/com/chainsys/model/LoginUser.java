package com.chainsys.model;

public class LoginUser {
String username,email,phonenumber;

public String getUsername() {
	return username;
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

public LoginUser(String username, String email, String phonenumber) {
	super();
	this.username = username;
	this.email = email;
	this.phonenumber = phonenumber;
}

public LoginUser() {
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "LoginUser [username=" + username + ", email=" + email + ", phonenumber=" + phonenumber + "]";
}

}
