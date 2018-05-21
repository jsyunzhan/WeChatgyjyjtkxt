$(function () {
    $("#registerSub").click(function () {
        var listenerName = $("#listenerName").val();
        var listenerNumb = $("#listenerNumb").val();
        var data = {listenerName:listenerName,listenerNumb:listenerNumb},
            url = "/base/registerSub";

        $.ajax({
            url:url,type:"POST",contentType:"application/json",data:JSON.stringify(data),async:false,
            success:function (r) {
                if (r.success){
                    location.href = "/security/movetologin";
                }else {
                    $(".input_error").text("姓名身份证不匹配！");
                }
            },
            error:function (r) {
                $(".input_error").text("姓名身份证不匹配！");
            }
        })
    })

    $('input').bind('input propertychange', function() {
        $(".input_error").text("");
    });
});