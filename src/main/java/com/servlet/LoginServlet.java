package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Login Servlet Testing", urlPatterns = { "/LoginServlets" }, initParams = {
		@WebInitParam(name = "user", value = "Anant"), @WebInitParam(name = "pwd", value = "Anant@123") })
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * / Get Request parameters for userId and Password
		 */
		/*
		 * / Regex pattern for user name
		 */
		String user = request.getParameter("user");
		String namePattern = "^[A-Z]{1}[a-z]{3,}$";
		Pattern pat = Pattern.compile(namePattern);
		Matcher match = pat.matcher(user);

		String pwd = request.getParameter("pwd");

		/*
		 * / get servlet configuration init parameters
		 */
		String userId = getServletConfig().getInitParameter("userId");
		String pass = getServletConfig().getInitParameter("password");
		if (userId.equals(user) && pass.equals(pwd)) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font colour=red> Either User name or Password is Wrong</font>");
			rd.include(request, response);

		}
	}
}