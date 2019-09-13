$(function () {

    $("#searchtext").click(function () {
        var str = "搜索框"
        if($(this).val() == str) {
            $(this).val("");
        }
    });

    $(".leftlabel").children().click(function () {
        alert("success")
        alert($(".leftlabel").children().eq(0).text())
    })


})