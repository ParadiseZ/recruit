$(function () {

})

//jquery验证邮箱
function checkSubmitEmailPhone(form) {
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

    if ($("#phone").val() == "") {
        alert("手机号码不能为空！");
//$("#moileMsg").html("<font color='red'>手机号码不能为空！</font>");
        $("#phone").focus();
        return false;
    }

    if (!$("#phone").val().match(/^(((13[0-9]{1})|159|153)+\d{8})$/)) {
        alert("手机号码格式不正确！");
//$("#moileMsg").html("<font color='red'>手机号码格式不正确！请重新输入！</font>");
        $("#phone").focus();
        return false;
    }
    return true;
}
