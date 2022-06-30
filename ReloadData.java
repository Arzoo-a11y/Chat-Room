package com.chatting;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ReloadData
 */
@WebServlet("/ReloadData")
public class ReloadData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReloadData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Chat_Room","root","");
			String str2="select * from chatting_data";
			PreparedStatement stmt2=(PreparedStatement) con.prepareStatement(str2);
			ResultSet rs2=stmt2.executeQuery();
			while(rs2.next()) {
				String uname=rs2.getString(1);
				String msg=rs2.getString(2);
				String mdate=rs2.getString(3);
				String mtime=rs2.getString(4);
				PrintWriter out=response.getWriter();
				out.print("<p> "+uname+"<g>"+msg+"</g><br><small>"+mdate+""+mtime+"</small></p>");
				
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
