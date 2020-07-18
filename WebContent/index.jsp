<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cyf.dao.*" %>
<%@ page import="com.cyf.bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="GB18030">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <title>二手书网站界面</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        /*媒体查询，小屏幕（平板，大于等于768px）*/
        @media (min-width:768px){
            #leftbar{
                width:240px;
                margin:55px 0px 0px 0px;
                position:absolute;
                /*z-index:1;*/
                height:500px;
                /*background:#B9DEF0;*/
            }
            .page-right{
                background:#FFFFFF;
                margin:-5px 0px 0px 245px;
            }
        }
        /* */
        .left-dh{
            margin: 10px 0px;
        }
        @media (max-width:768px){
            body{
                background:#777;
            }
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top">
    <div class="navbar-header">
        <a href="http://localhost:8080/bookstore/index.jsp" class="navbar-brand">二手书网站管理</a>
        <button class="navbar-toggle" data-toggle="collapse" data-target="#login">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <button class="navbar-toggle" data-toggle="collapse" data-target="#leftbar">
            <span>设置</span>
        </button>
    </div>
    <ul class="nav navbar-nav navbar-right navbar-collapse collapse" id="login" style="margin:0px 20px 0px 0px;">
    	<c:set var="username" scope="session" value="${currentUser.userName}"/>
		<c:choose>
		 <c:when test="${not empty username}">
		    <li><a href="#"><span class="badge" >当前用户：</span>${currentUser.userName}</a></li>
		    </c:when>
		    <c:otherwise>
		    <li><a href="#"><span class="badge">当前用户：</span>未登录${currentUser.userName}</a></li>
		    </c:otherwise>
		</c:choose>
        <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					用户 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="user/user-update.jsp">个人中心</a></li>
					<li class="divider"></li>
					<li><a href="login.jsp">登录</a></li>
					<li class="divider"></li>
					<li><a href="logout">退出登录</a></li>
				</ul>
			</li>
			 <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					购物车 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="user/user-cart.jsp">购物车管理</a></li>
					<li class="divider"></li>
					<li><a href="http://localhost:8080/bookstore/clearCart">清空购物车</a></li>
					<li class="divider"></li>
					<li><a href="user/selectCartServlet">购物记录</a></li>
				</ul>
			</li>
        <li><a href="register">注册</a></li>
    </ul>
    <!--侧边栏 -->
    <form class="form-inline" action="" method="post">
    <div class="navbar-collapse collapse" id="leftbar">
        <ul class="nav" id="mz">
            <li>
                <div class="input-group left-dh">
                    <input type="text" class="form-control" name="key" placeholder="请输入关键字">
                    <span class="input-group-btn">
					<button class="btn btn-danger" type="submit">
					<span class="glyphicon glyphicon-search"></span>
					</button>
                     </sapn>
                </div>
            </li>
            <li class="panel panel-default">
                <a href="#sys" data-toggle="collapse" data-parent="#mz">书籍分类<span class="glyphicon glyphicon-chevron-right pull-right"></span></a>
                <ul class="panel-collapse collapse nav" id="sys">
                    
						<%
							BookDao dao = new BookDao();
							List<type> List = dao.getbookstype();
	
							for (type Info : List) {
						%>
						<li class="dropdown">
							<a href="classServlet?classname=<%=Info.getType_id()%>" class="dropdown-toggle"><%=Info.getType_name()%></a>
						</li>
						<%
							}
						%>
                </ul>
            </li>
        </ul>
    </div>
    </form>
</nav>
<!--右边主要区域 -->
 <%
			request.setCharacterEncoding("GBK"); //设置编码（POST方式）
		    String key = request.getParameter("key");
			
				if (key == null) {
					key = "";
				}
			
				int pageNo = 1;
				String pageNoStr = request.getParameter("pageNo");
				if (pageNoStr != null) {
					pageNo = Integer.parseInt(pageNoStr);
				}

				Page pageData = dao.getPageBook(key,pageNo);
				
				List<Book> list = pageData.getList();
				
                session.setAttribute("bookList", list);
	
			
		%>
<div class="page-right">
    <ol class="breadcrumb">
        <li><a href="http://localhost:8080/bookstore/index.jsp">首页管理</a></li>
        <li><a href="#">新书上架</a></li>
    </ol>
    
    <div class="row">
    <c:forEach items="${bookList}" var="book" varStatus="status">
    <div class="col-md-3">
           <div class="card">
		    <img class="card-img-top" src="${book.img}" alt="Card image" style="height:200">
		    <div class="card-body">
		      <h4 class="card-title">${book.bookName}</h4>
		      <p class="card-text">${book.bookAuthor}</p>
		      <p class="card-text" color="red">￥${book.bookSprice}</p>
		      <c:choose>
                        <c:when test="${!empty currentUser}">
                            <td><input type="number" class="bookNumber" value="1" min="1"  size=4></td>
                            <td>
                                <a class="btn btn-primary" href="javascript:;" onclick="addCartFun('${book.bookId}',${status.index})">加入购物车</a>
                            </td>
                        </c:when>
              </c:choose>
		    </div>
		  </div>
        </div>
      </c:forEach>
    </div>
     <ul class="pagination pull-right">
        共<%=pageData.getTotalPageNumber()%>页 当前第<%=pageData.getPageNo()%>页 共<%=pageData.getTotalItemNumber()%>行数据
			当前显示<%=pageData.getStartRow()%>-<%=pageData.getEndRow()%>行
    </ul>
    <ul class="pagination pull-left">
        <li><a href="index.jsp?pageNo=1">首页</a></li>
        <li><a href="index.jsp?pageNo=<%=pageData.getPrevPage()%>">上页</a></li>
        <li><a href="index.jsp?pageNo=<%=pageData.getNextPage()%>">下页</a></li>
        <li><a href="index.jsp?pageNo=<%=pageData.getTotalPageNumber()%>">末页</a></li>
    </ul>
</div>
<script>
    function addCartFun(bookId,ind) {
        var number = document.getElementsByClassName("bookNumber")[ind].value;
        window.location.href = "user/addCart?bookId=" + bookId + "&number=" + number;
    }
</script>
</body>
</html>