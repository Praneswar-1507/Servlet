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
		String query = "insert into logindetails(username,email,mobileNumber) values(?,?,?)";
		PreparedStatement p = connection.prepareStatement(query);
		p.setString(1, user.getUsername());
		p.setString(2, user.getEmail());
		p.setString(3, user.getPhonenumber());
		p.executeUpdate();
	}

	public ArrayList<LoginUser> Read() throws ClassNotFoundException, SQLException {
		ArrayList<LoginUser> user = new ArrayList<LoginUser>();
		Connection connection = Util.getConnection();
		String query = "Select * from logindetails";
		PreparedStatement p = connection.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		while (rs.next()) {
			LoginUser login = new LoginUser();
			login.setId(rs.getInt("id"));
			login.setUsername(rs.getString("username"));
			login.setEmail(rs.getString("email"));
			login.setPhonenumber(rs.getString("mobileNumber"));
			user.add(login);
		}

		return user;
	}

	public void deleteUser(int id) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = Util.getConnection();
		String delete = "delete from logindetails where id= " + id;
		PreparedStatement prepareStatement = connection.prepareStatement(delete);
		int row = prepareStatement.executeUpdate();
		System.out.println("Affected row :" + row);

	}

	public static void update(LoginUser userlogin, int userupdateid) throws ClassNotFoundException, SQLException {
		System.out.println(userlogin.getUsername() + " " + userlogin.getId());
		Connection connection = Util.getConnection();
		String query = "update logindetails set username=?,email=?,mobileNumber=? where id=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, userlogin.getUsername());

		ps.setString(2, userlogin.getEmail());
		ps.setString(3, userlogin.getPhonenumber());
		ps.setInt(4, userupdateid);
		int row = ps.executeUpdate();
		System.out.println("updated  " + row);
	}
	public static ArrayList<LoginUser> searchByName(String  name) throws ClassNotFoundException, SQLException {
        ArrayList<LoginUser> user = new ArrayList<>(); 
        System.out.println(name);
       Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = Util.getConnection();
        String search = "select id,username,email,mobileNumber from logindetails where username like ?";
        PreparedStatement prepareStatement = connection.prepareStatement(search);
        prepareStatement.setString(1, "%" + name + "%");
       ResultSet resultSet= prepareStatement.executeQuery();
        while (resultSet.next()) {
            
        	LoginUser userlogin = new LoginUser(); 
        	userlogin.setId(resultSet.getInt("id"));
        	userlogin.setUsername(resultSet.getString("username"));
        	userlogin.setEmail(resultSet.getString("email"));
               userlogin.setPhonenumber(resultSet.getString("mobileNumber"));
              
               
               user.add(userlogin); 
           }
        return user;
   }
}
