package com.cyf.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyf.bean.User;
import com.cyf.bean.order;
import com.cyf.dao.BookDao;
import com.cyf.dao.UserDao;

/**
 * Servlet implementation class OrderupdateServlet
 */
@WebServlet("/admin/OrderupdateServlet")
public class OrderupdateServlet extends HttpServlet {
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
        int Id = Integer.parseInt(req.getParameter("order_id"));
        String statu = req.getParameter("order_statu");
        System.out.print(statu);
        UserDao dao = new UserDao();
        dao.updatastatu(statu, Id);
        BookDao da = new BookDao();
		HttpSession session = req.getSession();
		List<order> orderlist = da.Selectorder();
		session.setAttribute("orderlist", orderlist);
        resp.sendRedirect("http://localhost:8080/bookstore/admin/manage-order-updata.jsp");
	}

}
