$(function () {
    initUtils();
    // 日期格式转换
    function timestampToTime(timestamp) {
        var date = new Date(timestamp);
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate() + ' ';
        h = date.getHours() + ':';
        m = date.getMinutes() + ':';
        s = date.getSeconds();
        return Y+M+D+h+m+s;
    }

    //获取公告消息
    $.ajax({
        url:path + "/user/personal/message",type:"GET", dateType:"json",
        success:function (event) {
            $("#notice").text(event[0].title);
            // 最新公告
            $("#notice").click(function(){
                var flag = popup({
                    'html': '<div class="new_pop01"><div class="pop01_title">'+event[0].title+'</div><div class="pop02_con">'+event[0].message+'</div><div class="pop01_close">我知道了</div></div>',
                    'width': '70%',
                    'height': '',
                    'params': {},
                    'events':{'pop01_close':function(){popdown(flag);}
                    }
                },false);
            })
        }
    });

    //获取分享的记录
    $.ajax({
        url:path + "/history/history/sharenote",type:"GET", dateType:"json",
        success:function (event) {
            var _html = "";
            for(var i=0;i<2;i++){
                _html += '<div class="record"><div class="topic">听课课题：<span>'+event[i].subject+'</span></div>';
                _html += '<div class="school"><span><img src="'+path+'/static/images/personal/teach.png"></span><span>授课老师：'+event[i].teacherName+'</span></div>';
                _html += '<div class="school"><span><img src="'+path+'/static/images/personal/listen.png"></span><span>听课老师：'+event[i].listenerName+'</span></div>';
                _html += '<div class="detail"><span>查看详情</span><span><img src="'+path+'/static/images/history/more.png"></span></div></div>';
                $(".content_02").append(_html);
                _html = "";
            }
            for (var i=0;i<2;i++){
                !(function(i){
                    $(".detail")[i].onclick = function(){
                        var _html = '<div class="new_pop01"><div class="pop01_title">评课详情</div><div class="pop01_con">';
                        _html += '<div class="mess"><div>听课学校：</div><div>'+event[i].schoolName+'</div></div>';
                        _html += '<div class="mess"><div>班级年级：</div><div>'+event[i].className+'</div></div>';
                        _html += '<div class="mess"><div>听课学科：</div><div>'+event[i].disciplineName+'</div></div>';
                        _html += '<div class="mess"><div>听课课题：</div><div>'+event[i].subject+'</div></div>';
                        _html += '<div class="mess"><div>执教老师：</div><div>'+event[i].teacherName+'</div></div>';
                        _html += '<div class="mess"><div>听课老师：</div><div>'+event[i].listenerName+'</div></div>';
                        _html += '<div class="mess"><div>课堂评分：</div><div>'+event[i].scoreName+'</div></div>';
                        _html += '<div class="mess"><div>课堂评价：</div><div>'+event[i].comments+'</div></div>';
                        _html += '<div class="mess"><div>听课位置：</div><div>'+event[i].listenPath+'</div></div>';
                        _html += '<div class="mess"><div>提交时间：</div><div>'+timestampToTime(event[i].createDate)+'</div></div>';
                        _html += '<div class="mess"><div>课堂照片：</div></div>';
                        _html += '<div class="mess_pic"><div></div></div>';
                        _html += '</div><div class="pop01_close">我知道了</div></div>';
                        var flag = popup({
                            'html': _html,
                            'width': '80%',
                            'height': '',
                            'params': {},
                            'events':{'pop01_close':function(){popdown(flag);}
                            }
                        },false);
                    }
                })(i)
            }
        }
    });


});