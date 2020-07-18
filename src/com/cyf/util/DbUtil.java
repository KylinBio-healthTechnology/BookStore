package com.cyf.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	    private static String url = "jdbc:mysql://localhost:3306/webstore?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true"; //数据库地址
	    private static String userName = "root"; //数据库用户名
	    private static String passWord = "111111"; // 数据库密码
	    private static Connection conn = null;

	    /**
	     * 数据库连接
	     *
	     * @return
	     */
	    public static Connection getConnection() {
	        if (null == conn) {
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                conn = DriverManager.getConnection(url, userName, passWord);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return conn;
	    }

	    /**
	     * 测试数据库连接
	     *
	     * @param args
	     */
	    public static void main(String[] args) {
	        System.err.println(getConnection());
	    }

}
