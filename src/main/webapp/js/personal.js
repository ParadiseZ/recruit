

//jquery验证性别
    function checkSubmit(form) {
        // $("#yonghu").focus(function () {
        //     //改变当前元素的背景元素
        //     $(this).css("background-color","red")
        // });
        // $("#yonghu").blur(function () {
        //     $(this).css("background-color","white")
        // })
        if ($("#sex").val() == "") {
            alert("性别为必选项!")
            $("#sex").focus();
            return false;
        }
        if ($("#born").val() == "") {
            alert("出生年月为必选项!")
            $("#born").focus();
            return false;
        }
        if ($("#worktime").val() == "") {
            alert("工作时间为必选项!")
            $("#worktime").focus();
            return false;
        }

        if ($("#position").val() == "") {
            alert("当前求职状态为必选项!")
            $("#position").focus();
            return false;
        }
        //手机号码验证
        if ($("#phone").val() == "") {
            alert("手机号码不能为空！");
//$("#moileMsg").html("<font color='red'>手机号码不能为空！</font>");
            $("#phone").focus();
            return false;
        }

        if (!$("#phone").val().match("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$")) {
            alert("手机号码格式不正确！");
//$("#moileMsg").html("<font color='red'>手机号码格式不正确！请重新输入！</font>");
            $("#phone").focus();
            return false;
        }
        //jquery验证邮箱
        if ($("#email").val() == "") {
//$("#confirmMsg").html("<font color='red'>邮箱地址不能为空！</font>");
            alert("邮箱不能为空!")
            $("#email").focus();
            return false;
        }
        if (!$("#email").val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
            alert("邮箱格式不正确");
//$("#confirmMsg").html("<font color='red'>邮箱格式不正确！请重新输入！</font>");
            $("#email").focus();
            return false;
        }
    }