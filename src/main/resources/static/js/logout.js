layui.use('layedit', function(){
    $("#logout").click(function () {
        layer.confirm('确定要退出登录吗？', {
            title: '提示',
            btn: ['确认', '取消'] //可以无限个按钮
            , btn2: function (index, layero) {
            }
        }, function (index, layero) {
            $.ajax({
                url: "/outline",
            });
            window.location.href = "/blogIndex.html";
        });
    });
});
