$(function () {


    $.ajax({
        url: "/getMyFans",
        type: "post",
        dataType: "json",
        success: function (data) {

            // $("div[id='order3']").append($div3);
            // var $div2 = ("   <div id=\"2\">\n" +
            //
            //     "                <div class=\"re_name\">" + data[0].receive_name + "</div>\n" +
            //     "                <div class=\"re_tel\">" + data[0].receive_tel + "</div>\n" +
            //     "                <div class=\"re_ad\">" + data[0].province + data[0].city + data[0].district + data[0].address_name + "</div>\n" +
            //
            //     "            </div>")
            for (var i = 0; i < data.length; i++) {
                var $div1 = ("<div class=\"fansdateil\">\n" +
                    "<div class=\"fansimages\">\n" +
                    "<div class=\"fansimages1\">"+
                    "</div>\n" +
                    "</div>\n" +
                    "<div class=\"fansname\">\n" +
                    "<div class=\"fansname1\">"+data[i].realName+"</div>\n" +
                    "</div>\n" +
                    "<div class=\"delfans\">\n"+
                    "<input type=\"button\" value=\"取消关注\">\n"+
                    "</div>"+
                    "</div>")
                $("div[class='fansmain']").append($div1);
            }
        }
    });
    $(function () {
        $("input[value='取消关注']").click(function () {
            $.ajax({
                url:"/getUserId",
                type: "post",
                dataType: "json",
                success: function (data1) {
                    alert(data1);
                    var useronlineId = data1;
                    $.ajax({
                        url: "/removeRelation",
                        type: "post",
                        data: {'blogerId': useronlineId, 'fansId': data[i].userId},
                        dataType: "json",
                        success: function (data) {
                            alert(data);
                            if (data) {
                                location.href = "viewfollow.html";
                            } else {
                                alert("取消关注失败");
                            }
                        }
                    })
                }
            });
        })
    })
})

