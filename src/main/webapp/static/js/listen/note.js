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
            $("#subject").html("");
            $("#subject").append('<option>请选择</option>');
            for(var i in event){
                var _html = '<option value="'+event[i].id+'">'+event[i].paramName+'</option>';
                $("#subject").append(_html);
            }
        }
    });

    //获取课堂评分下拉框数据
    $.ajax({
        url:"/paramters/SCORE",
        type:"GET",
        dataType:"json",
        success:function (event) {
            $("#score").html("");
            $("#score").append('<option>请选择</option>');
            for(var i in event){
                var _html = '<option value="'+event[i].id+'">'+event[i].paramName+'</option>';
                $("#score").append(_html);
            }
        }
    });

    // 所属乡镇
    var streetId;
    $("#town").change(function(){
        var id = $(this).val();
        if(id!="请选择"){
            streetId = id;
            $("#school_lx").html('<option>请选择</option>');
            $("#school_lx").siblings(".text").text("");
            $("#school").html('<option>请选择</option>');
            $("#school").siblings(".text").text("");
            $(this).siblings(".text").text($("#town option:selected").text());
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

    // 学校类型
    $("#school_lx").change(function () {
        var id = $(this).val();
        if(id!="请选择"){
            var data = {streetId:streetId,schoolTypeId:id}, url = "/listen/getschoolname";
            $("#school").html('<option>请选择</option>');
            $("#school").siblings(".text").text("");
            $(this).siblings(".text").text($("#school option:selected").text());
            $(this).siblings(".text").text($("#school_lx option:selected").text());
            $.ajax({
                url:url,type:"POST",contentType: "application/json",data:JSON.stringify(data),
                success:function (event) {
                    for(var i in event){
                        var _html = '<option value="'+event[i].id+'">'+event[i].schoolName+'</option>';
                        $("#school").append(_html);
                    }
                }
            })
        }
    })

    // 学校
    $("#school").change(function () {
        var id = $(this).val();
        if(id!="请选择") {
            $(this).siblings(".text").text($("#school option:selected").text());
        }
    })

    // 学科
    $("#subject").change(function () {
        var id = $(this).val();
        if(id!="请选择") {
            $(this).siblings(".text").text($("#subject option:selected").text());
        }
    })

    // 评分
    $("#score").change(function () {
        var id = $(this).val();
        if(id!="请选择") {
            $(this).siblings(".text").text($("#score option:selected").text());
        }
    })

    $(".submit").click(function () {
        var schoolId = $("#school").val();
        var className = $("#className").val();
        var teacherName = $("#teacherName").val();
        var disciplineId = $("#subject").val();
        var subject = $("#topic").val();
        var comments = $("#comments").val();
        var scoreId = $("#score").val();
        var shareFlag;
        if($(".content_03").find("span").hasClass("choosen")){
            shareFlag = 1;
        }else{
            shareFlag = 0;
        }
        var listenPath = $(".town").text();
        var data = {schoolId:schoolId,className:className,teacherName:teacherName,
                disciplineId:disciplineId,subject:subject,comments:comments,scoreId:scoreId,listenPath:listenPath,shareFlag:shareFlag},
        url = "/listen/notecomment";
        console.log(data);
        $.ajax({
            url:url,type:"POST",contentType:"application/json",data:JSON.stringify(data),
            success:function (r) {

            }
        })
    })

});