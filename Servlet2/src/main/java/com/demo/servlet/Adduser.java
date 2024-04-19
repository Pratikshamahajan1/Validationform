package com.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.demo.bean.SeatNo;

/**
 * Servlet implementation class Adduser
 */
public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adduser() {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.print("welcome<br>");
		
		String name=req.getParameter("name");
		String mobile=(req.getParameter("mno"));
		String date =req.getParameter("date");
		int sno=Integer.parseInt(req.getParameter("sno"));
		
		//out.print(name+"<br>"+mobile+"<br>"+date+"<br>"+sno);
		
		String url="jdbc:mysql://localhost:3306/pratiksha";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","Pratiksha@123");
			
			System.out.println("sucess....."+con);
			
			Statement st=con.createStatement();
			
			if(SeatNo.getSeatNo()+sno<=30) {
			
			int k=st.executeUpdate("insert into user values('"+name+"','"+mobile+"','"+date+"',"+sno+")");
				out.print("<h1>submited</h1>");
			}else {
				out.print("<h1 color='red'>there is "+(30-SeatNo.getSeatNo())+" seats avilable</h1>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
