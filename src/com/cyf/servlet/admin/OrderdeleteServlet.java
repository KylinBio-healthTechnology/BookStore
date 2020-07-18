package com.cyf.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyf.bean.order;
import com.cyf.dao.BookDao;

/**
 * Servlet implementation class OrderdeleteServlet
 */
@WebServlet("/admin/OrderdeleteServlet")
public class OrderdeleteServlet extends HttpServlet {
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
		req.setCharacterEncoding("GB18030");
		BookDao dao = new BookDao();
		Integer Id = Integer.parseInt(req.getParameter("orderId"));
		System.out.print("1111111111111111111111\n");
		System.out.print(Id);
		dao.deleteorder(Id);
		HttpSession session = req.getSession();
		List<order> orderlist = dao.Selectorder();
		session.setAttribute("orderlist", orderlist);
        resp.sendRedirect("http://localhost:8080/bookstore/admin/manage-order-delete.jsp");  //÷ÿ∂®œÚ
	}

}
