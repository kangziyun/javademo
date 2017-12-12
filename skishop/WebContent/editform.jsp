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
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <form action="${ctx }/pageproduct/edit" method="post">
    <input type="hidden" name="productid" value="${pro.id }" />
    <li><label>商品名</label><input name="pname" type="text" class="dfinput" value="${pro.name }"/></li>
    <li><label>商品描述</label><input name="pdescription" type="text" class="dfinput" value="${pro.description }" /></li>
    <li><label>价格</label><input name="price" type="text" class="dfinput" value="${pro.price }"/></li>
    <li><label>折扣价</label><input name="dispricecount" type="text" class="dfinput" value="${pro.discountprice }"/></li>
    <li><label>热门商品</label><cite>
    <c:if test="${pro.hotproduct ==1}"><input name="hotps" type="radio" value="1" checked="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;<input name="hotps" type="radio" value="0" />否</c:if>
    <c:if test="${pro.hotproduct ==0}"><input name="hotps" type="radio" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;<input name="hotps" type="radio" value="0" checked="checked"/>否</c:if></cite></li>
    <li><label>最新商品</label><cite>
    <c:if test="${pro.newproduct==1 }"><input name="newps" type="radio" value="1" checked="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;<input name="newps" type="radio" value="0" />否</c:if>
    <c:if test="${pro.newproduct==0 }"><input name="newps" type="radio" value="1"/>是&nbsp;&nbsp;&nbsp;&nbsp;<input name="newps" type="radio" value="0" checked="checked"/>否</c:if>
    </cite>
    <li><label>商品类型</label><select name="pt">
	<c:forEach items="${pts }" var="pt">
		<c:if test="${pt.id==pro.producttypeid}"><option value="${pt.id }" selected="selected">${pt.name }</option></c:if>
		<c:if test="${pt.id!=pro.producttypeid}"><option value="${pt.id }">${pt.name }</option></c:if>
	</c:forEach>
	</select>
    </li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
     </form>
    </ul> 
   
    
    </div>
</body>
</html>
