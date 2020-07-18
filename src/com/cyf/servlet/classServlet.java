package com.cyf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyf.bean.Book;
import com.cyf.bean.Page;
import com.cyf.bean.User;
import com.cyf.bean.order;
import com.cyf.dao.BookDao;

/**
 * Servlet implementation class classServlet
 */
@WebServlet("/classServlet")
public class classServlet extends HttpServlet {
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
		String key = req.getParameter("classname");
		if (key == null) {
			key = "";
		}
		int pageNo = 1;
		Page pageData = dao.getPageBook(key,pageNo);
		List<Book> list = pageData.getList();
		req.setAttribute("bookList", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
