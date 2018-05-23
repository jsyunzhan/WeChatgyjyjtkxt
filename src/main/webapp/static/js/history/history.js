$(function () {


    console.log(allNoteUrl);


    initUtils();

    // 权限区分
    function allListener() {
        var _html = "";
        if(permissionFlag == 0){
            _html += '<span class="tit_choosen">历史评课</span><span>共享评课</span>';
            $(".title").append(_html);
        }else if(permissionFlag == 1){
            _html += '<span class="tit_choosen">历史评课</span><span>共享评课</span><span>所有评课</span>';
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
       }
   });

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














    //获取分享的记录
    $.ajax({
        url:"/history/history/sharenote",type:"GET", dateType:"json",
        success:function (r) {
            console.log(r)
        }
    });

    //权限人员获取所有笔记
    $.ajax({
        url:"/history/history/allnote",type:"GET", dateType:"json",
        success:function (r) {
            console.log(r)
        }
    })
});