package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteJobSeekerList
 */
public class DeleteJSQualification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String Skill, query;
	Connection conn;
	Statement stmt;
	ResultSet res;
	DatabaseConnection dbconn;
  
    public DeleteJSQualification() {
        super();  
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			
			dbconn= new DatabaseConnection();
			conn = dbconn.setConnection();
			stmt=conn.createStatement();
			Skill = request.getParameter("JS_educational_Qualification");
			out.println(Skill);
			query = "Delete from Job_Seeker_Qualification where JS_ID = 1005 AND JS_educational_Qualification='MTech'";
			int i = stmt.executeUpdate(query);
		
		}catch (Exception e){
			
		}
		finally{
			RequestDispatcher rd = request.getRequestDispatcher("/JSQualification-jsp.jsp");
			rd.forward(request, response);
			out.close();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
