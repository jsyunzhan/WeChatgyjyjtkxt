$(function(){
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

    // 提交表单
    $(".submit").click(function () {

        // openLoading();
    //     var checkTitle = $("#checkTitle").val();
    //     var checkContent = $("#checkContent").val();
    //     var imgEmpty = $(".addImage input").val();
    //     if(checkTitle&&checkContent){
    //         if(imgEmpty!=""){
    //
    //         }else{
    //             closeLoading();
    //             // 未上传图片
    //             var flag = popup({
    //                 'html': '<div class="new_pop"><div class="success_img"><img src="'+path+'/static/images/listen/fail.png"></div><div class="success_font" style="color: #DB2E21;">未上传随堂照片</div><div class="sure" style="background: #DB2E21;">确定</div></div></div>',
    //                 'width': '70%',
    //                 'height': '200px',
    //                 'params': {},
    //                 'events':{'sure': function(){
    //                         popdown(flag);
    //                     }
    //                 }
    //             },false);
    //         }
    //     }else{
    //         closeLoading();
    //         // 信息未填写完整
    //         var flag = popup({
    //             'html': '<div class="new_pop"><div class="success_img"><img src="'+path+'/static/images/listen/fail.png"></div><div class="success_font" style="color: #DB2E21;">请完善提交信息</div><div class="sure" style="background: #DB2E21;">确定</div></div></div>',
    //             'width': '70%',
    //             'height': '200px',
    //             'params': {},
    //             'events':{'sure': function(){
    //                     popdown(flag);
    //                 }
    //             }
    //         },false);
    //     }
    // })
        $.ajax({
            url: path + "/organ/picturecomment",
            type: 'POST',
            cache: false,
            data: new FormData($("#pictureForm")[0]),
            processData: false,
            contentType: false,
            async: true,
            success: function (picturePath) {

            },
            error: function (err) {
            }
        });
    });
});