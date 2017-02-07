package com.ozh.identity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ozh.identity.datamodel.User;
import com.ozh.identity.service.CheckUserService;

public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckUserService cku = new CheckUserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("pwd");
		String returnUri = request.getParameter("return_uri");

//		System.out.println("username ==> " + uname);
//		System.out.println("password ==> " + passwd);
//		System.out.println("return_uri ==> " + returnUri);

		RequestDispatcher rd = null;
//		String forword = null;

		if (uname == null || passwd == null) {
			request.setAttribute("msg", "plz type in password and username");
			rd = request.getRequestDispatcher("login.jsp");
//			System.out.println("???");
			rd.forward(request, response);
		} else {
			User user = new User();
			user.setName(uname);
			user.setPassword(passwd);
			boolean bool = cku.check(user);

			if (bool) {
				// forword = "/15/success.jsp";
				request.getSession().setAttribute("flag", "login_success");
				request.getSession().setAttribute("user", uname);
				if (returnUri != null && returnUri != "") {
					rd = request.getRequestDispatcher(returnUri);
//					System.out.println(returnUri);
				} else {
					rd = request.getRequestDispatcher("manager.jsp");
//					System.out.println("yes");
				}
			} else {
				request.getSession().setAttribute("flag", "login_error");
				request.setAttribute("msg", "username or password error!");
				rd = request.getRequestDispatcher("login.jsp");
//				System.out.println("no");
			}
			rd.forward(request, response);
		}
	}

}
