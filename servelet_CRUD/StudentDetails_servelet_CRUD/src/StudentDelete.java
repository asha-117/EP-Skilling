

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDelete
 */
public class StudentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regno=Integer.parseInt(request.getParameter("regno"));
		StudentBean sb=new StudentBean();
		sb.setRegno(regno);
		StudentDAO dao=new StudentDAO();
		try {
			int i=dao.StudentDelete(sb);
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
