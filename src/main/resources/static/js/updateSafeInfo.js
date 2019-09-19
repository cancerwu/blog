layui.use('layedit', function(){
    $.ajax({
        url: "/getUserInfo",
        dataType: "json",
        success: function (data) {
            $(".loginheadpic img").attr("src", "face/" + data.userPic);
        }
    });
    $("#searchtext").click(function () {
        var str = "搜索框"
        if ($(this).val() == str) {
            $(this).val("");
        }
    });


    $("a[name='changepas']").click(function () {
        closeAllDiv();
        $(".changepassword").css("display", "block")
    })
    $("a[name='changetel']").click(function () {
        closeAllDiv();
        $(".changetel").css("display", "block")
    })
    $("a[name='changeEmail']").click(function () {
        closeAllDiv();
        $(".changeEmail").css("display", "block")
    })



    $.ajax({
        url: "/getUserId",
        dataType: "json",
        success: function (data) {
            $("#b1").click(function () {
                var newpassword = $("#pass").val();
                $.ajax({
                    url: "/updateUsersafe",
                    type:"post",
                    dataType:"text",
                    data:{'userId':data,'password':newpassword},
                    success: function (data1) {

                    }
                })
            })
        }
    })
    $.ajax({
        url: "/getUserId",
        dataType: "json",
        success: function (data) {
            $("#b1").click(function () {
                var newtel = $("#tel").val();
                $.ajax({
                    url: "/updateUsersafe",
                    type:"post",
                    dataType:"text",
                    data:{'userId':data,'userTel':newtel},
                    success: function (data1) {

                    }
                })
            })
        }
    })
    $.ajax({
        url: "/getUserId",
        dataType: "json",
        success: function (data) {
            $("#b1").click(function () {
                var newemail = $("#emil").val();
                $.ajax({
                    url: "/updateUsersafe",
                    type:"post",
                    dataType:"text",
                    data:{'userId':data,'userEmial':newemail},
                    success: function (data1) {

                    }
                })
            })
        }
    })

    // $(".leftlabel").children().eq(0).click(function () {
    //     alert("success")
    //     closeAllDiv();
    //     $(".safestatus").css("display","block")
    // })

    // $(".leftlabel").children().eq(1).click(function () {
    //     alert("success")
    //     closeAllDiv();
    //     $(".changepassword").css("display","block")
    // })
    // $(".leftlabel").children().eq(2).click(function () {
    //     alert("success")
    //     closeAllDiv();
    //     $(".changetel").css("display","block")
    // })
    // $(".leftlabel").children().eq(3).click(function () {
    //     alert("success")
    //     closeAllDiv();
    //     $(".changeEmail").css("display","block")
    // })

    $("input[type='text']").click(function () {
        var patt = new Array();
        patt[0] = "搜索框";
        patt[1] = "请输入旧密码";
        patt[2] = "请输入新密码";
        patt[3] = "请确认新密码"
        patt[4] = "请输入旧手机号"
        patt[5] = "请输入新手机号"
        patt[6] = "请输入旧邮箱"
        patt[7] = "请输入新邮箱"
        for (var i = 0; i < patt.length; i++) {
            if ($(this).val() == patt[i]) {
                $(this).val("");
                break;
            }
        }
    });

    function closeAllDiv() {
        $(".changepassword").css("display", "none")
        $(".changetel").css("display", "none")
        $(".changeEmail").css("display", "none")
        $(".safestatus").css("display", "none")
    }
})