

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servelet execution

public class StudentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regno=Integer.parseInt(request.getParameter("regno"));//String converted to integer
		String name=request.getParameter("name");
		StudentBean sb=new StudentBean();
		sb.setRegno(regno);
		sb.setName(name);
		
		StudentDAO dao=new StudentDAO();
		try {
			int i=dao.StudentInsert(sb);
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				request.setAttribute("StudentBean", sb);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("error.html");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
