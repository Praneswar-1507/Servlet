package com.chainsys.main;
import java.util.ArrayList;
import com.chainsys.model.LoginPage;
public class ListUser {
	    ArrayList<LoginPage> array= new ArrayList<>();
	    public void adduser(String firstname, String lastname,String course, String gender, String email, String phoneno, String password) {
	        LoginPage user=new LoginPage(firstname,lastname,course,gender,email,phoneno,password);
	        array.add(user);
	        System.out.println(array);
	         
	    }
	    public ArrayList<LoginPage> getArray() {
	        return array;
	    }
	}

