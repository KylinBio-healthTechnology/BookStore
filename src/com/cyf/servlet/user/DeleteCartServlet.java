package com.cyf.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyf.bean.Cart;

import java.io.IOException;
import java.util.List;

@WebServlet("/user/deleteCart")
public class DeleteCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GB18030");
        double totalPrice = 0;
        int numbersum=0;
        HttpSession session = req.getSession();
        Integer bookId = Integer.parseInt(req.getParameter("bookId"));
        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getBook().getBookId() == bookId) {
                cartList.remove(i);  //移除相应bookID的图书
            }
        }
        for (Cart cart : cartList) {
            totalPrice += cart.getBook().getBookSprice() * cart.getNumber();  //更新结算价格
            numbersum += cart.getNumber();  //更新数量
        }
        req.setAttribute("numbersum", numbersum);
        req.setAttribute("totalPrice", totalPrice);
//      resp.sendRedirect("http://localhost:8080/bookstore/user/user-cart.jsp");  //重定向
        req.getRequestDispatcher("user-cart.jsp").forward(req,resp);
    }
}
