<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.domain.Recruit" %>

<%--
  Created by IntelliJ IDEA.
  User: 杨佳珺
  Date: 2018/12/11
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>职位招聘页面</title>
    <link rel="stylesheet" href="css/tb.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <%--<link rel="stylesheet" href="css/boss.css">--%>
    <script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
    <script type="text/javascript" src="js/bootstrap.js" ></script>
</head>
<body class="so"><div class="tupian">
<div class="zi">职位招聘界面</div>

<%--<div class="top">--%>
    <%--<div ><a  class="logo" href="" style=" text-decoration: none;">POSS直聘</a></div>--%>
    <%--<div class="box">首页</div>--%>
    <%--<div class="box">职位</div>--%>
    <%--<div class="box">公司</div>--%>
    <%--<div class="top1">--%>
        <%--<div class="box2">上传简历</div>--%>
        <%--<div class="box2">我要招聘</div>--%>
        <%--<!-- <div class="box3"> -->--%>
        <%--<button class="button" style="color: #fff;"> 注册</button>--%>
        <%--<!-- </div> -->--%>
        <%--<!-- <div class="box3"> -->--%>
        <%--<a href="https://www.baidu.com"><button class="button" style="color: #fff;">登录</button></a>--%>
        <%--<!-- </div> -->--%>
    <%--</div>--%>
<%--</div>--%>


<center><div class="tb">

<table class="table table-condensed" style="width: 1300px; " align="center">
    <tr>

        <th>公司名称</th>
        <th>需求人数</th>
        <th>公司地点</th>
        <th>职位名称</th>
        <th>薪资详情</th>
        <%--<th>职位要求</th>--%>
        <%--<tr>发布时间</tr>--%>
        <th>发布人</th>
    </tr>

        <%List<Recruit> recruitList = (List<Recruit>)request.getAttribute("recruitList");%>
        <%
            for (int i = 0; i < recruitList.size(); i++) {
                %>
                 <%--<td><%=recruitList.get(i).getId()%></td>--%>
    <tr> <td><%=recruitList.get(i).getCompanyname()%></td>
                 <td><%=recruitList.get(i).getNeednum()%></td>
                 <td><%=recruitList.get(i).getLocation()%></td>
                 <td><%=recruitList.get(i).getJob()%></td>
                 <td><%=recruitList.get(i).getSal()%></td>
                 <%--<td><%=recruitList.get(i).getJobduty()%></td>--%>
                 <%--<tr><%=recruitList.get(i).getDatatime()%></tr>--%>
                 <td><%=recruitList.get(i).getPromulgator()%></td>
    </tr>

        <%
            }%>

</table>

</div></center>
</div>
</body>
</html>
