$(function () {

    //获取公告消息
    $.ajax({
        url:"/user/personal/message",type:"GET", dateType:"json",
        success:function (r) {

            //用r[0]获取第一个数组
            console.log(r[0]);
        }
    });

    //获取分享的记录
    $.ajax({
        url:"/history/history/sharenote",type:"GET", dateType:"json",
        success:function (r) {
            //用r[0]获取第一个数组
            //用r[1]获取第二个数组
            console.log(r[0]);
            console.log(r[1]);
        }
    });

});