(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return "";
    }
})(jQuery);
function getParameter(){
    var reg_int=/^[0-9]+$/;
    var key;
    var  xx = $.getUrlParam('userId') + $.getUrlParam('userName');
    if(reg_int.test(xx)){
        key = parseInt(xx);
    }else {
        key = xx;
    }
    return key;
}
function displaypage(len){
    if(len == 1){
        $(".blog").hide();
    }else {
        $(".blog").show();
    }
}
var userId = 0;
var vueblog = new Vue({
    el:"#vue_blog",
    data:{
        blogs:[],
        userinfo:{}
    }
});
var vueleftinfo = new Vue({
    el:"#vue_leftinfo",
    data:{
        blogCount:0,
        blogerCount:0,
        fansCount:0,
        username:"",
        pic:"",
    }
});
function init(){
    var userParameter = getParameter();
    var userField = jQuery.isNumeric(userParameter) ? "userId" : "userName";
    if(jQuery.isNumeric(userParameter)){
        $.ajax({
            url: "http://localhost:8080/selectUidUsafeUinfoBlog",
            type: "post",
            data: {"userId": userParameter},
            dataType: "json",
            success: function (data) {
                vueblog.usersafe = {
                    userId: data.userId,
                    userName: data.userName,
                    password: data.password,
                    userEmail: data.userEmail,
                    userTel: data.userTel,
                    userStatus: data.userStatus,
                    userMoney: data.userMoney,
                    userIntegral: data.userIntegral,
                    userRole: data.userRole,
                };

                vueleftinfo.username = data.userName;

                vueblog.userinfo = {
                    userId: data.userinfo.userId,
                    realName: data.userinfo.realName,
                    userSex: data.userinfo.userSex,
                    userBirthday: data.userinfo.userBirthday,
                    userPic: "",
                    userCreateTime: data.userinfo.userCreateTime,
                };
                if(data.userinfo.userPic == null){
                    vueblog.userinfo.userPic = "images/headpic.jpg";
                    vueleftinfo.pic = "images/headpic.jpg";
                }else {
                    vueblog.userinfo.userPic = "face/"+data.userinfo.userPic
                    vueleftinfo.pic = "face/"+data.userinfo.userPic;
                }
                vueleftinfo.blogCount = data.blogList.length;
                displaypage(vueleftinfo.blogCount);
                for (var i = 0; i < data.blogList.length; i++) {
                    vueblog.blogs.push({
                        blogId:data.blogList[i].blogId,
                        blogTitle: data.blogList[i].blogTitle,
                        blogCreateTime: data.blogList[i].blogCreateTime,
                        blogPubType: data.blogList[i].blogPubType,
                        blogReadNum: data.blogList[i].blogReadNum,
                        blogContent: data.blogList[i].blogContent,
                        blogAuthor:data.userName
                    })
                }
                $.ajax({
                    url: "http://localhost:8080/selectBlogerCount",
                    type: "get",
                    data: {"fansId": data.userId},
                    dataType: "json",
                    success: function (data) {
                        vueleftinfo.blogerCount = data;
                    }
                });
                $.ajax({
                    url: "http://localhost:8080/selectFansCount",
                    type: "get",
                    data: {"blogerId": data.userId},
                    dataType: "json",
                    success: function (data) {
                        vueleftinfo.fansCount = data;
                    }
                })
            }
        })
    }else {
        $.ajax({
            url: "http://localhost:8080/selectUnameUsafeUinfoBlog",
            type: "post",
            data: {"userName": userParameter},
            dataType: "json",
            success: function (data) {
                vueblog.usersafe = {
                    userId: data.userId,
                    userName: data.userName,
                    password: data.password,
                    userEmail: data.userEmail,
                    userTel: data.userTel,
                    userStatus: data.userStatus,
                    userMoney: data.userMoney,
                    userIntegral: data.userIntegral,
                    userRole: data.userRole,
                };

                vueleftinfo.username = data.userName;

                vueblog.userinfo = {
                    userId: data.userinfo.userId,
                    realName: data.userinfo.realName,
                    userSex: data.userinfo.userSex,
                    userBirthday: data.userinfo.userBirthday,
                    userPic: "face/"+data.userinfo.userPic,
                    userCreateTime: data.userinfo.userCreateTime,
                };
                if(data.userinfo.userPic == null){
                    vueblog.userinfo.userPic = "images/headpic.jpg";
                    vueleftinfo.pic = "images/headpic.jpg";
                }else {
                    vueblog.userinfo.userPic = "face/"+data.userinfo.userPic
                    vueleftinfo.pic = "face/"+data.userinfo.userPic;
                }

                vueleftinfo.blogCount = data.blogList.length;
                displaypage(vueleftinfo.blogCount)

                for (var i = 0; i < data.blogList.length; i++) {
                    vueblog.blogs.push({
                        blogId:data.blogList[i].blogId,
                        blogTitle: data.blogList[i].blogTitle,
                        blogCreateTime: data.blogList[i].blogCreateTime,
                        blogPubType: data.blogList[i].blogPubType,
                        blogReadNum: data.blogList[i].blogReadNum,
                        blogContent: data.blogList[i].blogContent,
                        blogAuthor:data.userName
                    })
                }
                $.ajax({
                    url: "http://localhost:8080/selectBlogerCount",
                    type: "get",
                    data: {"fansId": data.userId},
                    dataType: "json",
                    success: function (data) {
                        vueleftinfo.blogerCount = data;
                    }
                });
                $.ajax({
                    url: "http://localhost:8080/selectFansCount",
                    type: "get",
                    data: {"blogerId": data.userId},
                    dataType: "json",
                    success: function (data) {
                        vueleftinfo.fansCount = data;
                    }
                })
            }
        })
    }
}
$(function () {
    $("#vue_blog").on("click",".ajax_userName",function () {
        var userName = $(this).text();
        var url1 = "http://localhost:8080/userBlogIndex.html?userName="+userName;
        window.location.replace(url1);
    });
    init();
    // $("#vue_blog").on("click",".blogtitle",function () {
    //     var blogId = $(this).children().text();
    //     var url1 = "http://localhost:8080/blogDetail.html?blogId="+ blogId;
    //     window.location.replace(url1);
    // });
    $.ajax({
        url: "/getUserInfo",
        dataType: "json",
        success: function (data) {
            $(".userpic img").attr("src", "face/" + data.userPic);
            $(".loginheadpic img").attr("src", "face/" + data.userPic);
        }
    });
})