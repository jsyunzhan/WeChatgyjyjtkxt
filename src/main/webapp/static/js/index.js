$(function(){

	// 图片上传

    	$("#addImage").change(function(){
            var imageOldNum = $(".fileImage").length;
    		function getObjectURL(file) {  
                var url = null;  
                if (window.createObjcectURL != undefined) {  
                    url = window.createOjcectURL(file);
                } else if (window.URL != undefined) {  
                    url = window.URL.createObjectURL(file);  
                } else if (window.webkitURL != undefined) {  
                    url = window.webkitURL.createObjectURL(file);  
                }  
                return url;
            }
            for(var i=0;i<4-imageOldNum;i++){
                if (this.files[i]){
                    //这里的objURL就是input file的真实路径
                    var objURL = getObjectURL(this.files[i]);
                    var imageHtml = '<div class="fileImage"><img src="'+objURL+'"></div>';
                    $(".upload").append(imageHtml);
                }
            }
            var imageNewNum = $(".fileImage").length;
            if (imageNewNum == 4) {
                $(".imagesNum").text(imageNewNum);
                $(".addImage").hide();
            }else{
                $(".imagesNum").text(imageNewNum);
            }
            
    	})

	var win_height = $(window).height();
	$(".wrapper").height(win_height-50);



	
})