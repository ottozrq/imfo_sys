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
 * Servlet implementation class EditInfoServlet
 */
@WebServlet("/EditInfoServlet")
public class EditInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoOperations uo = new UserInfoOperations();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInfoServlet() {
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
		Integer id = Integer.parseInt(request.getParameter("id"));
		String displayname = request.getParameter("displayname");
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		RequestDispatcher rd = null;
		
		User user = new User();
		user.setId(id);
		user.setName(username);
		user.setDisplayname(displayname);
		user.setPassword(password);
		user.setEmail(email);;
		user.setAddress(address);
		
//		System.out.println(id);
			
		try {
			uo.userInfoUpdate(user);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			uo.conClose();
		}
		
		rd = request.getRequestDispatcher("manager.jsp");

		rd.forward(request, response);
	}

}
