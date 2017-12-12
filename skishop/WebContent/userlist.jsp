<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctx }/css1/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx }/js1/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">图片列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="${ctx }/images1/t01.png" /></span>添加</li>
        <li class="click"><span><img src="${ctx }/images1/t02.png" /></span>修改</li>
        <li><span><img src="${ctx }/images1/t03.png" /></span>删除</li>
        <li><span><img src="${ctx }/images1/t04.png" /></span>统计</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="${ctx }/images1/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">缩略图</th>
    <th>用户名</th>
    <th>邮箱</th>
    <th>密码</th>
    <th>地址</th>
    <th>删除</th>
    </tr>
    </thead>
    
    <tbody>
   <c:forEach items="${page.list }" var="u"> 
    <tr>
    <td class="imgtd"><img src="${ctx }/images1/img11.png" /></td>
    <td>${u.name }</td>
    <td>${u.mailaddress }</td>
    <td>${u.password }</td>
    <td>${u.address }</td>
    <td><a href="delete?id=${u.id }">删除</a></td>
    </tr>
   </c:forEach>
    </tbody>
    
    </table>
    
    
    
    
    
   
   <div class="pagin">
    	<div class="message">共<i class="blue">${page.totalCount }</i>条记录</div>
        <ul class="paginList">
        <c:forEach var="i" begin="1" end="${page.totalPageNum }" varStatus="sta">
        <li class="paginItem"><a href="${ctx }/pageuser/show?pageNum=${sta.index}"><span class="pagepre">${sta.index}</span></a></li>
       </c:forEach>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images1/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images1/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
