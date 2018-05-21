$(function () {
    $("#registerSub").click(function () {
        var listenerName = $("#listenerName").val();
        var listenerNumb = $("#listenerNumb").val();
        var data = {listenerName:listenerName,listenerNumb:listenerNumb},
            url = "/base/registerSub";

        $.ajax({
            url:url,type:"POST",contentType:"application/json",data:JSON.stringify(data),
            success:function (r) {
                if (r.success){
                    window.open("/security/movetologin");
                }
            }
        })
    })
});