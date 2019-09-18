$(function () {
    $.ajax({
        url: "/getUserinfo1",
        type: "post",
        dataType: "json",
        success: function (data) {
            $.ajax({
                url: "/getLoginUserName",
                type: "post",
                dataType: "text",
                success: function (data1) {

                    $.ajax({
                        url: "/selectFansCount1",
                        type: "post",
                        dataType: "json",
                        success: function (data2) {
                            $.ajax({
                                url: "/selectBlogerCount1",
                                type: "post",
                                dataType: "json",
                                success: function (data3) {
                                    var $li2=(" <div class=\"idinfo1\">" +
                                        "<li>用户名：<span>"+data1+"</span></li>\n" +
                                        "                            <ul>\n" +
                                        "                                <li>粉丝数：<span>"+data2+"</span></li>\n" +
                                        "                                <li>关注数：<span>"+data3+"</span></li>\n" +
                                        "                            </ul>" +
                                        "</div>");
                                    var $li=("<div class=\"info\">"+
                                        "<li>真实姓名：<span>"+data.realName+"</span></li>"+
                                        "<li>性别：<span>"+data.userSex+"</span></li>"+
                                        "<li>生日：<span>"+data.userBirthday+"</span></li>"+
                                        "<li>职业：<span>学生</span></li>"+
                                        "<li>地区：<span>福建省 厦门市 集美区</span></li>"+
                                        "<li>简介：<span></span></li>"+
                                        "</div>");
                                    $("div[class='otherinfo']").append($li);
                                    $("div[class='idinfo']").append($li2);
                                }
                            })
                        }
                    })
                }
            })
        }
    });
    $(".updateinfo span").click(function () {
        $(".modifyinfo").show()
    })
    $(".backbutton").click(function () {
        $(".modifyinfo").hide()
    })
})