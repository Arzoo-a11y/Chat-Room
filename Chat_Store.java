package com.chatting;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Chat_Store
 */
@WebServlet("/Chat_Store")
public class Chat_Store extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chat_Store() {
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
		try
		{
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Chat_Room","root","");
			Statement stmt=(Statement) con.createStatement();
			String uname=request.getParameter("uname");   //Changes Done
			String msg=request.getParameter("msg");
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
			SimpleDateFormat sdf2=new SimpleDateFormat("hh:mm:ss a");
			Date date=new Date();
			String cmtDate=sdf.format(date);
			String cmttime=sdf2.format(date);
			
			System.out.println(uname);
			System.out.println(msg);		
			//String str="INSERT INTO chatting_data(username, message, posted_date, posted_time)  values('"+uname+"','"+msg+"','"+cmtDate+"','"+cmttime+"')";
			
			String str="INSERT INTO chatting_data(username, message, posted_date, posted_time)  values(?,?,?,?)";
			java.sql.PreparedStatement ps=con.prepareStatement(str);
			ps.setString(1, uname);
			ps.setString(2, msg);
			ps.setString(3, cmtDate);
			ps.setString(4, cmttime);
			ps.executeUpdate();
		}
			
			
			//other code 
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
			
			
		
	
