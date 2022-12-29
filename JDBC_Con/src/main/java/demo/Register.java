package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String number = request.getParameter("mobile");
		String dob = request.getParameter("dob");
		
		out.print(name);
		out.print(pass);
		out.print(email);
		out.print(gender);
		out.print(number);
		out.print(dob);
		
		
	}

}
