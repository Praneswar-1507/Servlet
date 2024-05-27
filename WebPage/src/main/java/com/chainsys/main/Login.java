package com.chainsys.main;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.model.LoginUser;
import com.chainsys.util.JdbcUser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginUser user = new LoginUser();
	JdbcUser d = new JdbcUser();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		RequestDispatcher req=request.getRequestDispatcher("userLogin.jsp");
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "delete":
				int idToDelete = Integer.parseInt(request.getParameter("deleteid"));
				try {

					JdbcUser d = new JdbcUser();
					d.deleteUser(idToDelete);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
					e.printStackTrace();

				}
				try {
					request.setAttribute("log",d.Read());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher req = request.getRequestDispatcher("userLogin.jsp");
				req.forward(request, response);
				break;
			case "update":
				LoginUser userinfo = new LoginUser();
				int userupdateid = Integer.parseInt(request.getParameter("updateid"));
				userinfo.setId(userupdateid);
				userinfo.setUsername(request.getParameter("username"));
				System.out.println(userinfo.getUsername());
				userinfo.setEmail(request.getParameter("email"));
				userinfo.setPhonenumber(request.getParameter("phone"));
				try {
					JdbcUser.update(userinfo, userupdateid);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					request.setAttribute("log",d.Read());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher requ = request.getRequestDispatcher("userLogin.jsp");
				requ.forward(request, response);
				return;
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phone");
		user.setUsername(username);
		user.setEmail(email);
		user.setPhonenumber(phonenumber);
		try {
			JdbcUser.insert(user);
			HttpSession Session=request.getSession();
			Session.setAttribute("username", username);
			request.setAttribute("log",d.Read());
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher req = request.getRequestDispatcher("userLogin.jsp");
		req.forward(request, response);
	}
}
