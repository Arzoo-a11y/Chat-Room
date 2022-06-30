package com.chatting;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class chat
 */
@WebServlet("/chat")
public class chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Chat_Room","root","");
			java.sql.Statement stmt=con.createStatement();
			String uname=request.getParameter("username");
			System.out.println(uname);
			String pw=request.getParameter("password");
			System.out.println(pw);
			String query="select * from chatting where username='"+uname+"' and password='"+pw+"'";
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				String username=rs.getString("username");
				HttpSession hs=request.getSession();
				hs.setAttribute("name",username);
				out.println("Welcome,"+username.toUpperCase());
				out.println("<a href='startchat.jsp'>let's Enter the chat room</a>");
				out.println("<a href='logout.jsp' class='logout-chat'>Logout</a>");

				
			}
			else {
				out.println("Incorrect Username or Password.");
			}
			con.close();
					
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
