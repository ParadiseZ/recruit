<%--
  Created by IntelliJ IDEA.
  User: 杨佳珺
  Date: 2018/12/7
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="org.lanqiao.recruit.domain.Fabu" %>--%>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>发布招聘</title>


    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <script type="javascript" src="js/jquery-1.12.4.js"></script>
    <script type="javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/yang.css">
</head>
<body>
<div class="all">

    <form action="/recruit.do?method=addRecruit" method="post">
        <div class="top-zi">
        发布招聘界面
    </div>


        <div class="lb">
            公司名称：&nbsp;<input type="text" name="companyname" placeholder="如：XX公司" size="58">
        </div>


        <div class="lb2">
            需求人数：&nbsp;<input type="text" name="neednum"  placeholder="如：XX人" size="58">
        </div>


        <div class="lb3">


            公司地点：&nbsp;<input type="text" name="location" placeholder="如：天津" size="58">
        </div>


        <div class="lb4">
            职位名称：&nbsp;<input type="text" name="job" placeholder="如：java工程师" size="58">
        </div>


        <div class="lb5">
            薪资详情： <input type="text" name="sal" placeholder="如：1K-2K" size="58">

            <!-- <select name="" id="">
                <option value="">3K-5K</option>
                <option value="">5K-10K</option>
                <option value="">10K-15K</option>
                <option value="">15K-20K</option>
                <option value="">20K以上</option>
            </select>     -->
        </div>


        <%--<div class="lb6">--%>
        <%--职位要求：--%>
    <%--</div>--%>

        <%--<div class="lb7">--%>
            <%--<textarea name="职位" id="jobduty" cols="60" rows="5" placeholder="请在此输入..."></textarea>--%>
        <%--</div>--%>


        <%--<div class="lb8">--%>
            <%--发布时间：&nbsp;<input type="date" name="datatime" >--%>
        <%--</div>--%>


        <div class="lb9">
            发&nbsp;&nbsp;布&nbsp;&nbsp;人：&nbsp;<input type="text" name="promulgator" placeholder="请署名" size="58">
        </div>
        <!-- <div class="lb5">
             职位要求：&nbsp;
         </div> -->
        <div class="submit">
            <input type="submit" id="submit" value="提交">
            <!-- <script>
            function MsgBox()
            {
                alert("提交成功");
            }
            </script> -->
        </div>
    </form>






</div>


</body>
</html>







</div>
</body>
</html>