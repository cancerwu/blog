$(function () {
    $.ajax({
        url: "/getUserInfo",
        dataType: "json",
        success: function (data) {
            $(".loginheadpic img").attr("src", "face/" + data.userPic);
        }
    });
    $(".fwb").click(function () {
        layer.open({
            title: '提示'
            , content: 'success'
            , offset: '100px'
        });
        $(".manyinfo").css("display", "none")
        $(".writeblog").css("display", "block")
    })
})