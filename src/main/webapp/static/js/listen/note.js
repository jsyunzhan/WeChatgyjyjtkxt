$(function () {
    //获取乡镇下拉数据
    $.ajax({
        url:"/paramters/STREET",
        type:"GET",
        dataType:"json",
        success:function (event) {
            $("#town").html("");
            $("#town").append('<option>请选择</option>');
            for(var i in event){
                var _html = '<option value="'+event[i].id+'">'+event[i].paramName+'</option>';
                $("#town").append(_html);
            }
        }
    });

    //获取学科下拉框数据
    $.ajax({
        url:"/paramters/DISCIPLINE",
        type:"GET",
        dataType:"json",
        success:function (event) {
            console.log(event)
        }
    });

    //获取课堂评分下拉框数据
    $.ajax({
        url:"/paramters/SCORE",
        type:"GET",
        dataType:"json",
        success:function (event) {
            console.log(event)
        }
    });

    var streetId;
    $("#town").change(function(){
        $("#school_lx").html('<option>请选择</option>');
        $("#school").html('<option>请选择</option>');
        $("#school_lx").siblings(".text").text("");
        $("#school").siblings(".text").text("");
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
        $("#school").html('<option>请选择</option>');
        $("#school").siblings(".text").text("");
        $(this).siblings(".text").text($("#school option:selected").text());
        var id = $(this).val();
        var data = {streetId:streetId,schoolTypeId:id},
        url = "/listen/getschoolname";
        $(this).siblings(".text").text($("#school_lx option:selected").text());
        if(id!="请选择"){
            $.ajax({
                url:url,type:"POST",contentType: "application/json",data:JSON.stringify(data),
                success:function (event) {
                    console.log(event);
                    for(var i in event){
                        var _html = '<option value="'+event[i].schoolName+'">'+event[i].schoolName+'</option>';
                        $("#school").append(_html);
                    }
                }
            })
        }
    })

    $("#school").change(function () {
        $(this).siblings(".text").text($("#school option:selected").text());
    })


});