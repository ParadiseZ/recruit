<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/4/004
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/personal.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.css">
    <%--<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">--%>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript"src="js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript" src="js/personal.js"></script>
    <script type="text/javascript">
        // $('#datetimepicker').datetimepicker('show');
      $(function () {
    $(".form_datetime").datetimepicker({
    format: "yyyy-mm",
    autoclose: true,
    todayBtn: true,
    pickerPosition: "bottom-center",
    minView:"month",
    language:'zh-CN',
    });
    })

    </script>
</head>
<body class="guide">
<div class="header">
    <div class="head">
    <h3>完善您的基本信息</h3>
    </div>
    <%
    Object name = request.getAttribute("username");
        Object password = request.getAttribute("password");
    %>
<div class="xinxi">在POSS直聘每一个完善信息的求职者，平均每天会遇到 5 个对你感兴趣的 Boss</div>
   <div class="from1">
       <form class="form-horizontal" action="/rr.do?method=getpersonalmessage" method="post" onsubmit="return checkSubmit(this)">
           <div class="form-group">
               <label  class="col-sm-2 control-label">用户名</label>
               <div class="col-sm-10">
                   <input type="" class="form-control"  name ="username" value="<%=name%>" placeholder="输入您的姓名" readonly>
               </div>
           </div>
           <div class="form-group">
               <label class="col-sm-2 control-label">密码</label>
               <div class="col-sm-10">
                   <input type="password" class="form-control" id="inputPassword3"name="password" value="<%=password%>"placeholder="输入您的密码"readonly>
               </div>
           </div>
           <div class="form-group">
               <label  class="col-sm-2 control-label" >性别</label>
           <div class="col-sm-10">
               <select class="form-control" id="sex" name="sex">
                   <option></option>
                   <option>男</option>
                   <option>女</option>
               </select>
           </div>
           </div>
           <div class="form-group" >
               <label  class="col-sm-2 control-label" >出生年月</label>

           <div class="input-append date form_datetime" >
               <input size="16"  id="born" name="born"type="text" value="" readonly maxview>
               <span class="add-on"><i class="icon-th"></i></span>
           </div>
           </div>

           <div class="form-group">
               <label  class="col-sm-2 control-label" >工作时间</label>

           <div class="input-append date form_datetime">
               <input size="16"  id="worktime"type="text" name="gtime" value="" readonly maxview>
               <span class="add-on"><i class="icon-th"></i></span>
           </div>
           </div>

           <div class="form-group">
               <label  class="col-sm-2 control-label">当前求职状态</label>
               <div class="col-sm-10">
                   <select class="form-control" name="position"  id="position">
                       <option>离职-随时到岗</option>
                       <option>在职-暂不考虑</option>
                       <option>在职-考虑机会</option>
                       <option>在职-月内到岗</option>
                   </select>
               </div>
           </div>
           <div class="form-group">
               <label  class="col-sm-2 control-label">联系电话</label>
               <div class="col-sm-10">
                   <input type="" name=phone class="form-control"id="phone" placeholder="请留下您的联系方式">
               </div>
           </div>
           <div class="form-group">
               <label  class="col-sm-2 control-label">邮箱</label>
               <div class="col-sm-10">
                   <input type="" class="form-control" id="email" name="emial" placeholder="Email">
               </div>
           </div>
           <div class="form-group">
               <label  class="col-sm-2 control-label">学校名称</label>
               <div class="col-sm-10">
                   <input type=""  name="pschool" id="school" class="form-control"  placeholder="例如：北京大学">
               </div>
           </div>
           <div class="form-group">
               <label   class="col-sm-2 control-label">您的学历</label>
               <div class="col-sm-10">
                   <select class="form-control"  id="xueli" name="xueli">
                       <option>初中及以下</option>
                       <option>中专/中技</option>
                       <option>高中</option>
                       <option>大专</option>
                       <option>本科</option>
                       <option>硕士</option>
                       <option>博士</option>
                   </select>
               </div>
           </div>
           <div class="form-group">
               <label  class="col-sm-2 control-label">所学专业</label>
               <div class="col-sm-10">
                   <input type="" name="zhuanye" id="zhuanye" class="form-control"  placeholder="例如：信息与计算科学">
               </div>
           </div>
           <div class="form-group">
               <label  class="col-sm-2 control-label">期望的职位</label>
               <div class="col-sm-10">
                   <input type=""name="exjob" class="form-control" id="exjob" placeholder="例如：软件开发工程师">
               </div>
           </div>
           <div class="form-group">
               <label  class="col-sm-2 control-label">期望的薪资范围</label>
               <div class="col-sm-10">
                   <select class="form-control" name="exsal"  id="exsal">
                       <option>2K</option>
                       <option>3K</option>
                       <option>4k</option>
                       <option>5k</option>
                       <option>6k</option>
                       <option>7k</option>
                       <option>8k</option>
                       <option>9K</option>
                       <option>10K</option>
                       <option>10-20k</option>
                       <option>30-40k</option>
                       <option>50-100k</option>
                       <option>100-500k</option>
                   </select>
               </div>
           </div>
           <div class="form-group">
               <label  class="col-sm-2 control-label">个人优势</label>
               <div class="col-sm-10">
                   <textarea class="form-control" rows="5" name="pad" id="pad"></textarea>
               </div>
           </div>
           <div class="form-group">
               <div class="col-sm-offset-2 col-sm-10">
                   <button type="submit" class="btn btn-primary btn-lg btn-block">注册并保存</button>
                   <button type="reset" class="btn btn-default btn-lg btn-block">重置</button>
                   <%--<button type="submit" class="btn btn-primary btn ">保存并注册</button>--%>
                   <%--<button type="reset" class="btn btn-warning">重置</button>--%>
               </div>
           </div>
       </form>
   </div>
</div>
</body>
</html>
