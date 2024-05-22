package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.dao.UserDetails;
import com.chainsys.model.LoginUser;

public class JdbcUser implements UserDetails {
	LoginUser u = new LoginUser();

	public static void insert(LoginUser user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = Util.getConnection();
		String query = "insert into logindetails values(?,?,?)";
		PreparedStatement p = connection.prepareStatement(query);
		p.setString(1, user.getUsername());
		p.setString(2, user.getEmail());
		p.setString(3, user.getPhonenumber());
		p.executeUpdate();
	}
	public ArrayList<LoginUser> Read() throws ClassNotFoundException, SQLException 
	{
		ArrayList<LoginUser>user=new ArrayList<LoginUser>();
		Connection connection = Util.getConnection();
		String query="Select * from logindetails";
		PreparedStatement p = connection.prepareStatement(query);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			LoginUser login=new LoginUser();
			login.setUsername(rs.getString("username"));
			login.setEmail(rs.getString("email"));
			login.setPhonenumber(rs.getString("userpassword"));
			user.add(login);
		}
		
		return user;
	}
public void deleteUser(String username) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = Util.getConnection();
        String delete = "delete from logindetails where username= "+username;
        PreparedStatement prepareStatement = connection.prepareStatement(delete);
        int row = prepareStatement.executeUpdate();
        System.out.println("Affected row :"+row);
           
       
   }
}
