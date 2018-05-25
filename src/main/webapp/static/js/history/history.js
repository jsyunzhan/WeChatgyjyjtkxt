$(function () {
    initUtils();

    // 居中效果
    function center(obj){
        var win_width = $(window).width();
        var win_height = $(window).height();
        var obj_width = $(obj).width();
        var obj_height = $(obj).height();
        $(obj).css({"left":(win_width-obj_width)/2,"top":(win_height-obj_height)/2});
    }

    // 权限区分
    function allListener() {
        if(allNoteUrl){
            var _html = '';
            _html = '<span><a href="'+allNoteUrl+'">所有评课</a></span>'
            $(".title").append(_html);
        }
    }
    allListener();

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

    //获取本人提交的记录
   $.ajax({
       url:"/history/history/ownnote",type:"GET", dateType:"json",
       success:function (event) {
           console.log(event);
           var _html = "";
           for(var i=0;i<event.length;i++){
               _html += '<div class="record"><div class="topic">听课课题：<span>'+event[i].subject+'</span></div>';
               _html += '<div class="school"><span><img src="../../../static/images/history/position_1.png"></span><span>'+event[i].schoolName+'</span></div>';
               _html += '<div class="school"><span><img src="../../../static/images/history/clock.png"></span><span>'+timestampToTime(event[i].createDate)+'</span></div>';
               _html += '<div class="detail"><span>查看详情</span><span><img src="../../../static/images/history/more.png"></span></div></div>';
               $(".content").append(_html);
               _html = "";
           }
           for (var i=0;i<event.length;i++){
               !(function(i){
                   $(".detail")[i].onclick = function(){
                       var _html = '<div class="new_pop01"><div class="pop01_title">评课详情</div><div class="pop01_con">';
                       _html += '<div class="mess"><div>听课学校：</div><div>'+event[i].schoolName+'</div></div>';
                       _html += '<div class="mess"><div>班级年级：</div><div>'+event[i].className+'</div></div>';
                       _html += '<div class="mess"><div>听课学科：</div><div>'+event[i].disciplineName+'</div></div>';
                       _html += '<div class="mess"><div>听课课题：</div><div>'+event[i].subject+'</div></div>';
                       _html += '<div class="mess"><div>执教老师：</div><div>'+event[i].teacherName+'</div></div>';
                       _html += '<div class="mess"><div>听课老师：</div><div>'+event[i].listenerName+'</div></div>';
                       _html += '<div class="mess"><div>课堂评分：</div><div>'+event[i].scoreId+'</div></div>';
                       _html += '<div class="mess"><div>课堂评价：</div><div>'+event[i].comments+'</div></div>';
                       _html += '<div class="mess"><div>听课位置：</div><div>'+event[i].listenPath+'</div></div>';
                       _html += '<div class="mess"><div>提交时间：</div><div>'+timestampToTime(event[i].createDate)+'</div></div>';
                       _html += '<div class="mess"><div>课堂照片：</div></div>';
                       _html += '<div class="mess_pic"><div></div></div>';
                       _html += '</div><div class="pop01_close">我知道了</div></div>';
                       var flag = popup({
                           'html': _html,
                           'width': '',
                           'height': '',
                           'params': {},
                           'events':{'pop01_close':function(){popdown(flag);}
                           }
                       },false);
                       center(".new_pop01");
                   }
               })(i)
           }
       }
   });
    function detail(){

    }

    $(".month").click(function(){
        var _html = "";
        for(var i=1;i<=12;i++){
            _html += '<div class="choose_01">'+i+'月</div>';
        }
        var flag = popup({
            'html': '<div class="pop_01"><div class="pop_title clearfix"><div class="close_pop_01">取消</div><div class="sure_01">确定</div></div><div class="pop_con">'+_html+'</div></div> </div>',
            'width': '',
            'height': '',
            'params': {},
            'events':{'close_pop_01':function(){popdown(flag);},'sure_01':function(){popdown(flag);}
            }
        },false);
        linkage(flag);
    })

    // 月份选择
    function linkage(obj){
        $(".choose_01").click(function () {
            $(".month span").eq(0).text($(this).text());
            popdown(obj);
        })
    }
});