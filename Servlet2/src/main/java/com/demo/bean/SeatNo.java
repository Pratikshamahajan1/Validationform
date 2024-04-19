package com.demo.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeatNo {

	public SeatNo() {
	}

	public static int getSeatNo() {
		int sum=0;
		String url="jdbc:mysql://localhost:3306/pratiksha";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","Pratiksha@123");
			
			System.out.println("sucess....."+con);
			
			PreparedStatement pst=con.prepareStatement("select sum(no_of_seat) from user");
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
                String s = rs.getString("sum(no_of_seat)");
                sum=Integer.parseInt(s);
			}
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return sum;
	}
	
	public static List<User> getUsers(){
		 List l=new ArrayList<User>();
		String url="jdbc:mysql://localhost:3306/pratiksha";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","Pratiksha@123");
				
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from user");
			while(rs.next()){
				User u=new User();
				u.setName(rs.getString(1));
				u.setMobile(rs.getString(2));
				u.setDate(rs.getString(3));
				u.setNo_of_seats(rs.getInt(4));
				l.add(u);
				System.out.println(u+"\n");
			}
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return l;
	}
	
}
