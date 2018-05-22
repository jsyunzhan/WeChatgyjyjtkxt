$(function () {

    //是否有权限查看私有笔记,0为没有权限，1为有
    alert(permissionFlag);

    //获取本人提交的记录
   $.ajax({
       url:"/history/history/ownnote",type:"GET", dateType:"json",
       success:function (r) {
           console.log(r)
       }
   });

    //获取分享的记录
    $.ajax({
        url:"/history/history/sharenote",type:"GET", dateType:"json",
        success:function (r) {
            console.log(r)
        }
    });

    //权限人员获取所有笔记
    $.ajax({
        url:"/history/history/allnote",type:"GET", dateType:"json",
        success:function (r) {
            console.log(r)
        }
    })
});