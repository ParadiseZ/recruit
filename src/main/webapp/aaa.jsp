<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 崔肖龙
  Date: 2018/12/27
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bbb.css">
    <link rel="stylesheet" href="css/px.css">

</head>
<body class="ccc">
<div class="header">
    <div class="top">
        <div ><a  class="logo" href="" style=" text-decoration: none;" onclick="window.open('/boss.jsp')">POSS直聘</a></div>
        <div class="box1" onclick="window.open('/boss.jsp')">首页</div>
        <div class="box">职位</div>
        <div class="box">公司</div>
        <div class="top1">
            <div class="box2">上传简历</div>
            <div class="box2">我要招聘</div>
            <!-- <div class="box3"> -->
            <button class="button" style="color: #fff;"> 注册</button>
            <!-- </div> -->
            <!-- <div class="box3"> -->
            <a href=""><button class="button" style="color: #fff;"> 登录</button></a>
            <!-- </div> -->
        </div>
    </div>
</div>
<div class="p">
    <c:forEach begin="0" end="5" items="${sessionScope.searchImformation}" var="searchImfor" step="1">
    <div class="px">
        <div class="px1">
            <div class="px1-1">${searchImfor.job}&nbsp;&nbsp;${searchImfor.sal}</div>
            <div class="px1-2" style="font-size: 12px">${searchImfor.location}&nbsp;&nbsp;|&nbsp;&nbsp;${searchImfor.datatime}&nbsp;&nbsp;|&nbsp;&nbsp;本科</div>
        </div>
        <div class="px2">
            <div class="px1-1" >${searchImfor.companyname}</div>
            <div class="px1-2" style="font-size: 12px">互联网&nbsp;&nbsp;|&nbsp;&nbsp;已上市&nbsp;&nbsp;|&nbsp;&nbsp;${searchImfor.neednum}</div>
        </div>
        <div class="px3">
            <button class="button1" onclick="window.open('/ps.jsp')">简历上传</button>
        </div>
    </div>
    </c:forEach>
</div>
<!-- bottom开始 -->
<div class="bottom">
    <div class="bottom1">
        <table class="bottom1-1">
            <tr>
                <td class="word">企业服务</td>
                <td class="word">使用与帮助</td>
                <td class="word">联系我们</td>
            </tr>
            <tr>
                <td class="word1">职位搜索</td>
                <td class="word1">用户协议与隐私政策</td>
                <td class="word1">蓝桥第一组</td>
            </tr>
            <tr>
                <td class="word1">新闻资讯</td>
                <td class="word1">防骗指南</td>
                <td class="word1">公司地址</td>
            </tr>
            <tr>
                <td class="word1"></td>
                <td class="word1">职位发布规则</td>
                <td class="word1">联系电话&nbsp;010-5213649</td>
            </tr>
            <tr>
                <td class="word1"></td>
                <td class="word1">使用帮助</td>
                <td class="word1">违法信息举报&nbsp;lanqiao@dsz.com</td>
            </tr>
        </table>
        <div class="bottom1-2">
            <div class="bottom1-2-1">POSS直聘</div>
            <div class="bottom1-2-2">企业服务热线和举报电话&nbsp;524&nbsp;365&nbsp;956</div>
            <div class="bottom1-2-3">工作日&nbsp;9:30&nbsp;~&nbsp;18:30</div>
        </div>
    </div>
</div>
<!-- bottom结束 -->
<!-- 底部栏开始 -->
<div class="di">
    <div class="di1">
        <div class="di1-1">Copyright&nbsp;&copy;&nbsp;2018&nbsp;POSS直聘</div>
        <div class="di1-1">京ICP备14013441号-5</div>
        <div class="di1-1">电子营业执照</div>
        <div class="di1-1">京公网安备11010502032801</div>
        <div class="di1-1">首都网警</div>
    </div>
</div>

<!-- 底部栏结束 -->
</div>
</body>
</html>
