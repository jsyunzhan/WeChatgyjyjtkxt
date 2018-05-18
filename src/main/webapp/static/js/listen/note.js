$(function () {
    $.ajax({
        url:"/paramters/STREET",
        type:"GET",
        dataType:"json",
        success:function (event) {
            for(var i in event){
                var _html = '<option value="'+event[i].id+'">'+event[i].paramName+'</option>';
                $("#town").append(_html);
            }

        }
    })

    $("#town").change(function () {
        $(this).val();
        $.ajax({

        })
    })
});