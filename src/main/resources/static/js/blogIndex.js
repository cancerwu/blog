layui.use('layedit', function(){
    var tagName;
    if (window.location.search == "") {
        tagName = "Java";
    } else {
        tagName = window.location.search.split("?")[1].split("=")[1];
    }
    $(".login").children().eq(2).css("display", "none")
    $(".login").children().eq(3).css("display", "none")

    $.ajax({
        url: "/getUserId",
        type: "post",
        dataType: "json",
        success: function (data1) {
            if (data1 > 0) {
                $(".login").children().eq(2).css("display", "block")
                $(".login").children().eq(3).css("display", "block")
                $(".login").children().eq(0).css("display", "none")
                $(".login").children().eq(1).css("display", "none")
            } else {
                $(".login").children().eq(2).css("display", "none")
                $(".login").children().eq(3).css("display", "none")
            }
        }
    });

    $("#logout").click(function () {
        layer.open({
            title:'提示',
            content: '退出登录！'
        });
        $.ajax({
            url: "/",
            dataType: "json",
            success: function (data) {

            }
        })
    })

    $.ajax({
        url: "/getUserInfo",
        dataType: "json",
        success: function (data) {
            $(".loginheadpic img").attr("src", "face/" + data.userPic);
        }
    });

    var vm = new Vue({
        el: ".vue",
        data: {
            blogs: []
        }
    });

    $.ajax({
        url: "/selectByBlogtagGetBlog",
        type: "post",
        dataType: "json",
        data: {"tagName": tagName},
        success: function (data) {
            var userName;
            for (var i = 0; i < data.length; i++) {

                $.ajax({
                    url: "/getUser",
                    data: {"userId": data[i].userId},
                    async: false,
                    success: function (dt) {
                        userName = dt.userName;
                    }
                });
                vm.blogs.push({
                    blogId: data[i].blogId,
                    userId: data[i].userId,
                    blogTitle: data[i].blogTitle,
                    blogCreateTime: data[i].blogCreateTime,
                    blogContent: data[i].blogContent,
                    blogReadNum: data[i].blogReadNum,
                    userPic: data[i].userinfo.userPic,
                    userName: userName,
                });
            }
        }
    });
    $("#searchtext").click(function () {
        var str = "搜索框"
        if ($(this).val() == str) {
            $(this).val("");
        }
    });


});

// 轮播图
//声明一个变量 记录当前的页码是多少
var page = 0;
//执行定时器，让图片根据页面进行改变
var allTab = document.getElementById('adpart1').getElementsByTagName('img');
var allLi = document.getElementsByClassName('tabLi');

var timer = setInterval(function () {
    page++;
    if (page >= allTab.length) {
        page = 0;
    }
    for (var i = 0; i < allTab.length; i++) {
        allTab[i].style.display = 'none';
        allLi[i].style.backgroundColor = '#7d7d7d';
    }
    allTab[page].style.display = 'block';
    allLi[page].style.backgroundColor = 'white';
}, 1500);

var oBanner = document.getElementById('ad');
var oTurn = document.getElementById('turn');

oBanner.onmouseover = function () {
    clearInterval(timer);
    oTurn.style.display = 'block';
};

oBanner.onmouseleave = function () {
    oTurn.style.display = 'none';
    timer = setInterval(function () {
        page++;
        if (page >= allTab.length) {
            page = 0;
        }
        change(page);
    }, 1500);
};


for (var i = 0; i < allLi.length; i++) {
    allLi[i].setAttribute('flag', i);
    allLi[i].onclick = function () {
        var flag = this.getAttribute('flag');
        change(flag);
        page = flag;
    }
}

var oRight = document.getElementById("rightTurn");

oRight.onclick = function () {
    page++;
    if (page >= allTab.length) {
        page = 0;
    }
    change(page);
};

var oLeft = document.getElementById("leftTurn");
oLeft.onclick = function () {
    page--;
    if (page < 0) {
        page = 4;
    }
    change(page);
};

function change(num) {
    for (var i = 0; i < allTab.length; i++) {
        allTab[i].style.display = 'none';
        allLi[i].style.backgroundColor = '#7d7d7d';
    }
    allTab[num].style.display = 'block';
    allLi[num].style.backgroundColor = 'white';
}