package com.cyf.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyf.bean.Book;
import com.cyf.bean.Cart;
import com.cyf.bean.User;
import com.cyf.bean.order;
import com.cyf.dao.BookDao;
import com.cyf.dao.UserDao;

/**
 * Servlet implementation class sellteServlet
 */
@WebServlet("/user/sellteServlet")
public class sellteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date currentTime = new java.util.Date();
		String time = simpleDateFormat.format(currentTime).toString();// 时间
		Integer listchang = Integer.parseInt(req.getParameter("listchang"));
		req.setCharacterEncoding("GB18030");
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute("currentUser");// user_id ,user_name
        List<Cart> cartList =(List<Cart>) session.getAttribute("cartList");  //获取session的cartList属性的值
		String status = "下单";
		order order = new order();
		for (Cart temp : cartList) {  //遍历cartList
			order.setUserid(currentUser.getUserId().toString());//user_id
			order.setUsername(currentUser.getUserName());//user_name
			order.setBookid(temp.getBook().getBookId().toString());//book_id
			order.setBookname(temp.getBook().getBookName());//book_name
			order.setCount(temp.getNumber());//order_count
			order.setPrice(temp.getBook().getBookSprice()*temp.getNumber());//order-price
			order.setTime(time);
			order.setStatus(status);
			UserDao dao = new UserDao();
			boolean flag = dao.getjiezhnag(order);
			if (flag != true) {
				req.setAttribute("message", "支付失败");
				req.getRequestDispatcher("user-cart.jsp").forward(req, resp);
			}
        }
		session.setAttribute("message", "成功支付");
		session.removeAttribute("cartList"); // 删除当前用户对象
		resp.sendRedirect("http://localhost:8080/bookstore/index.jsp");

	}

	

}
