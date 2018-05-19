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

    var streetId;
    $("#town").change(function(){
        $("#school_lx").html("");
        $("#school_lx").append('<option>请选择</option>');
        $("#school").html("");
        $("#school").append('<option>请选择</option>');
        $("#school_lx").siblings(".text").text("");
        var id = $(this).val();
        streetId = id;
        $(this).siblings(".text").text($("#town option:selected").text());
        if(id!="请选择"){
            $.ajax({
                url:"/listen/getSchoolType/" + id,
                type:"GET",
                dataType:"json",
                success:function (event) {
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
    });

    $("#school_lx").change(function () {
        $("#school").html("");
        $("#school").append('<option>请选择</option>');
        var id = $(this).val();
        var data = {streetId:streetId,schoolTypeId:id},
        url = "/listen/getschoolname";
        console.log(data);
        $(this).siblings(".text").text($("#school_lx option:selected").text());
        if(id!="请选择"){
            $.ajax({
                url:url,type:"POST",contentType: "application/json",data:JSON.stringify(data),
                success:function (r) {
                    console.log(r)
                }
            })
        }
    })
});