$(function () {
    $.ajax({
        url: "/selectCollectionBlog1",
        type: "post",
        dataType: "json",

        success: function (data) {


            // var $li2=(" <div class=\"idinfo1\">" +
            //     "<li>用户名：<span>"+data1+"</span></li>\n" +
            //     "                            <ul>\n" +
            //     "                                <li>粉丝数：<span>1</span></li>\n" +
            //     "                                <li>关注数：<span>1</span></li>\n" +
            //     "                            </ul>" +
            //     "</div>");
            // $("div[class='idinfo']").append($li2);
            for (var i = 0; i < data.length; i++) {
                var u="/deleteCollection1"+"?"+"collectionId="+data[i].userinfo.userId+"&"+"blogId"+"="+data[i].blogId;
                var $div1 = ("<div class=\"fansdateil\">\n" +
                    "<div class=\"fansimages\">\n" +
                    "<div class=\"fansimages1\">"+
                    "</div>\n" +
                    "</div>\n" +
                    "<div class=\"fansname\">\n" +
                    "<div class=\"fansname1\">"+
                    "<a href='#'>"+data[i].blogTitle+"</a>"+
                    "</div>\n" +
                    "</div>\n" +
                    "<div class=\"delfans\">\n"+
                    // "<input type=\"button\" value=\"取消关注\">\n"+
                    "<a href="+u+">"+"取消收藏"+"</a>"+
                    "</div>"+
                    "</div>")
                // var id=data[i].userId;
                // id = parseInt(id);
                //

                $("div[class='fansmain']").append($div1);
            }

        }
    })
}
)