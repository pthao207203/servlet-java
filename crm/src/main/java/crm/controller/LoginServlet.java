package crm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import crm.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	
	private LoginService loginService = new LoginService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.print("Mo trang dang nhap");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mssv = req.getParameter("mssv");
		String password = req.getParameter("password");
		boolean isLogin = loginService.checkLogin(mssv, password);
		
		System.out.println(isLogin);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(isLogin);
		printWriter.flush();
	}
}
