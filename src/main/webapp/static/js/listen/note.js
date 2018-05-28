var picturePath;
$(function () {
    initUtils();
    var grade_val;
    var grade = [["一年级","二年级","三年级","四年级","五年级","六年级"],["初一","初二","初三"],["高一","高二","高三"]];

    //获取乡镇下拉数据
    $("#school").click(function(){
        $.ajax({
            url:path + "/paramters/STREET",
            type:"GET",
            dataType:"json",
            success:function (event) {
                var _html = "";
                for(var i=0;i<event.length;i++){
                    _html += '<div class="choose_01" value="'+event[i].id+'">'+event[i].paramName+'</div>';
                }
                var flag = popup({
                    'html': '<div class="pop_01"><div class="pop_title clearfix"><div class="sure_01"></div><div class="close_pop_01">取消</div></div><div class="show_pop">选择：</div><div class="pop_con">'+_html+'</div></div> </div>',
                    'width': '',
                    'height': '',
                    'params': {},
                    'events':{'close_pop_01':function(){popdown(flag);}}
                },false);
                linkage01(flag);
            }
        });
    })
    function linkage01(obj){
        $(".choose_01").click(function () {
            $(".show_pop").append('<span>'+$(this).text()+'></span>');
            var id_01 = $(this).attr("value");
            $.ajax({
                url:path + "/listen/getSchoolType/" + id_01,
                type:"GET",
                dataType:"json",
                success:function (event) {
                    var _html_01 = '';
                    for(var i=0;i<event.length;i++){
                        if(event[i].id == 1){
                            _html_01 += '<div class="choose_02" value="'+event[i].id+'">小学</div>';
                        }else if(event[i].id == 2){
                            _html_01 += '<div class="choose_02" value="'+event[i].id+'">初中</div>';
                        }else if(event[i].id == 3){
                            _html_01 += '<div class="choose_02" value="'+event[i].id+'">高中</div>';
                        }
                    }
                    $(".pop_con").html(_html_01);
                    linkage02(id_01,obj);
                }
            })
        })
    }
    function linkage02(id,obj){
        $(".choose_02").click(function () {
            grade_val = $(this).attr("value");
            $(".show_pop").append('<span>'+$(this).text()+'></span>');
            var id_02 = $(this).attr("value");
            var data = {streetId:id,schoolTypeId:id_02}, url = path + "/listen/getschoolname";
            $.ajax({
                url:url,type:"POST",contentType: "application/json",data:JSON.stringify(data),
                success:function (event) {
                    var _html_02 = '';
                    for(var i=0;i<event.length;i++){
                        _html_02 += '<div class="choose_03" value="'+event[i].id+'">'+event[i].schoolName+'</div>';
                    }
                    $(".pop_con").html(_html_02);
                    linkage03(obj);
                }
            })
        })
    }
    function linkage03(obj){
        $(".choose_03").click(function(){
            $(".show_pop").append('<span>'+$(this).text()+'</span>');
            $("#school").find(".text").text($(this).text());
            $("#school").find(".text").attr("value",$(this).attr("value"));
            $("#className .left").text("年级");
            $("#className .right input").val("");
            popdown(obj);
        })
    }

    // 年级班级
    $("#className .left").click(function(){
        var _html = "";
        for(var i=0;i<grade[grade_val-1].length;i++) {
            _html += '<div class="choose_04">'+grade[grade_val-1][i]+'</div>';
        }
        var flag = popup({
            'html': '<div class="pop_01"><div class="pop_title clearfix"><div class="sure_01"></div><div class="close_pop_01">取消</div></div><div class="pop_con">'+_html+'</div></div> </div>',
            'width': '',
            'height': '',
            'params': {},
            'events':{'close_pop_01':function(){popdown(flag);}}
        },false);
        linkage04(flag);
    })
    function linkage04(obj){
        $(".choose_04").click(function(){
            $("#className").find(".left").text($(this).text());
            popdown(obj);
        })
    }

    // 听课学课
    $.ajax({
        url:path + "/paramters/DISCIPLINE",
        type:"GET",
        dataType:"json",
        success:function (event) {
            $("#subject").click(function(){
                var _html = "";
                for(var i=0;i<event.length;i++){
                    _html += '<div class="choose_05" value="'+event[i].id+'">'+event[i].paramName+'</div>';
                }
                var flag = popup({
                    'html': '<div class="pop_01"><div class="pop_title clearfix"><div class="sure_01"></div><div class="close_pop_01">取消</div></div><div class="pop_con">'+_html+'</div></div> </div>',
                    'width': '',
                    'height': '',
                    'params': {},
                    'events':{'close_pop_01':function(){popdown(flag);}}
                },false);
                linkage05(flag);
            })
        }
    });
    function linkage05(obj){
        $(".choose_05").click(function(){
            $("#subject").find(".text").text($(this).text());
            $("#subject").find(".text").attr("value",$(this).attr("value"));
            popdown(obj);
        })
    }

    // 课堂评分
    $.ajax({
        url:path + "/paramters/SCORE",
        type:"GET",
        dataType:"json",
        success:function (event) {
            $("#score").click(function(){
                var _html = "";
                for(var i=0;i<event.length;i++){
                    _html += '<div class="choose_06" value="'+event[i].id+'">'+event[i].paramName+'</div>';
                }
                var flag = popup({
                    'html': '<div class="pop_01"><div class="pop_title clearfix"><div class="sure_01"></div><div class="close_pop_01">取消</div></div><div class="pop_con">'+_html+'</div></div> </div>',
                    'width': '',
                    'height': '',
                    'params': {},
                    'events':{'close_pop_01':function(){popdown(flag);}}
                },false);
                linkage06(flag);
            })
        }
    });
    function linkage06(obj){
        $(".choose_06").click(function(){
            $("#score").find(".text").text($(this).text());
            $("#score").find(".text").attr("value",$(this).attr("value"));
            popdown(obj);
        })
    }

    // 提交表单
    $(".submit").click(function () {
        var schoolId = $("#school").find(".text").attr("value");
        var className = $("#className").find(".left").text()+$("#className").find("input").val()+"班";
        var disciplineId = $("#subject").find(".text").attr("value");
        var subject = $("#topic").val();
        var teacherName = $("#teacherName").val();
        var comments = $("#comments").val();
        var scoreId = $("#score").find(".text").attr("value");
        var shareFlag;
        if($(".content_03").find("span").hasClass("choosen")){
            shareFlag = 1;
        }else{
            shareFlag = 0;
        }
        var listenPath = $(".town").text();

        if(schoolId&&className&&disciplineId&&subject&&teacherName&&comments&&scoreId&&listenPath){
            $.ajax({
                url: path + "/listen/picturecomment",
                type: 'POST',
                cache: false,
                data: new FormData($("#pictureForm")[0]),
                processData: false,
                contentType: false,
                async: false,
                success: function (result) {
                    picturePath = result;
                    console.log(picturePath);
                },
                error: function (err) {
                }
            });
            if(picturePath!=""){
                var data = {picturePath:picturePath,schoolId:schoolId,className:className,teacherName:teacherName,
                        disciplineId:disciplineId,subject:subject,comments:comments,scoreId:scoreId,listenPath:listenPath,shareFlag:shareFlag},
                    url = path + "/listen/notecomment";

                console.log(data);
                $.ajax({
                    url:url,type:"POST",contentType:"application/json",data:JSON.stringify(data),
                    success:function (r) {
                        var flag = popup({
                            'html': '<div class="new_pop"><div class="success_img"><img src="'+path+'/static/images/listen/success.png"></div><div class="success_font">评论提交成功</div><div class="sure">确定</div></div></div>',
                            'width': '70%',
                            'height': '200px',
                            'params': {},
                            'events':{'sure': function(){
                                popdown(flag);
                                    location.href = path +"/history/history";
                                }
                            }
                        },false);
                    }
                })
            }else{
                // 未上传图片
                var flag = popup({
                    'html': '<div class="new_pop"><div class="success_img"><img src="'+path+'/static/images/listen/fail.png"></div><div class="success_font" style="color: #DB2E21;">未上传随堂照片</div><div class="sure" style="background: #DB2E21;">确定</div></div></div>',
                    'width': '70%',
                    'height': '200px',
                    'params': {},
                    'events':{'sure': function(){
                            popdown(flag);
                        }
                    }
                },false);
            }
        }else{
            // 信息未填写完整
            var flag = popup({
                'html': '<div class="new_pop"><div class="success_img"><img src="'+path+'/static/images/listen/fail.png"></div><div class="success_font" style="color: #DB2E21;">请完善提交信息</div><div class="sure" style="background: #DB2E21;">确定</div></div></div>',
                'width': '70%',
                'height': '200px',
                'params': {},
                'events':{'sure': function(){
                        popdown(flag);
                    }
                }
            },false);
        }
    })

});