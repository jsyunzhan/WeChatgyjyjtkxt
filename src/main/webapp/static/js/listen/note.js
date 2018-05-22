$(function () {
    initUtils();
    var grade_val;
    var grade = [["一年级","二年级","三年级","四年级","五年级","六年级"],["初一","初二","初三"],["高一","高二","高三"]];

    //获取乡镇下拉数据
    $("#school").click(function(){
        $.ajax({
            url:"/paramters/STREET",
            type:"GET",
            dataType:"json",
            success:function (event) {
                var _html = "";
                for(var i=0;i<event.length;i++){
                    _html += '<div class="choose_01" value="'+event[i].id+'">'+event[i].paramName+'</div>';
                }
                var flag = popup({
                    'html': '<div class="pop_01"><div class="pop_title clearfix"><div class="close_pop_01">取消</div><div class="sure_01">确定</div></div><div class="show_pop">选择：</div><div class="pop_con">'+_html+'</div></div> </div>',
                    'width': '',
                    'height': '',
                    'params': {},
                    'events':{'close_pop_01':function(){popdown(flag);},'sure_01':function(){popdown(flag);}
                    }
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
                url:"/listen/getSchoolType/" + id_01,
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
            var data = {streetId:id,schoolTypeId:id_02}, url = "/listen/getschoolname";
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
            popdown(obj);
            $("#school").find(".text").text($(this).text());
            $("#school").find(".text").attr("value",$(this).attr("value"));
        })
    }

    // 年级班级
    $("#className .left").click(function(){
        var _html = "";
        for(var i=0;i<grade[grade_val-1].length;i++) {
            _html += '<div class="choose_04">'+grade[grade_val-1][i]+'</div>';
        }
        var flag = popup({
            'html': '<div class="pop_01"><div class="pop_title clearfix"><div class="close_pop_01">取消</div><div class="sure_01">确定</div></div><div class="pop_con">'+_html+'</div></div> </div>',
            'width': '',
            'height': '',
            'params': {},
            'events':{'close_pop_01':function(){popdown(flag);},'sure_01':function(){popdown(flag);}
            }
        },false);
        linkage04(flag);
    })
    function linkage04(obj){
        $(".choose_04").click(function(){
            popdown(obj);
            $("#className").find(".left").text($(this).text());
        })
    }

    // 听课学课
    $.ajax({
        url:"/paramters/DISCIPLINE",
        type:"GET",
        dataType:"json",
        success:function (event) {
            $("#subject").click(function(){
                var _html = "";
                for(var i=0;i<event.length;i++){
                    _html += '<div class="choose_05" value="'+event[i].id+'">'+event[i].paramName+'</div>';
                }
                var flag = popup({
                    'html': '<div class="pop_01"><div class="pop_title clearfix"><div class="close_pop_01">取消</div><div class="sure_01">确定</div></div><div class="pop_con">'+_html+'</div></div> </div>',
                    'width': '',
                    'height': '',
                    'params': {},
                    'events':{'close_pop_01':function(){popdown(flag);},'sure_01':function(){popdown(flag);}
                    }
                },false);
                linkage05(flag);
            })
        }
    });
    function linkage05(obj){
        $(".choose_05").click(function(){
            popdown(obj);
            $("#subject").find(".text").text($(this).text());
            $("#subject").find(".text").attr("value",$(this).attr("value"));
        })
    }

    // 课堂评分
    $.ajax({
        url:"/paramters/SCORE",
        type:"GET",
        dataType:"json",
        success:function (event) {
            $("#score").click(function(){
                var _html = "";
                for(var i=0;i<event.length;i++){
                    _html += '<div class="choose_06" value="'+event[i].id+'">'+event[i].paramName+'</div>';
                }
                var flag = popup({
                    'html': '<div class="pop_01"><div class="pop_title clearfix"><div class="close_pop_01">取消</div><div class="sure_01">确定</div></div><div class="pop_con">'+_html+'</div></div> </div>',
                    'width': '',
                    'height': '',
                    'params': {},
                    'events':{'close_pop_01':function(){popdown(flag);},'sure_01':function(){popdown(flag);}
                    }
                },false);
                linkage06(flag);
            })
        }
    });
    function linkage06(obj){
        $(".choose_06").click(function(){
            popdown(obj);
            $("#score").find(".text").text($(this).text());
            $("#score").find(".text").attr("value",$(this).attr("value"));
        })
    }

    // 提交表单
    $(".submit").click(function () {

        console.log(aa);
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
        if(schoolId&&className&&disciplineId&&subject&&teacherName&&comments&&scoreId&&shareFlag&&listenPath){
            var data = {schoolId:schoolId,className:className,teacherName:teacherName,
                    disciplineId:disciplineId,subject:subject,comments:comments,scoreId:scoreId,listenPath:listenPath,shareFlag:shareFlag},
                url = "/listen/notecomment";

            console.log(data);
            $.ajax({
                url:url,type:"POST",contentType:"application/json",data:JSON.stringify(data),
                success:function (r) {
                    var flag = popup({
                        'html': '<div class="new_pop"><div class="close_pop"><img src="../../static/images/listen/close.png"></div><div class="success_img"><img src="../../static/images/listen/success.png"></div><div class="success_font">评论提交成功</div><div class="sure">确定</div></div></div>',
                        'width': '70%',
                        'height': '200px',
                        'params': {},
                        'events':{'sure': function(){
                            popdown(flag);
                                location.href = "/history/history";
                            },
                            'close_pop':function(){popdown(flag);}
                        }
                    },false);
                }
            })
        }
    })

});