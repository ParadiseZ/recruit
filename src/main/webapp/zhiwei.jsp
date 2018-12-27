<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2018/12/12
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:forEach begin="0" end="0" items="${userImformation}" var="userImfor" step="1">
        <c:set var="userImforGet" value="${userImfor}" scope="request"></c:set>
        <%--<c:set var="userName" value="${userImfor.userName}" scope="session"></c:set>--%>
    </c:forEach>
    <c:set var="userKindRe" value="${sessionScope.userKindChoose}" scope="request"></c:set>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>招聘展示</title>
    <link rel="icon" href="img/benz.png">
    <link rel="stylesheet" href="css/boss.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <link rel="stylesheet" href="css/pfimforcuser.css">
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.js"></script>
</head>
<body>
<div class="header">
    <div class="top">
        <div class="logo">POSS直聘</div>
        <div class="box1">首页</div>
        <div class="box">职位</div>
        <div class="box">公司</div>
        <div class="top1">
            <c:choose>
                <c:when test="${userKindRe eq 'cUser'}">
                    <div class="dropdown">
                        <a id="dLabel" data-target="#" href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                ${userImforGet.userName}
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/registerLogin.do?method=loginImfor">个人信息</a></li>
                            <li class=""><a href="#">招聘信息</a></li>
                            <li class=""><a href="/registerLogin.do?method=logout">退出登录</a></li>
                        </ul>
                    </div>
                </c:when>
                <%--                    <input value="${userImforGet}">--%>
                <c:when test="${userKindRe eq 'pUser'}">
                    <div class="dropdown">
                        <a id="" data-target="#" href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                ${userImforGet.pname}
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                                <%--                        <li><a href=/pfimforcuser.jsp">个人信息</a></li>--%>
                            <li><a class="imf" href="/updateperson.do?method=getBid" >个人信息</a></li>
                            <li><a href="/login.jsp">退出登录</a></li>
                        </ul>
                    </div>

                </c:when>
                <c:otherwise>
                    <div class="box2">上传简历</div>
                    <div class="box2">我要招聘</div>
                    <div class="box3">
                        <button class="button" onclick="window.open('/register.jsp')">注册</button>
                    </div>
                    <div class="box3">
                        <button class="button" onclick="window.open('/login.jsp')">登录</button>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <div>
        <table class="table table-hover">
            <thead>
                <th>职位名称</th>
                <th>需求人数</th>
                <th>薪资</th>
                <th>工作地点</th>
                <th>公司名称</th>
                <th>负责人</th>
                <th>经验要求（年）</th>
            </thead>
            <tbody>
                <c:forEach begin="0" end="10" items="${sessionScope.searchImformation}" var="searchImfor" step="1">
                    <tr>
                        <td>${searchImfor.job}</td>
                        <td>${searchImfor.neednum}</td>
                        <td>${searchImfor.sal}</td>
                        <td>${searchImfor.location}</td>
                        <td>${searchImfor.companyname}</td>
                        <td>${searchImfor.promulgator}</td>
                        <td>${searchImfor.datatime}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
</div>
</body>
</html>
