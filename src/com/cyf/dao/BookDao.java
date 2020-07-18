package com.cyf.dao;

import com.cyf.bean.Book;
import com.cyf.bean.Page;
import com.cyf.bean.User;
import com.cyf.bean.order;
import com.cyf.bean.type;
import com.cyf.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    /**
     * 图书列表
     *
     * @return
     */
    public List<Book> selectBook() {
        List<Book> list = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from book";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Book book = new Book();
                book.setBookId(rst.getInt("book_id"));
                book.setBookName(rst.getString("book_name"));
                book.setBookSprice(rst.getDouble("book_sprice"));
                book.setBookCount(rst.getInt("book_count"));
                book.setBookAuthor(rst.getString("book_author"));
                book.setBooktype(rst.getString("book_typeid"));
                book.setBookremark(rst.getString("book_remark"));
                book.setImg(rst.getString("img"));
                list.add(book);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 新增图书
     *
     * @param book
     * @return
     */
    public boolean addBook(Book book) {
        String sql = "INSERT INTO book(book_name,book_sprice,book_count,book_author) VALUES (?,?,?,?)";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, book.getBookName());
            pst.setDouble(2, book.getBookSprice());
            pst.setInt(3, book.getBookCount());
            pst.setString(4, book.getBookAuthor());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 更新图书
     *
     * @param book
     * @return
     */
    public boolean updateBook(Book book) {
        String sql = "update book set book_name=?, book_sprice=?, book_count=?, book_author=? where book_id = ?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, book.getBookName());
            pst.setDouble(2, book.getBookSprice());
            pst.setInt(3, book.getBookCount());
            pst.setString(4, book.getBookAuthor());
            pst.setInt(5, book.getBookId());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除图书
     *
     * @param bookId
     * @return
     */
    public boolean deleteBook(int bookId) {
        String sql = "delete from book where book_id = ?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, bookId);
            int count = pst.executeUpdate();
            pst.close();
            return count > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获得图书
     *
     * @param bookId
     * @return
     */
    public Book getBook(int bookId) {
        Connection conn = DbUtil.getConnection();
        String sql = "select * from book where book_id = " + bookId;
        Book book = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                book = new Book();
                book.setBookId(rst.getInt("book_id"));
                book.setBookName(rst.getString("book_name"));
                book.setBookSprice(rst.getDouble("book_sprice"));
                book.setBookCount(rst.getInt("book_count"));
                book.setBookAuthor(rst.getString("book_author"));
                book.setBooktype(rst.getString("book_typeid"));
                book.setBookremark(rst.getString("book_remark"));
                book.setImg(rst.getString("img"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    /**
     * 模糊搜索
     *
     * @param key
     * @return
     */
    public List<Book> searchBook(String key) {
        List<Book> list = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM book WHERE book_name like '%" + key + "%'";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Book book = new Book();
                book.setBookId(rst.getInt("book_id"));
                book.setBookName(rst.getString("book_name"));
                book.setBookSprice(rst.getDouble("book_sprice"));
                book.setBookCount(rst.getInt("book_count"));
                book.setBookAuthor(rst.getString("book_author"));
                book.setBooktype(rst.getString("book_typeid"));
                book.setBookremark(rst.getString("book_remark"));
                book.setImg(rst.getString("img"));
                list.add(book);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<order> searchorder(int userid) {
        List<order> list = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM `order` WHERE user_id =" + userid + "";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	order order = new order();
            	order.setId(rst.getInt("order_id"));
            	order.setUserid(rst.getString("user_id"));
            	order.setUsername(rst.getString("user_name"));
            	order.setBookid(rst.getString("book_id"));
            	order.setBookname(rst.getString("book_name"));
            	order.setCount(rst.getInt("order_count"));
            	order.setPrice(rst.getDouble("order_price"));
            	order.setTime(rst.getString("order_time"));
            	order.setStatus(rst.getString("order_statu"));
                list.add(order);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<order> Selectorder() {
        List<order> list = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM `order`";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	order order = new order();
            	order.setId(rst.getInt("order_id"));
            	order.setUserid(rst.getString("user_id"));
            	order.setUsername(rst.getString("user_name"));
            	order.setBookid(rst.getString("book_id"));
            	order.setBookname(rst.getString("book_name"));
            	order.setCount(rst.getInt("order_count"));
            	order.setPrice(rst.getDouble("order_price"));
            	order.setTime(rst.getString("order_time"));
            	order.setStatus(rst.getString("order_statu"));
                list.add(order);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Book> Selectbook() {
        List<Book> list = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM `book`";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	Book book = new Book();
            	book.setBookId(rst.getInt("book_id"));
            	book.setBookName(rst.getString("book_name"));
            	book.setBookAuthor(rst.getString("book_author"));
            	book.setBooktype(rst.getString("book_typeid"));
            	book.setBookSprice(rst.getDouble("book_sprice"));
            	book.setBookremark(rst.getString("book_remark"));
            	book.setImg(rst.getString("img"));
            	book.setBookCount(rst.getInt("book_count"));
                list.add(book);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<User> Selectuser() {
        List<User> list = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM `User`";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	User user = new User();
            	user.setUserId(rst.getInt("user_id"));
            	user.setUserLevelId(rst.getInt("user_level_id"));
            	user.setUserName(rst.getString("user_name"));
            	user.setUserPassword(rst.getString("user_password"));
                list.add(user);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void deleteorder(int id) {
        Connection conn = DbUtil.getConnection();
        String sql = "delete FROM `order` where order_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
    		pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletebook(int id) {
        Connection conn = DbUtil.getConnection();
        String sql = "delete FROM `book` where book_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
    		pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteuser(int id) {
        Connection conn = DbUtil.getConnection();
        String sql = "delete FROM `user` where user_id=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
    		pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<type> getbookstype() {
		List<type> list = new ArrayList<type>();
		Connection conn = DbUtil.getConnection();
		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from type");

			while (rs.next()) {
			
				type c = new type();
				
				int id = rs.getInt("type_id");
				
				c.setType_id(id);
				c.setType_name(rs.getString("type_name"));
				
				list.add(c);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
    
    public Page getPageBook(String key, int pageNo) {
		Page page = new Page(pageNo);
		Connection con = DbUtil.getConnection();
		
		try {
			// 计算（条件查询）总行数
			String str = "'%" + key + "%'";
			String sql = "select count(*) from book where (book_name like " + str + " or book_author like " + str+ " or book_typeid like " + str
					+ " or book_sprice like " + str + ")";

			

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if(rs.next()) {
				long totalItemNumber = rs.getLong(1);
				page.setTotalItemNumber(totalItemNumber);
			}
			
			// 获取分页数据列表

			List<Book> list = new ArrayList<Book>();

		    sql = "select * from book where (book_name like " + str + " or book_author like " + str
					+ " or book_sprice like " + str + ")";


		
			
			int startRow = (pageNo - 1)*page.getPageSize();
			sql += " limit "+startRow+","+page.getPageSize();

			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				 Book book = new Book();
	             book.setBookId(rs.getInt("book_id"));
	             book.setBookName(rs.getString("book_name"));
	             book.setBookSprice(rs.getDouble("book_sprice"));
	             book.setBookCount(rs.getInt("book_count"));
	             book.setBookAuthor(rs.getString("book_author"));
	             book.setBooktype(rs.getString("book_typeid"));
	             book.setBookremark(rs.getString("book_remark"));
	             book.setImg(rs.getString("img"));
	             list.add(book);
			}

			page.setList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BookDao dao = new BookDao();
		dao.deleteorder(61);
	}
}