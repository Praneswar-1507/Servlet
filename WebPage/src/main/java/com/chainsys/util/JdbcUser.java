package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.model.LoginUser;

public class JdbcUser {
	LoginUser u=new LoginUser();
	public static void insert(LoginUser user) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=Util.getConnection();
	String query="insert into logindetails values(?,?,?)";
	 PreparedStatement p= connection.prepareStatement(query);
     p.setString(1,user.getUsername());
     p.setString(2,user.getEmail());
     p.setString(3,user.getPhonenumber());
     p.executeUpdate();
	}
}
