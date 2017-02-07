package com.ozh.identity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ozh.identity.datamodel.User;
import com.ozh.identity.service.UserInfoOperations;

/**
 * Servlet implementation class AddInfoServlet
 */
@WebServlet("/AddInfoServlet")
public class AddInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoOperations ao = new UserInfoOperations();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String displayname = request.getParameter("displayname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		RequestDispatcher rd = null;
		
		User user = new User();
		user.setName(name);
		user.setDisplayname(displayname);
		user.setPassword(password);
		user.setEmail(email);;
		user.setAddress(address);
		
//		System.out.println(user.getName());
//		System.out.println(user.getEmail());
//		System.out.println(user.getAddress());
		try {
			ao.userInfoSave(user);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			ao.conClose();
		}
		
		rd = request.getRequestDispatcher("manager.jsp");
		rd.forward(request, response);
	}

}
