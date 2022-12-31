package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;
import com.mysql.cj.xdevapi.Statement;

@WebServlet("/Fetch")
public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbc";
			
			String user = "root";
			
			String dbpass = "vinoth11";
			
			Connection con = DriverManager.getConnection(url, user, dbpass);
			
			java.sql.Statement stmt = con.createStatement();
			
	        String query = "select * from singup";
	        
	        ResultSet rs = stmt.executeQuery(query);
	        		
	        while(rs.next())
	        {
	        	out.println("User_Name : " + rs.getString("username"));
	        	out.println("<br>");
	        	out.println("User_Password : " + rs.getString("userpass"));
	        	out.println("<br>");
	        	out.println("Email_ID : " + rs.getString("email"));
	        	out.println("<br>");
	        	out.println("Gender: " + rs.getString("gender"));
	        	out.println("<br>");
	        	out.println("User_MObile_Number : " + rs.getString("mobile"));
	        	out.println("<br>");
	        	out.println("Date_Of_Brith : " + rs.getString("date_of_brith"));
	        }
	        
		} catch (Exception e) {
			out.print(e);
		}

	}

}
