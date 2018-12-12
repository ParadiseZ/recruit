<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2018/12/7
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:forEach begin="0" end="0" items="${sessionScope.userImformation}" var="userImfor" step="1">
    <c:set var="userImforGet" value="${userImfor}" scope="request"></c:set>
    <%--<c:set var="userName" value="${userImfor.userName}" scope="session"></c:set>--%>
</c:forEach>
    <c:choose>
    <c:when test="${userImforGet.phone==0}">
        <title>完善信息</title>
    </c:when>
    <c:otherwise>
        <title>修改信息</title>
    </c:otherwise>
    </c:choose>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="icon" href="/images/title.jpg" mce_href="/image/title.jpg" type="image/x-icon">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.css">
    <link rel="stylesheet" href="../css/boss.css">
    <link rel="stylesheet" href="../css/pfimforcuser.css">
    <script src="../js/jquery-1.12.4.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script type="text/javascript" src="../js/pfimforcuser.js"></script>
    <c:choose>
        <c:when test="${userImforGet.phone!=0}">
            <script type="text/javascript" src="../js/cusermodify.js"></script>
        </c:when>
    </c:choose>
</head>
<body>
    <div class="all">
    <!-- 头部开始 -->
    <div class="header">
        <div class="top">
            <div class="logo">POSS直聘</div>
            <div class="box1">首页</div>
            <div class="box">职位</div>
            <div class="box">公司</div>

            <div class="top1">
                <div class="dropdown">
                    <a id="dLabel" data-target="#" href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        ${userImforGet.userName}
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
<%--                        <li><a href=/pfimforcuser.jsp">个人信息</a></li>--%>
                        <li><a href="#">招聘信息</a></li>
                        <li><a href="/registerLogin.do?method=logout">退出登录</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
        <%--表单盒子--%>
        <div class="center-block form-div">
            <form class="form-horizontal center-block form-style" action="/registerLogin.do" method="post" onsubmit="return checkSubmitEmailPhone(this)">
                <c:choose>
                    <c:when test="${userImforGet.phone==0}">
                        <input type="text" style="display: none" name="method" value="registerFinal">
                    </c:when>
                    <c:otherwise>
                        <input type="text" style="display: none" name="method" value="modify">
                        <input type="text" style="display: none" name="id" value="${userImforGet.id}">
                    </c:otherwise>
                </c:choose>
                <div class="form-group col-sm-12">
                    <h5 class="text-center warning" style="color: red">${requestScope.error}${requestScope.success}</h5>
                </div>
                <div class="form-group col-sm-12">
                    <p class="text-center" style="font-size: large">企业用户信息</p>
                </div>
                <div class="form-group">
                    <label for="username" class="col-sm-3 control-label">用户名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control input-control" id="username" name="username" value="${userImforGet.userName}" placeholder="用户名">
                        <input type="text" style="display: none" class="" name="usernameOld" value="${userImforGet.userName}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control input-control" id="password" name="password" value="${userImforGet.password}" placeholder="密码">
                    </div>
                </div>

                <div class="form-group">
                    <label for="phone" class="col-sm-3 control-label">联系方式</label>
                    <div class="col-sm-6">
                        <c:choose>
                            <c:when test="${userImforGet.phone==0}">
                                <input type="text" class="form-control input-control" id="phone" name="phone" value="" placeholder="手机号">
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="form-control input-control" id="phone" name="phone" value="${userImforGet.phone}" placeholder="手机号">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <div class="form-group">
                    <label for="corporation" class="col-sm-3 control-label">法定代表人</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control input-control" id="corporation" name="corporation" value="${userImforGet.corporation}" placeholder="法定代表人">
                    </div>
                </div>

                <div class="form-group">
                    <label for="companyname" class="col-sm-3 control-label">公司名称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control input-control" id="companyname" name="companyname" value="${userImforGet.companyName}" placeholder="所在公司名称">
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">邮箱</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control input-control" id="email" name="email" value="${userImforGet.email}" placeholder="邮箱">
                    </div>
                </div>

                <div class="form-group">
                    <label for="job" class="col-sm-3 control-label">本人职位</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control input-control" id="job" name="job" value="${userImforGet.job}" placeholder="本人担任职位">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-10">
                        <c:choose>
                        <c:when test="${userImforGet.phone==0}">
                            <button type="submit" class="btn btn-info">保存并注册</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <%--<button type="button" class="btn btn-info">完善公司信息</button>--%>
                        </c:when>
                        <c:otherwise>
                            <button type="button" class="btn btn-info modify">点击修改</button>
                            <button type="submit" class="btn btn-info saveImfor" style="display: none">保存信息</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-info">修改公司信息</button>
                        </c:otherwise>
                        </c:choose>
                    </div>
                    <%--<div class="col-sm-offset-2 col-sm-6">
                        <button type="submit" class="btn btn-default">完善公司信息</button>
                    </div>--%>
                </div>
            </form>

        </div>
    </div>
</body>
</html>
