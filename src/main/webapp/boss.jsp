<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>poss直聘</title>
    <link rel="icon" href="img/benz.png">
    <link rel="stylesheet" href="css/boss.css">
    <link rel="stylesheet" href="css/px.css">
    <link rel="stylesheet" href="css/photo.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <link rel="stylesheet" href="css/pfimforcuser.css">
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.js"></script>
    <%--<script type="text/javascript" src="js/pfimforcuser.js"></script>--%>
    <style type="text/css">
        /* img{
            z-index: -1;
        } */
    </style>
</head>
<body>
<c:forEach begin="0" end="0" items="${userImformation}" var="userImfor" step="1">
    <c:set var="userImforGet" value="${userImfor}" scope="request"></c:set>
    <%--<c:set var="userName" value="${userImfor.userName}" scope="session"></c:set>--%>
</c:forEach>
<c:set var="userKindRe" value="${sessionScope.userKindChoose}" scope="request"></c:set>

<div class="all">
    <!-- 头部开始 -->
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
                                <li class=""><a href="/fabu.jsp">招聘信息</a></li>
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
                                <li><a class="imf" href="/updateperson.do" >个人信息</a></li>
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
    </div>
    <!-- 头部结束 -->
    <!-- 搜索框开始 -->
    <div class="sou">
        <div class="sou1">
           <%-- <div class="city">
                <select  style="width: 96px;height: 44px;">
                    <option value="xiala">北京</option>
                    <option value="xiala">上海</option>
                    <option value="xiala">广州</option>
                    <option value="xiala">深圳</option>
                </select>
            </div>--%>
            <form method="post" action="/search.do?method=searchImfor">
                <div class="sou2">
                    <!-- <input type="text" name="name" style="width:330px; height:30px; padding-left: 2px;padding-top: 7px" /> -->
                    <input type="text" name="searchInput" style="margin-left: 0px;margin-top: 0px;padding-right: 438px;padding-top: 12px;padding-bottom: 12px" placeholder="搜索职位、公司">
                </div>
                <div class="logo1" onclick="document.getElementById('search-btn').click();"></div>
                <button type="submit" class="btn-info" style="display: none" id="search-btn">搜索</button>
            </form>
<%--            <div class="work">
                <select  style="width: 100px;height: 44px;">
                    <option value="xiala"></option>
                    <option value="xiala">公司行业</option>
                    <option value="xiala">O2O</option>
                    <option value="xiala">电子商务</option>
                    <option value="xiala">互联网</option>
                </select>
            </div>--%>

        </div>
<%--        <div class="zhiwei">
            <b style="color:rgb(159, 163,172);">热门职位:</b>
            <a href="" style=" margin-left:14px; color:rgb(159, 163,172);" >Java</a>
            <a href="" style=" margin-left:14px; color:rgb(159, 163,172);">PHP</a>
            <a href="" style=" margin-left:14px; color:rgb(159, 163,172);">C++</a>
            <a href="" style=" margin-left:14px; color:rgb(159, 163,172);">web前端</a>
            <a href="" style=" margin-left:14px; color:rgb(159, 163,172);">IOS</a>
            <a href="" style=" margin-left:14px; color:rgb(159, 163,172);">Android</a>
            <a href="" style=" margin-left:14px; color:rgb(159, 163,172);">产品经理</a>
            <a href="" style=" margin-left:14px; color:rgb(159, 163,172);">UI设计师</a>
            <a href="" style=" margin-left:14px; color:rgb(159, 163,172);">产品运营</a>
        </div>--%>
    </div>
    <!-- 搜索框结束 -->
    <%--图片开始--%>
    <div class="banner container">
        <div class="banner-left">
            <ul>
                <li><a href="/search.do?method=searchImfor&searchInput=嵌入式软件高级工程师">嵌入式软件高级工程师</a></li>
                <li><a href="/search.do?method=searchImfor&searchInput=运维实施经理">运维实施经理</a></li>
                <li><a href="/search.do?method=searchImfor&searchInput=高级后台开发">高级后台开发</a></li>
                <li><a href="/search.do?method=searchImfor&searchInput=web前端开发(高级)工程师">web前端开发(高级)工程师</a></li>
                <li><a href="/search.do?method=searchImfor&searchInput=高级测试工程师">高级测试工程师</a></li>
                <li><a href="/search.do?method=searchImfor&searchInput=java研发专家">java研发专家</a></li>
                <li><a href="/search.do?method=searchImfor&searchInput=大数据开发工程师">大数据开发工程师</a></li>
                <li><a href="">人力资源</a></li>
                <li><a href="">UI设计师</a></li>
                <li><a href="">IOS</a></li>
            </ul>
        </div>
        <div class="photo">
            <div class="p1-1"></div>
            <div class="p1-2"></div>
            <div class="p1-3"></div>
            <div class="p1-4"></div>
            <div class="p1-5"></div>
        </div>
    </div>
    <%--图片结束--%>
    <!-- 职位开始 -->
    <div class="zhaopin">
        <div class="tabbable" id="tabs-602554"><!-- Only required for left/right tabs -->
            <ul class="nav nav-tabs">
                <li><a contenteditable="true" data-toggle="tab" href="#panel-334288" style="color:rgb(159, 163,172);">嵌入式软件高级工程师</a></li>
                <li class="active"><a contenteditable="true" data-toggle="tab" href="#panel-816191" style="color:rgb(159, 163,172);">运维实施经理</a></li>
                <li ><a contenteditable="true" data-toggle="tab" href="#panel-816192" style="color:rgb(159, 163,172);">高级后台开发</a></li>
                <li ><a contenteditable="true" data-toggle="tab" href="#panel-816193" style="color:rgb(159, 163,172);">web前端开发(高级)工程师</a></li>
                <li ><a contenteditable="true" data-toggle="tab" href="#panel-816194" style="color:rgb(159, 163,172);">高级测试工程师</a></li>
                <li ><a contenteditable="true" data-toggle="tab" href="#panel-816195" style="color:rgb(159, 163,172);">java研发专家</a></li>
                <li ><a contenteditable="true" data-toggle="tab" href="#panel-816196" style="color:rgb(159, 163,172);">大数据开发工程师</a></li>
            </ul>

            <div class="tab-content">
                <div class="tab-pane active" contenteditable="true" id="panel-334288">

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>

                        </div>

                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                </div>

                <div class="tab-pane" contenteditable="true" id="panel-816191">
                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>
                </div>

                <div class="tab-pane" contenteditable="true" id="panel-816192">

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>
                </div>

                <div class="tab-pane" contenteditable="true" id="panel-816193">

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                </div>

                <div class="tab-pane" contenteditable="true" id="panel-816194">

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                </div>

                <div class="tab-pane" contenteditable="true" id="panel-816195">

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                </div>

                <div class="tab-pane" contenteditable="true" id="panel-816196">

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                    <div class="zhaopin1">
                        <div class="zhaopin1-1">
                            <p class="company" style="line-height: 35px">腾讯医典高级后台开发(深圳)
                                <span class="company1">20k-40k</span>
                            </p>
                            <p class="money" style="line-height: 35px">深圳&nbsp;|&nbsp;5-10年&nbsp;|&nbsp;本科</p>
                        </div>
                        <div class="zhaopin1-2">
                            <p class="hr" style="line-height: 35px">今日头条&nbsp;|&nbsp;某某某&nbsp;|&nbsp;招聘者    </p>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!-- 职位结束 -->
    <!-- 公司 -->
<%--    <div class="com">

        <div class="com1">
            <p class="com1-1">美团</p>
            <p class="com1-2">互联网</p>
            <p class="com1-3">15个在招职位</p>
        </div>

        <div class="com1">
            <p class="com1-1">美团</p>
            <p class="com1-2">互联网</p>
            <p class="com1-3">15个在招职位</p>
        </div>

        <div class="com1">
            <p class="com1-1">美团</p>
            <p class="com1-2">互联网</p>
            <p class="com1-3">15个在招职位</p>
        </div>

        <div class="com1">
            <p class="com1-1">美团</p>
            <p class="com1-2">互联网</p>
            <p class="com1-3">15个在招职位</p>
        </div>

        <div class="com1">
            <p class="com1-1">美团</p>
            <p class="com1-2">互联网</p>
            <p class="com1-3">15个在招职位</p>
        </div>

        <div class="com1">
            <p class="com1-1">美团</p>
            <p class="com1-2">互联网</p>
            <p class="com1-3">15个在招职位</p>
        </div>

        <div class="com1">
            <p class="com1-1">美团</p>
            <p class="com1-2">互联网</p>
            <p class="com1-3">15个在招职位</p>
        </div>

        <div class="com1">
            <p class="com1-1">美团</p>
            <p class="com1-2">互联网</p>
            <p class="com1-3">15个在招职位</p>
        </div>

    </div>--%>
    <!-- 公司结束 -->
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
<script>
    $(function () {
/*        $(".logo1").click(function () {
            $(this).submit();
        })*/
    })
</script>
</html>