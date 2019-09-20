$(function () {

    $.ajax({
        url: "/getUserInfo",
        dataType: "json",
        success: function (data) {
            $(".loginheadpic img").attr("src", "face/" + data.userPic);
        }
    });
    $.ajax({
        url: "/getMyFans",
        type: "post",
        dataType: "json",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var href = "/userBlogIndex.html?userId=" + data[i].userId;
                var $div1 = ("<div class=\"fansdateil\">\n" +
                    "<div class=\"fansname\">\n" +
                    "<a href=" + href + ">" + data[i].userName + "</a>" +
                    "</div>\n" +
                    "</div>")
                $("div[class='fansmain']").append($div1);
            }
        }
    });
})
