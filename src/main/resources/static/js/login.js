
layui.use('layedit', function(){
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
                    layer.open({
                        title:'错误！'
                        ,content:'账户或密码错误!'
                    });
                }
            }
        })
    })
    var userTel;
    var code;
    $("#pGetCode").click(function () {
        userTel =$("#Tel").val();
        var flag = 0;
        var reg = /(1[3-9]\d{9}$)/;
        if (!userTel){
            layer.open({
                title:'错误！'
                ,content:'手机号不能为空'
            });
        }else if(!reg.test(userTel)){
            layer.open({
                title:'错误！'
                ,content:'不合法的手机号，请重新输入！'
            });
        }else{
            $.ajax({
                url :"/checkSamePhone",
                type:"post",
                dataType:"text",
                data:{'userTel':userTel},
                success:function (data) {
                    flag = data;
                    if (flag == 1){
                        $.ajax({
                            url :"/getSmsCode",
                            type:"post",
                            dataType:"text",
                            data:{'userTel':userTel},
                            success:function (data) {
                                alert("已发送验证码至您的手机！")
                                layer.open({
                                    title:'提示！'
                                    ,content:'已发送验证码至您的手机！'
                                });
                                code = data;
                            }
                        })
                    }
                }
            })
        }

    })
    $("#pLogin").click(function () {
       var pCode =$("#code").val();
        if (pCode==code){
            $.ajax({
                url :"/phoneLogin",
                type:"post",
                dataType:"text",
                data:{'userTel':userTel},
                success:function (data) {
                    window.location.href = "/blogIndex.html";
                }
            })
        }else{
            layer.open({
                title:'错误！'
                ,content:'验证码输入错误！'
            });
        }
    })

})