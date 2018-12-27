<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/22/022
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>简历上传页面</title>
    <link rel="stylesheet" href="css/ps.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body class="cl1">
    <div class="c">
        <div class="cl2"></div>
    </div>
<form action="/upload.do"  method="post" enctype="multipart/form-data" >
    <%--用户：<input type="text"name="yongu"  id="yonghu">--%>
        <div class="cl4">
            <div class="cl5">请上传您的简历</div><br>
            <div class="cl6">支持DOC、DOCX、PDF格式简历文件</div><br>
           <div class="cl7">文件大小不超过 8 M</div><br>
           <div  class="cl8">
               <input type="file" name="pic" id="pic"></div><br><br><br>
            <div class="cl9 "><button  class="al btn btn-primary" type="submit">提交</button></div>
    </div>
</form>
</body>
</html>
