<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>

<head>
    <title>购书系统</title>
    <style>
        h1 {
            text-align: center;
            border-bottom: 1px solid black;
            line-height: 100px;
        }

        .content {
            width: 1000px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            backgroung:grey;
        }

        input {
            margin: 15px;
        }

        .input-css {
            width: 250px;
            height: 35px;
        }

        .btn {
            width: 80px;
            height: 35px;
        }
    </style>
   
<style type="text/css">    


  div.screenbg{
  opacity:0.4;
  
  }
  .screenbg {
	position:fixed;
	bottom:0;
	left:0;
	z-index:-999;
	overflow:hidden;
	width:100%;
	height:100%;
	min-height:100%;
}
.screenbg ul li {
	display:block;
	list-style:none;
	position:fixed;
	overflow:hidden;
	top:0;
	left:0;
	width:100%;
	height:100%;
	z-index:-1000;
	float:right;
}
.screenbg ul a {
	left:0;
	top:0;
	width:100%;
	height:100%;
	display:inline-block;
	margin:0;
	padding:0;
	cursor:default;
}
.screenbg a img {
	vertical-align:middle;
	display:inline;
	border:none;
	display:block;
	list-style:none;
	position:fixed;
	overflow:hidden;
	top:0;
	left:0;
	width:100%;
	height:100%;
	z-index:-1000;
	float:right;
}

 </style> 

<script type="text/javascript" src="js/jQuery1.7.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>

<script type="text/javascript">
$(function(){
	$(".screenbg ul li").each(function(){
		$(this).css("opacity","0");
	});
	$(".screenbg ul li:first").css("opacity","1");
	var index = 0;
	var t;
	var li = $(".screenbg ul li");	
	var number = li.size();
	function change(index){
		li.css("visibility","visible");
		li.eq(index).siblings().animate({opacity:0},3000);
		li.eq(index).animate({opacity:1},3000);
	}
	function show(){
		index = index + 1;
		if(index<=number-1){
			change(index);
		}else{
			index = 0;
			change(index);
		}
	}
	t = setInterval(show,8000);
	//根据窗口宽度生成图片宽度
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
	
});
</script>

</head>

<body >

<div class="content"  >
    <h1>购书系统</h1>
    <form action="login" method="post" >
        <%--message提示错误信息--%>
        
        <span style="color: red;">${message}</span><br/>
        账户：<input type="text" name="userName" required class="input-css"/><br/>
        密码：<input type="password" name="userPassword" required class="input-css"/><br/>
        <input type="radio" name="userType" value="0" checked/> 管理员
        <input type="radio" name="userType" value="1"/> 用户<br/>
        <input type="submit" value="登 录" class="btn"><br/>
        <a href="index.jsp">游客访问</a><br/>
        <a href="register">没有账户？去注册</a>
        
    </form>
</div>

<div class="screenbg" >
  <ul>
    <li><a href="javascript:;"><img src="img/0.jpg"></a></li>
    <li><a href="javascript:;"><img src="img/1.jpg"></a></li>
    <li><a href="javascript:;"><img src="img/2.jpg"></a></li>
  </ul>
</div>
</body>

</html>
