$(function () {
    $.ajax({
        url: "/getUserInfo",
        dataType: "json",
        success: function (data) {
            $(".loginheadpic img").attr("src", "face/" + data.userPic);
        }
    });
    $.ajax({
        url: "/getMyRelationUserinfo",
        type: "post",
        dataType: "json",
        success: function (data) {
            $.ajax({
                url: "/getUserId",
                type: "post",
                dataType: "json",
                success: function (data1) {
                    var useronlineId = data1;

                    for (var i = 0; i < data.length; i++) {
                        var href = "/userBlogIndex.html?userId=" + data[i].userId;
                        var u = "removeRelation1" + "?" + "blogerId=" + data[i].userId + "&" + "fansId" + "=" + data1;
                        var $div1 = ("<div class=\"fansdateil\">\n" +
                            "<div class=\"fansimages\">\n" +
                            "<div class=\"fansimages1\">" +
                            "</div>\n" +
                            "</div>\n" +
                            "<div class=\"fansname\">\n" +
                            "<div class=\"fansname1\">" +
                            "<a href=" + href + ">" + data[i].userName + "</a>" +
                            "</div>\n" +
                            "</div>\n" +
                            "<div class=\"delfans\">\n" +
                            "<a href=" + u + ">" + "取消关注" + "</a>" +
                            "</div>" +
                            "</div>")
                        var id = data[i].userId;
                        id = parseInt(id);
                        data1 = parseInt(data1);
                        $("div[class='fansmain']").append($div1);
                    }
                }
            });
        }
    });

})

