$(function () {
    $(".input-control").attr("readonly","readonly");
    $(".modify").click(function () {
        $(".input-control").removeAttr("readonly");
        $(".modify").hide()
        $(".saveImfor").show();
    })
})