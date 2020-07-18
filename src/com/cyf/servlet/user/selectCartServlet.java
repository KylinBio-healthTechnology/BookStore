package com.cyf.servlet.user;

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
 * Servlet implementation class selectCartServlet
 */
@WebServlet("/user/selectCartServlet")
public class selectCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		BookDao dao = new BookDao();
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute("currentUser");// user_id ,user_name
		List<order> orderlist = dao.searchorder(currentUser.getUserId());
		System.out.print(orderlist.toString());
		session.setAttribute("orderlist", orderlist);
        resp.sendRedirect("http://localhost:8080/bookstore/user/user-order.jsp");  //÷ÿ∂®œÚ
	}

}
