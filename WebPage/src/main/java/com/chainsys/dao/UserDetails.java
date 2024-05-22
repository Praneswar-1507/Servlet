package com.chainsys.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.LoginUser;

public  interface UserDetails {
 ArrayList<LoginUser>Read() throws ClassNotFoundException,SQLException;
}


