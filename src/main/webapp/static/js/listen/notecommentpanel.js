$(function () {
    $.ajax({
        url:"/paramters/STREET",type:"GET",dataType:"json",
        success:function (r) {
            console.log(r)
        }
    })
});