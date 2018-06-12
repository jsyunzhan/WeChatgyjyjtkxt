$(function () {
    bottomFloor();
    initUtils();
    var loading = (new Loading()).init(path+"/static/images/history/loading.gif","100px","100px");

   $.ajax({
       url:path + "/organ/historypage/history",type:"GET",dataType:"json",
       success:function (event) {
           var _html = "";
           for(var i=0;i<event.length;i++) {
               _html += '<div class="record"><div class="topic">学校名称：<span>' + event[i].schoolName + '</span></div>';
               _html += '<div class="school clearfix"><p><span><img src="' + path + '/static/images/history/act.png"></span><span>活动小记：</span></p><p>' + event[i].checkContent + '</p></div>';
               _html += '<div class="detail"><span>查看详情</span><span><img src="' + path + '/static/images/history/more.png"></span></div>';
               _html += '<div class="modify"><span>修改</span></div></div>';
               $(".content").append(_html);
               _html = "";
               !(function(i){
                   $(".detail")[i].onclick = function(){
                       openLoading();
                       center(".usemask");
                       var data = {picturePath:event[i].picturePath};
                       var url = path + "/listen/getPictureByte";
                       var picImage;
                       $.ajax({
                           url:url,type:"POST",contentType: "application/json",data:JSON.stringify(data),async: true,
                           success:function (r) {
                               picImage = r;
                               var _html = '<div class="new_pop01"><div class="pop01_title">活动详情</div><div class="pop01_con" style="height:200px;">';
                               _html += '<div class="mess"><div>听课学校：</div><div>'+event[i].schoolName+'</div></div>';
                               _html += '<div class="mess"><div>活动小记：</div><div>'+event[i].checkContent+'</div></div>';
                               _html += '<div class="mess"><div>活动照片：</div></div><div class="picImage clearfix"> ';
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
                               bigImage(picImage);
                           }
                       });
                   }

                   $(".modify")[i].onclick = function(){
                       var _html = '<div class="new_pop01" id="'+event[i].id+'"><div class="pop01_title">修改</div><div class="pop02_con">';
                       _html += '<div class="mess"><div>活动小记：</div></div><div class="mess"><textarea name="comments" placeholder="请填写课堂评价" id="comments" style="height: 100px;">'+event[i].checkContent+'</textarea></div>';
                       _html += '</div><div class="closeBtn clearfix"><div class="sure_02">确定</div><div class="cancel">取消</div></div></div>';
                       var flag = popup({
                           'html': _html,
                           'width': '',
                           'height': '',
                           'params': {},
                           'events':{'cancel':function () {popdown(flag);},
                               'sure_02':function(){
                                   var comments = $("#comments").val();
                                   var id = $(".new_pop01").attr("id");
                                   if(comments!=""){
                                       var data = {id:id,checkContent:comments};
                                       $.ajax({
                                           url:path +'/organ/commentpage/edit',type:"POST",contentType: "application/json",data:JSON.stringify(data),
                                           success:function (r) {
                                               if (r){
                                                   popdown(flag);
                                                   var flag1 = popup({
                                                       'html': '<div class="new_pop"><div class="success_img"><img src="'+path+'/static/images/listen/success.png"></div><div class="success_font">修改成功</div><div class="sure">确定</div></div></div>',
                                                       'width': '70%',
                                                       'height': '200px',
                                                       'params': {},
                                                       'events':{'sure': function(){
                                                               popdown(flag1);
                                                               window.location.reload();
                                                           }
                                                       }
                                                   },false);
                                                   center(".new_pop");
                                               }
                                           }
                                       })
                                   }
                               }}
                       },false);
                       center(".new_pop01");
                   }
               })(i)
           }
       }
   })

    function bigImage(obj){
        var obj01 = obj;
        for (var i=0;i<$(".picImage div").length;i++){
            !(function(i) {
                $($(".picImage div")[i]).click(function() {
                    $(".bigImage").show();
                    $(".bigImage img").attr("src","data:image/gif;base64,"+obj01[i]);
                })
            })(i)
        }
        $(".bigImage img").click(function(){
            $(".bigImage").hide();
            $(".bigImage img").attr("src","");
        })
    }
});