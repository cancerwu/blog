$(function () {


    $.ajax({
        url: "/getMyRelationUserinfo",
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
            $.ajax({
                url:"/getUserId",
                type: "post",
                dataType: "json",
                success: function (data1) {
                    // alert(data1);
                    var useronlineId = data1;
                    for (var i = 0; i < data.length; i++) {
                        // var u="/removeRelation"+"?"+"blogerId="+data1+"&"+"fansId"+"="+data[i].userId;
                        var $div1 = ("<div class=\"fansdateil\">\n" +
                            "<div class=\"fansimages\">\n" +
                            "<div class=\"fansimages1\">"+
                            "</div>\n" +
                            "</div>\n" +
                            "<div class=\"fansname\">\n" +
                            "<div class=\"fansname1\">"+
                            "<a href='#'>"+data[i].realName+"</a>"+
                            "</div>\n" +
                            "</div>\n" +
                            "<div class=\"delfans\">\n"+
                            "<input type=\"button\" value=\"取消关注\">\n"+
                            // "<a href="+u+">"+"取消关注"+"</a>"+
                            "</div>"+
                            "</div>")
                        var id=data[i].userId;
                        id = parseInt(id);
                        data1=parseInt(data1);

                        $("div[class='fansmain']").append($div1);

                            $("input[value='取消关注']").click(function () {
                                $.ajax({
                                    url :"/removeRelation",
                                    type:"post",
                                    dataType:"json",

                                    data:{"blogerId":data1,"fansId":id},

                                    success :function (data2) {

                                            location.href="viewfollow.html";


                                    }

                                })

                            })

                    }
                }
            });
        }
    });

})

