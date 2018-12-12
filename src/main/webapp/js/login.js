$(function () {
/*    $(".btnChoose1").click(function () {
        $(this).addClass("btn-info").removeClass("btn-default");
        $(".userKind").attr("value","usernameLogin");
        $("#username").attr("placeholder","用户");
        $(".btnChoose2").removeClass("btn-info").addClass("btn-default").attr("value","")
    })
    $(".btnChoose2").click(function () {
        $(this).addClass("btn-info").removeClass("btn-default"),
        $(".userKind").attr("value","emailLogin");
        $("#username").attr("placeholder","邮箱");
        $(".btnChoose1").removeClass("btn-info").addClass("btn-default").attr("value","")
    })*/
    $(".control").click(function () {
        $(".control").hide();
        $("#mpanel4").show();
    })
    $('#mpanel4').slideVerify({
        type : 2,		//类型
        vOffset : 5,	//误差量，根据需求自行调整
        vSpace : 5,	//间隔
        imgName : ['3.jpg', '4.jpg','5.jpg','6.jpg','7.jpg'],
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
            $("#mpanel4").hide();
            $(".cheking").attr("value","1");
            //......后续操作
        },
        error : function() {
//		        	alert('验证失败！');

        }

    });
})

/*});*/
