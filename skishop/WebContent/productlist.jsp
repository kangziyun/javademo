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
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="${ctx }/images1/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">缩略图</th>
    <th>商品名</th>
    <th>商品描述</th>
    <th>价格</th>
    <th>折扣价</th>
    <th>商品类型</th>
    <th>热门商品</th>
    <th>最新商品</th>
    <th>修改</th>
    <th>删除</th>
    </tr>
    </thead>
    
    <tbody>
   <c:forEach items="${page.list }" var="p"> 
    <tr>
    <td class="imgtd"><img src="${ctx }/images1/img11.png" /></td>
    <td>${p.name }</td>
    <td>${p.description }</td>
    <td>${p.price }</td>
    <td>${p.discountprice }</td>
    <td>${p.producttypeid }</td>
    <c:if test="${p.hotproduct ==1}"><td>热门商品</td></c:if>
    <c:if test="${p.hotproduct ==0}"><td>&nbsp;</td></c:if>
    <c:if test="${p.newproduct ==1}"><td>最新商品</td></c:if>
    <c:if test="${p.newproduct ==0}"><td>&nbsp;</td></c:if>
    <td><a href="edit?productid=${p.id }">修改</a></td>
    <td><a href="delete?productid=${p.id }">删除</a></td>
    </tr>
   </c:forEach>
    </tbody>
    
    </table>
    
    
    
    
    
   
   <div class="pagin">
    	<div class="message">共<i class="blue">${page.totalCount }</i>条记录</div>
        <ul class="paginList">
        <c:forEach var="i" begin="1" end="${page.totalPageNum }" varStatus="sta">
        <li class="paginItem"><a href="${ctx }/pageproduct/show?pageNum=${sta.index}"><span class="pagepre">${sta.index}</span></a></li>
       </c:forEach>
        </ul>
    </div>

    </div>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="${ctx }/images1/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <form action="${ctx }/pageproduct/findtypes">
        <input name="" type="submit"  class="cancel" value="确认" />&nbsp;
        </form>

        </div>
    
    </div>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
