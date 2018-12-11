<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司简介</title>
    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <%@ page import="org.lanqiao.recruit.domain.Company_profile" %>
    <%@ page import="org.lanqiao.recruit.domain.GongSiJianJie" %>
    <%@ page import="com.google.gson.Gson" %>
    <meta name="description" content="滕州论坛是关注滕州发展、民生，提供滕州各类生活资讯和情感交流的地方门户网站。" />
<meta name="keywords" content="滕州论坛" />
<link href="/css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
 <div id="wrap">
 <div id="top">
 <div class="logo"><a href="index.jsp"><img src="${company_content.img}" width="140" height="60" /></a></div>
 <div id="nav">
  <ul>
   <li><a href="#">社区首页</a></li>
   <li><a href="#">最新帖子</a></li>
  </ul>
 </div>
 </div>
 <div id="main" style="height: 800px;">
  <div class="mainleft">
   <ul>
    <li><a href="/Company_profile.do?id=1&belong=关于我们" class="hover">关于我们 <span class="en">About Us</span></a></li>
    <li><a href="/gongsijianjie/tengxun/contact.jsp">联系我们 <span class="en">Contact us</span></a></li>
    <li><a href="/gongsijianjie/tengxun/links.jsp">友情链接 <span class="en">Links</span></a></li>
   </ul>
  </div>
  <div class="mainright">
   <div class="content">
    <h3>关于我们<sub>ABOUT US</sub></h3>
    <p>&nbsp;</p>
       <p align="center"><img src="${company_content.img}" width="140" height="60" /></p>
       <p>${company_content.titlecon}</p>
       <c:forEach begin="0" end="2" var="i">
           <p><span style="color:#ff6600;font-weight:bold;">${company_content.twotitlelist[i]}</span><br/>
                   ${company_content.twoconlist[i]}
           </p>
       </c:forEach>
   </div>
  </div>
 </div>
 </div>
</body>
</html>
