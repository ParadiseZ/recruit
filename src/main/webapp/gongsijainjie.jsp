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
    <title>公司简介</title>
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
    </script>
</head>
<body class="guide">
<div class="header">
    <div class="head">
        <h3>您的公司信息</h3>
    </div>
    <form class="form-horizontal" action="/gongsijianjie.do" method="post">
        <div class="form-group">
            <label  class="col-sm-2 control-label">公司简介</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="5" name="pad1" id="pad1"></textarea>
            </div>
        </div>

        <input type="text" value="关于我们"  name="women"style="display:none"></input>

        <div class="form-group">
            <input class="col-sm-2 control-label" type="text" name="use" placeholder="企业文化" />
                <%--<label  class="col-sm-2 control-label" name="wenhua">企业文化</label>--%>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="5" name="pad2" id="pad2"></textarea>
                </div>
            </div>
    <div class="form-group">
        <%--<label  class="col-sm-2 control-label" name="jiazhi">企业价值观</label>--%>
            <input class="col-sm-2 control-label" type="text" name="jiazhi" placeholder="企业价值观" />
            <div class="col-sm-10">
            <textarea class="form-control" rows="5" name="pad3" id="pad3"></textarea>
        </div>
    </div>
        <div class="form-group">
    <%--<label  class="col-sm-2 control-label" name="rencai">人才理念</label>--%>
        <input class="col-sm-2 control-label" type=text" name="rencai" placeholder="人才理念" />
        <div class="col-sm-10">
        <textarea class="form-control" rows="5" name="pad4" id="pad4"></textarea>
    </div>
</div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">保存公司简介</button>
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
