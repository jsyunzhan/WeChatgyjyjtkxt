$(function () {
    initUtils();
    var loading = (new Loading()).init(path+"/static/images/history/loading.gif","100px","100px");
    // 权限区分
    function allListener() {
        if(allNoteUrl){
            var _html = '';
            _html = '<span><a href="'+path+allNoteUrl+'">所有评课</a></span>'
            $(".title").append(_html);
        }
    }
    allListener();

    //获取本人提交的记录
   $.ajax({
       url:path + "/history/history/ownnote",type:"GET", dateType:"json",
       success:function (event) {
           var _html = "";
           for(var i=0;i<event.length;i++){
               _html += '<div class="record"><div class="topic">听课课题：<span>'+event[i].subject+'</span></div>';
               _html += '<div class="school"><span><img src="'+path+'/static/images/history/position_1.png"></span><span>'+event[i].schoolName+'</span></div>';
               _html += '<div class="school"><span><img src="'+path+'/static/images/history/clock.png"></span><span>'+timestampToTime(event[i].createDate)+'</span></div>';
               _html += '<div class="detail"><span>查看详情</span><span><img src="'+path+'/static/images/history/more.png"></span></div></div>';
               $(".content").append(_html);
               _html = "";
               !(function(i){
                   $(".detail")[i].onclick = function(){
                       openLoading();
                       var data = {picturePath:event[i].picturePath};
                       var url = path + "/listen/getPictureByte";
                       var picImage;
                       $.ajax({
                           url:url,type:"POST",contentType: "application/json",data:JSON.stringify(data),async: true,
                           success:function (r) {
                               picImage = r;
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
                               _html += '<div class="mess"><div>课堂照片：</div></div><div class="picImage clearfix"> ';
                               for(var j=0;j<picImage.length;j++){
                                   _html += '<div style="background: url(data:image/gif;base64,'+picImage[j]+')no-repeat;background-size: 100% 100%"></div>';
                               }
                               _html += '</div><div class="mess_pic"><div></div></div>';
                               _html += '</div><div class="pop01_close">我知道了</div></div>';
                               closeLoading();
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
                       });
                   }
               })(i)
           }
       }
   });

    $(".month").click(function(){
        var _html = "";
        for(var i=1;i<=12;i++){
            _html += '<div class="choose_01">'+i+'月</div>';
        }
        var flag = popup({
            'html': '<div class="pop_01"><div class="pop_title clearfix"><div class="sure_01"></div><div class="close_pop_01">取消</div></div><div class="pop_con">'+_html+'</div></div> </div>',
            'width': '',
            'height': '',
            'params': {},
            'events':{'close_pop_01':function(){popdown(flag);}}
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