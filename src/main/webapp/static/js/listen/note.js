$(function () {
    $.ajax({
        url:"/paramters/STREET",
        type:"GET",
        dataType:"json",
        success:function (event) {
            $("#town").append('<option>请选择</option>');
            for(var i in event){
                var _html = '<option value="'+event[i].id+'">'+event[i].paramName+'</option>';
                $("#town").append(_html);
            }

        }
    });

    $("#town").change(function () {
        var id = $(this).val();
        if(id!="请选择"){
            $.ajax({
                url:"/listen/getSchoolType/" + id,
                type:"GET",
                dataType:"json",
                success:function (event) {
                    $("#school_lx").append('<option>请选择</option>');
                    for(var i in event){
                        if(event[i].id ==1){
                            var _html = '<option value="'+event[i].id+'">小学</option>';
                            $("#school_lx").append(_html);
                        }else if(event[i].id ==2){
                            var _html = '<option value="'+event[i].id+'">初中</option>';
                            $("#school_lx").append(_html);
                        }else if(event[i].id ==3){
                            var _html = '<option value="'+event[i].id+'">高中</option>';
                            $("#school_lx").append(_html);
                        }
                    }
                }
            })
        }
    })

    $("#school_lx").change(function () {
        var id = $(this).val();
        if(id!="请选择"){

        }
    })
});