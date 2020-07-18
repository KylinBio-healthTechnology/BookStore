package com.cyf.servlet;

import com.cyf.bean.User;
import com.cyf.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.doPost(req, resp);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GB18030");
        String userName = req.getParameter("userName");  //获取输入用户名
        String userPassword = req.getParameter("userPassword");  //获取输入密码
        int userType = Integer.parseInt(req.getParameter("userType"));  //将String转换为int
        UserDao userDao = new UserDao();
        User user = userDao.login(userName, userPassword);  //登录验证
        if (user == null) {  //未注册或者账号或密码错误
            req.setAttribute("message", "账号或密码错误，请重新输入");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);  //转发
        } else {
            if (userType == 0) {
                if (user.getUserLevelId() == 0) {
                    HttpSession session = req.getSession();
                    session.setAttribute("currentUser", user);  //把当前用户存进session,1.拦截器 2.打印出当前用户
                    resp.sendRedirect("admin/OrderAdminServlet");
//                    req.getRequestDispatcher("/admin/manage.jsp").forward(req, resp);
                } else {
                	  req.setAttribute("message", "请使用管理员权限登录");  //把当前用户存进session,1.拦截器 2.打印出当前用户
                      req.getRequestDispatcher("login.jsp").forward(req, resp);
                    return;
                }
            }
            if (userType == 1) {
                if (user.getUserLevelId() == 1){
                    HttpSession session = req.getSession();
                    session.setAttribute("currentUser", user);  //把当前用户存进session
                    resp.sendRedirect("index.jsp");
//                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }else {
                	  req.setAttribute("message", "请使用用户权限登录");  //把当前用户存进session,1.拦截器 2.打印出当前用户
                      req.getRequestDispatcher("login.jsp").forward(req, resp);
                    return;
                }
            }
        }
    }
}