package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String number = request.getParameter("mobile");
		String dob = request.getParameter("dob");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String dbpass = "vinoth11";
			Connection con = DriverManager.getConnection(url, user, dbpass);
			PreparedStatement value = con.prepareStatement("insert into singup values(?,?,?,?,?,?)");
			value.setString(1, name);
			value.setString(2, pass);
			value.setString(3, email);
			value.setString(4, gender);
			value.setString(5, number);
			value.setString(6, dob);
			int i = value.executeUpdate();

			if (i > 0) {
				out.println("your are sucessfully regiser.!!!!!!!!!!!!");
			}
		} catch (Exception e) {
			out.println(e);
		}

	}

}
