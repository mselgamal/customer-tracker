package com.customer_tracker.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDebServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// connection varaibles;
		String user = "springstudent", pass = "springstudent";
		String url = "jdbc:mysql://localhost:3306/customer_tracker?"
				+ "useSSL=FALSE&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// get connection
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + url);
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pass);
			out.print("SUCCESS");
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
