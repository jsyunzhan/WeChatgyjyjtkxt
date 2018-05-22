$(function () {

    


    $("#upladFile").click(function () {
        var fileObj = document.getElementById("file").files[0]; // js 获取文件对象
        // console.log(fileObj);
        // var file = new FormData();
        // file.append("file",file);
        console.log($("#file")[0]);
        console.log($("#upladForm")[0]);
        $.ajax({
            url: '/listen/picturecomment',
            type:'POST',
            cache: false,
            contentType: false,
            processData: false,
            data : new FormData(fileObj),
            success:function (data) {

            }
        });
    });
    
    
    //是否有权限查看私有笔记,0为没有权限，1为有
    // console.log(permissionFlag);

    //获取本人提交的记录
   $.ajax({
       url:"/history/history/ownnote",type:"GET", dateType:"json",
       success:function (r) {
           // console.log(r)
       }
   });

    //获取分享的记录
    $.ajax({
        url:"/history/history/sharenote",type:"GET", dateType:"json",
        success:function (r) {
            // console.log(r)
        }
    });

    //权限人员获取所有笔记
    $.ajax({
        url:"/history/history/allnote",type:"GET", dateType:"json",
        success:function (r) {
            // console.log(r)
        }
    })
});