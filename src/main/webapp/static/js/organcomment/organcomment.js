$(function(){
    initUtils();
    var loading = (new Loading()).init(path+"/static/images/history/loading.gif","100px","100px");
    $(".addImage input").change(function () {
        var This = $(this);
        var fil = this.files;
        for (var i = 0; i < fil.length; i++) {
            reads(fil[i],This);
        }
    });
    function reads(fil,obj) {
        var reader = new FileReader();
        reader.readAsDataURL(fil);
        reader.onload = function () {
            obj.hide();
            obj.parent(".addImage").append('<img src="'+ reader.result + '"><div class="imgclose"><img src="'+path+'/static/images/listen/imgClose.png"></div>');
            $(".imgclose").click(function () {
                $(this).siblings("img").remove();
                $(this).siblings("input").show();
                $(this).siblings("input").val("");
                $(this).remove();
            })
        };
    }

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
            popdown(obj);
        })
    }

    // 提交表单
    $(".submit").click(function () {
        openLoading();
        var checkTitle = $("#checkTitle").val();
        var checkContent = $("#checkContent").val();
        var imgEmpty = $(".addImage input").val();
        if(checkTitle&&checkContent){
            if(imgEmpty!=""){
                $.ajax({
                    url: path + "organ/commentpage/add",
                    type: 'POST',
                    cache: false,
                    data: new FormData($("#pictureForm")[0]),
                    processData: false,
                    contentType: false,
                    async: true,
                    success: function (picturePath) {
                        var data = {picturePath:picturePath,checkTitle:checkTitle,checkContent:checkContent},
                            url = path + "/listen/notecomment";
                        console.log(data);
                        $.ajax({
                            url:url,type:"POST",contentType:"application/json",data:JSON.stringify(data),
                            success:function (r) {
                                console.log(2);
                                closeLoading();
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
                    },
                    error: function (err) {
                    }
                });
            }else{
                closeLoading();
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
            closeLoading();
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

})