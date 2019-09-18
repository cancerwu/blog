$(function () {
    $("#login_chose1").click(function () {
        $("#login_check").fadeIn(500);
    })
    $("#login_chose2").click(function () {
        $("#register").fadeIn(500);
    })
    $("#eLogin").click(function () {
        $("#login_check").hide();
        $("#register").fadeIn(500);
    })
    $("#uLogin").click(function () {
        $("#register").hide();
        $("#login_check").fadeIn(500);
    })

    $("#uidLogin").click(function () {
        var userName = $("#user").val();
        var password = $("#pass").val();
        $.ajax({
            url :"/login",
            type:"post",
            dataType:"text",
            data:{'userName':userName,'password':password},
            success:function (data) {
                if (data==userName){
                    window.location.href = "/blogIndex.html";
                }else {
                    alert("账户或密码错误");
                }
            }
        })
    })

})