<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/8/008
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="html">
<head>
    <c:forEach begin="0" end="0" items="${sessionScope.userImformation}" var="userImfor" step="1">
        <c:set var="userImforGet" value="${userImfor}" scope="request"></c:set>
        <%--<c:set var="userName" value="${userImfor.userName}" scope="session"></c:set>--%>
    </c:forEach>
    <title>${userImforGet.pname}</title>
    <link rel="stylesheet" href="css/personal.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript"src="js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".form_datetime").datetimepicker({
                format: "yyyy-mm",
                autoclose: true,
                todayBtn: true,
                pickerPosition: "bottom-center",
                minView:"month",
                language:'zh-CN',
            });

            $.ajax({
                function(date){
                    var imfGet = eval(date);
                    $(".username").val(imfGet.pname);
                    $(".password").val(imfGet.password)
                }
            })

            $("#xiugai").click(function () {
                $("#uploadForm").submit();

            })

        })

    </script>
</head>
<body  class="guide">


<div class="header">
    <div class="head">
        <h3>修改个人信息</h3>
    </div>


    <%--<input type="text" value="${userImforGet.padvantage}">--%>

    <%--<input type="text" value="${userImforGet.psal}">--%>

    <div class="xinxi">在POSS直聘每一个完善信息的求职者，平均每天会遇到 5 个对你感兴趣的 Boss</div>
    <div class="from1 ">
        <form class="form-horizontal" action="/updateperson.do?method=updateperson" method="post"id="uploadForm">

            <input type="text" value="${userImforGet.pid}" name="pid" style="display: none">

            <div class="form-group">
                <label  class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input class="username" type="text" class="form-control" value="${userImforGet.pname}" name ="username"  placeholder="" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input class="password" type="password" class="form-control" value="${userImforGet.password}"id="inputPassword3"name="password" placeholder="输入您的密码" >
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label" >性别</label>
                <div class="col-sm-10">
                    <select class="form-control"type="text" name="sex">
                        <option <c:if test="${userImforGet.psex==''}"> selected</c:if> ></option>
                        <option <c:if test="${userImforGet.psex=='男'}"> selected</c:if> >男</option>
                        <option <c:if test="${userImforGet.psex=='女'}"> selected</c:if> >女</option>
                    </select>
                </div>
            </div>
            <div class="form-group" >
                <label  class="col-sm-2 control-label" >出生年月</label>

                <div class="input-append date form_datetime" >
                    <input size="16"  name="born"type="text"value="${userImforGet.pborn}"   >
                    <span class="add-on"><i class="icon-th"></i></span>
                </div>
            </div>

            <div class="form-group">
                <label  class="col-sm-2 control-label" >工作时间</label>

                <div class="input-append date form_datetime">
                    <input size="16" type="text" name="gtime" value="${userImforGet.ptime}"  >
                    <span class="add-on"><i class="icon-th"></i></span>
                </div>
            </div>

            <div class="form-group">
                <label  class="col-sm-2 control-label">当前求职状态</label>
                <div class="col-sm-10">
                    <select class="form-control"type="text" name="position">
                        <option <c:if test="${userImforGet.pstate=='离职-随时到岗'}"> selected</c:if>>离职-随时到岗</option>
                        <option <c:if test="${userImforGet.pstate=='在职-暂不考虑'}"> selected</c:if>>在职-暂不考虑</option>
                        <option <c:if test="${userImforGet.pstate=='在职-考虑机会'}"> selected</c:if>>在职-考虑机会</option>
                        <option <c:if test="${userImforGet.pstate=='在职-月内到岗'}"> selected</c:if>>在职-月内到岗</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">联系电话</label>
                <div class="col-sm-10">
                    <input type="text" value="${userImforGet.phone}" name=phone class="form-control" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" value="${userImforGet.pemail}" name="emial" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">学校名称</label>
                <div class="col-sm-10">
                    <input type="text"  name="pschool" class="form-control" value="${userImforGet.pschool}" placeholder="例如：北京大学">
                </div>
            </div>
            <div class="form-group">
                <label   class="col-sm-2 control-label">您的学历</label>
                <div class="col-sm-10">
                    <select class="form-control"type="text" name="xueli" >
                        <option <c:if test="${userImforGet.pmajor=='初中及以下'}"> selected</c:if>>初中及以下</option>
                        <option <c:if test="${userImforGet.pmajor=='中专/中技'}"> selected</c:if>>中专/中技</option>
                        <option <c:if test="${userImforGet.pmajor=='高中'}"> selected</c:if>>高中</option>
                        <option <c:if test="${userImforGet.pmajor=='大专'}"> selected</c:if>>大专</option>
                        <option <c:if test="${userImforGet.pmajor=='本科'}"> selected</c:if>>本科</option>
                        <option <c:if test="${userImforGet.pmajor=='硕士'}"> selected</c:if>>硕士</option>
                        <option <c:if test="${userImforGet.pmajor=='博士'}"> selected</c:if>>博士</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">所学专业</label>
                <div class="col-sm-10">
                    <input type="text" name="zhuanye" value="${userImforGet.psrecord}" class="form-control" >
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">期望的职位</label>
                <div class="col-sm-10">
                    <input type="text" name="exjob" class="form-control" value="${userImforGet.pexjob}" >
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">期望的薪资范围</label>
                <div class="col-sm-10">
                    <%--${userImforGet.psal}--%>
                    <select class="form-control" type="text" name="exsal">
                        <option <c:if test="${userImforGet.psal=='2k'}"> selected</c:if>>2K</option>
                        <option  <c:if test="${userImforGet.psal=='3k'}"> selected</c:if>>3K</option>
                        <option  <c:if test="${userImforGet.psal=='4k'}"> selected</c:if>>4k</option>
                        <option  <c:if test="${userImforGet.psal=='5k'}"> selected</c:if>>5k</option>
                        <option  <c:if test="${userImforGet.psal=='6k'}"> selected</c:if>>6k</option>
                        <option  <c:if test="${userImforGet.psal=='7k'}"> selected</c:if>>7k</option>
                        <option  <c:if test="${userImforGet.psal=='8k'}"> selected</c:if>>8k</option>
                        <option  <c:if test="${userImforGet.psal=='9k'}"> selected</c:if>>9K</option>
                        <option  <c:if test="${userImforGet.psal=='10k'}"> selected</c:if>>10K</option>
                        <option  <c:if test="${userImforGet.psal=='10-20k'}"> selected</c:if>>10-20k</option>
                        <option <c:if test="${userImforGet.psal=='30-40k'}"> selected</c:if>>30-40k</option>
                        <option  <c:if test="${userImforGet.psal=='50-100k'}"> selected</c:if>>50-100k</option>
                        <option  <c:if test="${userImforGet.psal=='100-500k'}"> selected</c:if>>100-500k</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label  class="col-sm-2 control-label">个人优势</label>
                <div class="col-sm-10">
                    <textarea  type="text"class="form-control" rows="5" name="pad"> ${userImforGet.padvantage}</textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <button type="button" class="btn btn-danger " id="xiugai">修改</button>
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                  <a href="/boss.jsp"><button type="button" class="btn btn-success "   id="save">退出</button></a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
