<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2018/12/10
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台登录-boss-manager</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <%--<script type="text/javascript" src="./js/xadmin.js"></script>--%>

</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">poss直聘-管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="" action="/manager.do?methodM=managerLogin">
        <h5 lay-verify="required" style="color: red" value="">${sessionScope.error}</h5>
        <hr class="hr15">
        <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" style="width:100%;" type="submit">
        <hr class="hr20" >
    </form>
</div>

</body>
</html>
