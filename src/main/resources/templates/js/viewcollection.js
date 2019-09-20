$(function () {
        $.ajax({
            url: "/getUserInfo",
            dataType: "json",
            success: function (data) {
                $(".loginheadpic img").attr("src", "face/" + data.userPic);
            }
        });
        $.ajax({
            url: "/selectCollectionBlog1",
            type: "post",
            dataType: "json",

            success: function (data) {


                $.ajax({
                    url: "/getUserId",
                    type: "post",
                    dataType: "json",

                    success: function (data1) {
                        for (var i = 0; i < data.length; i++) {
                            var u = "/deleteCollection1" + "?" + "collectionId=" + data1+ "&" + "blogId" + "=" + data[i].blogId;
                            var $div1 = ("<div class=\"fansdateil\">\n" +
                                "<div class=\"fansimages\">\n" +
                                "<div class=\"fansimages1\">" +
                                "</div>\n" +
                                "</div>\n" +
                                "<div class=\"fansname\">\n" +
                                "<div class=\"fansname1\">" +
                                "<a href='#'>" + data[i].blogTitle + "</a>" +
                                "</div>\n" +
                                "</div>\n" +
                                "<div class=\"delfans\">\n" +
                                // "<input type=\"button\" value=\"取消关注\">\n"+
                                "<a href=" + u + ">" + "取消收藏" + "</a>" +
                                "</div>" +
                                "</div>")
                            // var id=data[i].userId;
                            // id = parseInt(id);
                            //

                            $("div[class='fansmain']").append($div1);
                        }
                    }
                })
            }
        })
}
)