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
        url:"/user/personal/message",type:"GET", dateType:"json",
        success:function (event) {
            $("#notice").text(event[0].title);
            // 最新公告
            $("#notice").click(function(){
                var flag = popup({
                    'html': '<div class="new_pop01"><div class="pop01_title">'+event[0].title+'</div><div class="pop01_con">'+event[0].message+'</div><div class="pop01_close">我知道了</div></div>',
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
        url:"/history/history/sharenote",type:"GET", dateType:"json",
        success:function (event) {
            var _html = "";
            for(var i=0;i<2;i++){
                _html += '<div class="record"><div class="topic">听课课题：<span>'+event[i].subject+'</span></div>';
                _html += '<div class="school"><span><img src="../../../static/images/personal/teach.png"></span><span>授课老师：'+event[i].teacherName+'</span></div>';
                _html += '<div class="school"><span><img src="../../../static/images/personal/listen.png"></span><span>听课老师：'+event[i].listenerName+'</span></div>';
                _html += '<div class="detail"><span>查看详情</span><span><img src="../../../static/images/history/more.png"></span></div></div>';
                $(".content_02").append(_html);
                _html = "";
            }
        }
    });


});