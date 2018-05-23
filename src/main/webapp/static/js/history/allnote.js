$(function () {
    // 权限区分
    function allListener() {
        if(allNoteUrl){
            var _html = '';
            _html = '<span class="tit_choosen"><a href="javascript:;">所有评课</a></span>'
            $(".title").append(_html);
        }
    }
    allListener();

    //权限人员获取所有笔记
    $.ajax({
        url:"/history/history/allnote",type:"GET", dateType:"json",
        success:function (event) {
            var _html = "";
            for(var i=0;i<event.length;i++){
                _html += '<div class="record"><div class="topic">听课课题：<span>'+event[i].subject+'</span></div>';
                _html += '<div class="school"><span><img src="../../../static/images/personal/teach.png"></span><span>授课老师：'+event[i].teacherName+'</span></div>';
                _html += '<div class="school"><span><img src="../../../static/images/personal/listen.png"></span><span>听课老师：'+event[i].listenerName+'</span></div>';
                _html += '<div class="detail"><span>查看详情</span><span><img src="../../../static/images/history/more.png"></span></div></div>';
                $(".content").append(_html);
                _html = "";
            }
        }
    });

})