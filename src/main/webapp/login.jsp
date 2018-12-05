<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/4/004
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/verify.css">
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/verify.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
    <script>
        $(function () {
            $(".btnChoose1").click(function () {
                $(this).addClass("btn-info").removeClass("btn-default")
                $(".btnChoose2").removeClass("btn-info").addClass("btn-default")
            })
            $(".btnChoose2").click(function () {
                $(this).addClass("btn-info").removeClass("btn-default")
                $(".btnChoose1").removeClass("btn-info").addClass("btn-default")
            })
            $(".control").click(function () {
                $(".control").hide()
                $("#mpanel4").show()
            })
            $('#mpanel4').slideVerify({
                type : 2,		//类型
                vOffset : 5,	//误差量，根据需求自行调整
                vSpace : 5,	//间隔
                imgName : ['1.jpg', '2.jpg'],
                imgSize : {
                    width: '400px',
                    height: '200px',
                },
                blockSize : {
                    width: '40px',
                    height: '40px',
                },
                barSize : {
                    width : '400px',
                    height : '40px',
                },
                ready : function() {
                },
                success : function() {
                    alert('验证成功！');
                    $("#mpanel4").hide()
                    //......后续操作
                },
                error : function() {
//		        	alert('验证失败！');
                }

            });
        })
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
        <form method="post" action="#" class="form-horizontal form-register center-block">

            <div class="form-group">
                <%--<label for="inputEmail3" class="col-sm-2 control-label"></label>--%>
                <div class="col-sm-10">
                    <button type="button" class="btn btn-info btnChoose1" name="">用户名登陆</button>
                    <button type="button" class="btn btn-default btnChoose2" name="">邮箱登陆</button>
                </div>
            </div>

            <div class="form-group">
                <%--<label for="inputEmail3" class="col-sm-2 control-label"></label>--%>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="username" placeholder="用户名">
                </div>
            </div>
            <div class="form-group" id="mpanel4">
            </div>
            <div class="form-group">
                <div class="col-sm-10">
                    <input type="button" class="control form-control" value="点击进行验证" style="">
                </div>
            </div>
            <div class="form-group">
                <%--<label for="inputPassword3" class="col-sm-2 control-label"></label>--%>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="密码">
                </div>
            </div>
            <div class="form-group">
                <%--<label for="inputPassword3" class="col-sm-2 control-label"></label>--%>
                <div class="col-sm-10">
                    <input type="submit" class="form-control" id="" value="登录">
                </div>
            </div>
        </form>

        <div class="form-group">
            <div class="col-sm-12">
                <span class="right-buttom">已有账号<a href="/login.jsp" class="colorMy" style="">立即登录</a></span>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
