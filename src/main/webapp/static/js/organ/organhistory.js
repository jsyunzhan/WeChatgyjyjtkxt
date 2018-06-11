$(function () {
   $.ajax({
       url:path + "/organ/historypage/history",type:"GET",dataType:"json",
       success:function (r) {
           console.log(r)
       }
   })
});