package com.cyf.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyf.bean.Book;
import com.cyf.bean.User;
import com.cyf.bean.order;
import com.cyf.dao.BookDao;

/**
 * Servlet implementation class userdelectServlet
 */
@WebServlet("/admin/userdelectServlet")
public class userdelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("GB18030");
		BookDao dao = new BookDao();
		Integer Id = Integer.parseInt(req.getParameter("userId"));
		dao.deleteuser(Id);
		HttpSession session = req.getSession();
		List<User> userList = dao.Selectuser();
		session.setAttribute("userList", userList);
        resp.sendRedirect("http://localhost:8080/bookstore/admin/manage-user-delete.jsp");  //÷ÿ∂®œÚ
	}


}
