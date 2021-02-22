package com.klu.servelets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.klu.Bean.Bean;
import com.klu.Connections.DAO;


public class Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		Bean b=new Bean();
		b.setName(name);
		b.setPassword(password);
		b.setEmail(email);
		b.setCountry(country);
		DAO dao=new DAO();
		try {
			int i=dao.insert(b);
			
			if(i>0) {
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				request.setAttribute("bean", b);
				rd.forward(request, response);
			}
			
			
			
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		
	}

}
