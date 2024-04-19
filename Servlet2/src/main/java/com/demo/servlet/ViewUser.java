package com.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.demo.bean.SeatNo;
import com.demo.bean.User;

/**
 * Servlet implementation class ViewUser
 */
public class ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<h1>user Detail<h1>");
		
		List<User> l=SeatNo.getUsers();
		
		out.print("<table border=1>");
		out.print("<tr><th>NAME<th>MOBILE<th>DATE<th>SEAT_NO</tr>");
		for(User u:l) {
			out.print("<tr><td>"+u.getName()+"</td>");
			out.print("<td>"+u.getMobile()+"</td>");
			out.print("<td>"+u.getDate()+"</td>");
			out.print("<td>"+u.getNo_of_seats()+"</td></tr>");
		}
		out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
		
	}

}
