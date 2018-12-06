<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2018/12/2
  Time: 15:16
  To change this template use File | Settings | File Templates.
  注册页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="icon" href="/images/title.jpg" mce_href="/image/title.jpg" type="image/x-icon">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/verify.css">
    <link rel="stylesheet" href="css/register.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/verify.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
    <script>
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="header center-block">
        <div class="form-group">
            <%--<label for="inputEmail3" class="col-sm-2 control-label"></label>--%>
            <div class="col-sm-12">
                <h3 class="text-center colorMy">
                    登录poss直聘
                </h3>
            </div>
        </div>
        <br><br><br><br>
        <form method="post" action="/register.do" class="form-horizontal form-register center-block" onsubmit="return checkForm(this);">
            <input type="text" style="display: none" class="cheking" name="checking" value="0">
            <input type="text" style="display: none" class="userKind" name="userKind" value="puser">
            <div class="form-group">
                <%--<label for="inputEmail3" class="col-sm-2 control-label"></label>--%>
                <div class="col-sm-10">
                    <button type="button" class="btn btn-info btnChoose1" name="">用户名登录</button>
                    <button type="button" class="btn btn-default btnChoose2" name="">邮箱登录</button>
                </div>
            </div>

            <div class="form-group">
                <%--<label for="inputEmail3" class="col-sm-2 control-label"></label>--%>
                <div class="col-sm-10">
                    <input type="username" class="form-control" id="username" name="username" placeholder="用户名">
                </div>
            </div>
            <div class="form-group" id="mpanel4">
            </div>
            <div class="form-group">
                <div class="col-sm-10">
                    <input type="button" class="control controlCursor form-control" value="点击进行验证（图片右上角刷新）" style="">
                </div>
            </div>
            <div class="form-group">
                <%--<label for="inputPassword3" class="col-sm-2 control-label"></label>--%>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                </div>
            </div>
            <div class="form-group">
                <%--<label for="inputPassword3" class="col-sm-2 control-label"></label>--%>
                <div class="col-sm-10">
                    <input type="submit" class="controlCursor form-control colorMy" id="" value="登录">
                </div>
            </div>
        </form>

        <div class="form-group">
            <div class="col-sm-12">
                <span class="right-buttom">没有账号<a href="/register.jsp" class="colorMy" style="">立即注册</a></span>
                </divc>
            </div>
        </div>
    </div>
</div>
</body>
</html>
