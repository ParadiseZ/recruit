<%@ page import="org.lanqiao.recruit.utils.PageModel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zzj
  Date: 2018/12/10
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>个人用户页面-boss-manager1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">个人用户管理</a>
          <!--<a href="">演示</a>
          <a>
            <cite>导航元素</cite></a>-->
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" method="post" action="/manager.do?methodM=searchPuserImfor">
            <!--<input class="layui-input" placeholder="开始日" name="start" id="start">
            <input class="layui-input" placeholder="截止日" name="end" id="end">-->
            <input type="text" name="input-username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <button class="layui-btn search-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <span class="x-right" style="line-height:40px">共有数据：${sessionScope.countOfUserNum.pUserNum} 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>用户名</th>
            <th>性别</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>毕业院校</th>
            <th>状态</th>
            <th>操作</th></tr>
        </thead>
        <tbody>
            <c:forEach begin="0" end="30" items="${requestScope.userImfor}" var="userImf" step="1" varStatus="">
                <tr>
                    <td>
                        <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
                    </td>
                    <td>${userImf.pid}</td>
                    <td>${userImf.pname}</td>
                    <td>${userImf.psex}</td>
                    <td>${userImf.phone}</td>
                    <td>${userImf.pemail}</td>
                    <td>${userImf.pschool}</td>
                    <td>${userImf.pstate}</td>
                    <td class="td-manage">
                        <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <% PageModel pm = (PageModel)request.getAttribute("pm");%>
                <li><a href="/manager.do?methodM=findPageImforpUser&currentPage=<%=pm.getStartPage()%>">首页</a></li>
                <li>
                    <a href="/manager.do?methodM=findPageImforpUser&currentPage=<%=pm.getPrePageNum()%>" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <%
                    int pageNum = pm.getTotalPageNum();
                    for(int num=1;num<=pageNum;num++){
                        %>
                <li><a href="/manager.do?methodM=findPageImforpUser&currentPage=<%=num%>"><%=num%></a></li>
                <%
                    }
                %>
                    <a href="/manager.do?methodM=findPageImforpUser&currentPage=<%=pm.getNextPageNum()%>" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>

                <li><a href="/manager.do?methodM=findPageImforpUser&currentPage=<%=pm.getEndPage()%>">尾页</a></li>
            </ul>
        </nav>
    </div>

</div>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });


    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            var ddd = $(obj).parents("tr").children('td:eq(1)').text();
            $.ajax({
                url:"/manager.do?methodM=deletePuserImdor&ID="+ddd,
                success:function (date) {
                    var num = eval(date);
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                }
            })
/*            layer.msg(ddd);
            $(obj).parents("tr").remove();*/
        });
    }


    //批量删除
    function delAll (argument) {
        var data = tableCheck.getData();
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            var rrr = $(".layui-form-checked").not('.header');
            var selectNum=[];
            $.each(rrr,function () {
                selectNum.push($(this).parents("tr").children("td:eq(1)").text());
            });
            $.ajax({
                type:"post",
                url:"/manager.do?methodM=deleteAllpUser",
                traditional:true,
                data:{"attr":JSON.stringify(selectNum)},
                dataType:"json",
                success:function (date) {
                    $(".layui-form-checked").not('.header').parents('tr').remove();
                    layer.msg('删除成功', {icon: 1});
                }
            })
        });
    }

</script>
</body>

</html>
