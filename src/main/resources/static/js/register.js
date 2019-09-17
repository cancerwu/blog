
$(function () {
    var phoneFlag = 0;
    var nameFlag = 0;
    var registerFlag = 0;
    var agreeFlag = 0;
    $("button[name='next']").click(function() {
        if (phoneFlag == 1) {
            $(".main").css("display", "none");
            $(".main2").css("display", "block");
            $(".pro-step .step-index").css("background-color", "white");
            $(".pro-step .step-index").css("color", "#999");
            $(".pro-step .step-desc").css("color", "#999");
            $(".pro-step2 .step-index").css("background-color", "#00db00");
            $(".pro-step2 .step-index").css("color", "white");
            $(".pro-step2 .step-desc").css("color", "#00db00");
        } else {
            alert("请先通过手机号验证！");
        }
    });

    $("button[name='checkphone']").click(function () {
        $("button[name='checkphone']").css("outline","none");
        var phoneReg = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        if ((!phoneReg.test($("input[name='tel']").val())) || $("input[name='tel']").val().length != 11){
            alert("手机号不符合要求");
            // $("button[name='checkphone']").css("outline","none");
            $("button[name='checkphone']").css("border-color","red");
            phoneFlag = 0;
        }else{
            $.ajax({
                url:"/checkSamePhone",
                dataType:"text",
                type:"post",
                // async:false,
                // contentType:"application/json;charset-UTF-8",
                data:{"userTel":$("input[name='tel']").val(),},
                success:function (data) {
                    if(data>=1 ){
                        alert("该手机号已被注册");
                        phoneFlag = 0;
                        $("button[name='checkphone']").css("border-color","red");
                    }
                    else{
                        alert("手机号验证成功！");
                        phoneFlag = 1;
                        $("button[name='checkphone']").css("border-color","green");
                    }
                }
            })
        }
    });

    $("#userregister").validate({
        errorPlacement: 'span',
        errorPlacement: function(error, element){
            error.appendTo(element.parent());
            error.addClass("errormsg");
        },
        rules: {
            tel:{
                required: true,
            },
            name:{
                required: true,
                checkName: true,
                checkSameName: true,
            },
            password:{
                required: true,
            },
            secpassword:{
                required: true,
                equalTo: "#userpassword"
            },
            email:{
                required: true,
                checkEmail: true,
            },
            agree:{
                required: true,
            }
        },
        messages: {
            tel: {
                required: "请输入手机号",
            },
            name:{
                required: "请输入用户名",
                checkName: "用户名格式错误",
                checkSameName: "该用户名已被注册"
            },
            password:{
                required: "请输入密码",
            },
            secpassword:{
                required: "请确认密码",
                equalTo: "两次输入的密码不相同，请重新输入"
            },
            email:{
                required: "请输入邮箱",
                checkEmail: "邮箱格式错误",
            },
            agree:{
                checkAgree: "",
            }
        },

        submitHandler:function(form){
            $.ajax({
                url:"/insertUser",
                type:"post",
                datatype:"text",
                data:{
                    "userName":$("input[name='name']").val(),
                    "userTel":$("input[name='tel']").val(),
                    "userPassword":$("input[name='password']").val(),
                    "userEmail":$("input[name='email']").val()
                },
                success:function () {

                    alert("注册成功！");
                    $(".main2").css("display","none");
                    $(".main3").css("display","block");
                    $(".pro-step2 .step-index").css("background-color","white");
                    $(".pro-step2 .step-index").css("color","#999");
                    $(".pro-step2 .step-desc").css("color","#999");
                    $(".pro-step3 .step-index").css("background-color","#00db00");
                    $(".pro-step3 .step-index").css("color","white");
                    $(".pro-step3 .step-desc").css("color","#00db00");
                },
                err:function () {
                    registerFlag = 0;
                }
            })
        },
    });

    $("input[name='register']").click(function(){
        if($("input[name='agree']").is(':checked')){
            agreeFlag = 1;
        }else{
            alert("请阅读并同意注册协议！");
        }
    })

    // $.validator.addMethod("checkAgree",function(value,element){
    //     if($("input[name='agree']").is(':checked')){
    //         agreeFlag = 1;
    //         return true;
    //     } else {
    //         agreeFlag = 0;
    //         return false;
    //     }
    // });

    $.validator.addMethod("checkEmail",function(value,element){
        var checkName = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        var flag = this.optional(element)||(checkName.test(value));
        return flag;
    });

    $.validator.addMethod("checkSameName",function(value,element){
        if (nameFlag == 1){
            return true;
        } else {
            return false;
        }
    });

    $.validator.addMethod("checkName",function(value,element){
        var nameReg = /^[a-zA-z]\w{3,15}$/;
        var flag = this.optional(element)||(nameReg.test(value));
        return flag;
    });

    $("input[name='name']").bind('input propertychange',function (){
        $.ajax({
            url:"/checkSameName",
            dataType:"text",
            type:"post",
            data:{"userName":$("input[name='name']").val()},
            success:function (data) {
                var temp=data;
                if(temp>=1){
                    nameFlag = 0;
                }else {
                    nameFlag = 1;
                }
            }
        })
    });

    $("input[type='text']").click(function () {
        var patt = new Array();
        patt[0]="建议使用常用手机号";
        patt[1]="请输入您的用户名";
        patt[2]="请输入您的密码";
        patt[3]="请确认您的密码"
        patt[4]="请输入您的邮箱";
        patt[5]="请输入短信验证码";
        for (var i = 0; i <patt.length ; i++){
            if($(this).val()==patt[i]){
                $(this).val("");
                break;
            }
        }
    });
})