$(function () {
    $.ajax({
        url: "/getUserInfo",
        dataType: "json",
        success: function (data) {
            $(".loginheadpic img").attr("src", "face/" + data.userPic);
        }
    });
    $(".fwb").click(function () {
        $(".manyinfo").css("display", "none")
        $(".writeblog").css("display", "block")

    })

    $.ajax({
        url: "http://localhost:8080/selectUidUsafeUinfoBlog",
        type: "post",
        data: {"userId": userParameter},
        dataType: "json",
        success: function (data1) {
            if (data1 > 0) {
                $.ajax({
                    url:"/searchUserBlogs",
                    dataType: "json",
                    success:function (data) {
                        for (var i = 0;i < data.length ; i++) {

                        }
                    }
                })
            } else {
            }
        }
    });

    $.ajax({
        url: "/getUserId",
        type: "post",
        dataType: "json",
        success: function (data1) {
            if (data1 > 0) {
                $.ajax({
                    url:"/searchUserBlogs",
                    dataType: "json",
                    success:function (data) {
                        for (var i = 0;i < data.length ; i++) {

                        }
                    }
                })
            } else {
            }
        }
    });


})