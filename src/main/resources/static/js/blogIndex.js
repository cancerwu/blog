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

// 轮播图
//声明一个变量 记录当前的页码是多少
var page = 0;
//执行定时器，让图片根据页面进行改变
var allTab = document.getElementById('adpart1').getElementsByTagName('img');
var allLi = document.getElementsByClassName('tabLi');

var timer = setInterval(function(){
    page++;
    if (page>=allTab.length) {
        page=0;
    }
    for (var i = 0; i < allTab.length; i++) {
        allTab[i].style.display = 'none';
        allLi[i].style.backgroundColor= '#7d7d7d';
    }
        allTab[page].style.display = 'block';
        allLi[page].style.backgroundColor = 'white';
    },1500);

var oBanner = document.getElementById('ad');
var oTurn = document.getElementById('turn');

oBanner.onmouseover = function(){
    clearInterval(timer);
    oTurn.style.display = 'block';
}

oBanner.onmouseleave = function(){
    oTurn.style.display = 'none';
    timer = setInterval(function(){
    page++;
    if (page>=allTab.length) {
        page=0;
    }
    change(page);
    },1500);
}


for (var i = 0; i < allLi.length; i++) {
    allLi[i].setAttribute('flag',i);
    allLi[i].onclick = function(){
        var flag = this.getAttribute('flag');
        change(flag);
        page = flag;
    }
}

var oRight = document.getElementById("rightTurn");

oRight.onclick = function(){
    page++;
    if(page>=allTab.length){
        page=0;
    }
    change(page);
}

var oLeft = document.getElementById("leftTurn");
oLeft.onclick = function(){
    page--;
    if(page<0){
        page=4;
    }
    change(page);
}

function change(num){
    for (var i = 0; i < allTab.length; i++) {
        allTab[i].style.display = 'none';
        allLi[i].style.backgroundColor= '#7d7d7d';
    }
        allTab[num].style.display = 'block';
        allLi[num].style.backgroundColor = 'white';
}