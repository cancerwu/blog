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
})