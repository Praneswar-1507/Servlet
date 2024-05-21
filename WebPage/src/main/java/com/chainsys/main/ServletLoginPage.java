package com.chainsys.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLoginPage
 */
@WebServlet("/ServletLoginPage")
public class ServletLoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
ListUser listuser=new ListUser();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		String course=request.getParameter("course");
		String gender=request.getParameter("gender");
		String phoneno=request.getParameter("phone");
		String email=request.getParameter("email");
		String password=request.getParameter("psw");
//		PrintWriter out=response.getWriter();
//	    out.println("\nFirstName:"+firstName);
//	    out.println("LastName:"+lastName);
//	    out.println("Password:"+password);
	  listuser.adduser(firstName, lastName,course, gender, email, phoneno, password);
	  request.setAttribute("array",listuser.getArray());
	  request.getRequestDispatcher("Login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
