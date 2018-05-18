$(function(){

	// 图片上传
    function uploadImage(){
        $("#addImage").change(function(){
            var imageNum;
            imageNum = $(".fileImage").length;
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
            for(var i=0;i<4-imageNum;i++){
                if (this.files[i]){
                    //这里的objURL就是input file的真实路径
                    var objURL = getObjectURL(this.files[i]);
                    var imageHtml = '<div class="fileImage" style="background:url('+objURL+')no-repeat;background-size: 100% 100%;"><div class="imgclose"><img src="../../static/images/imgClose.png"></div></div>';
                    $(".upload").append(imageHtml);
                }
            }
            imageNum = $(".fileImage").length;
            if (imageNum == 4) {
                $(".imagesNum").text(imageNum);
                $(".addImage").hide();
            }else{
                $(".imagesNum").text(imageNum);
            }
            $(".imgclose").click(function(){
                $(this).parent(".fileImage").remove();
                imageNum = $(".fileImage").length;
                $(".imagesNum").text(imageNum);
                if (imageNum < 4){
                    $(".addImage").show();
                }
            })
        })
    }

    // 高德地图定位
    function map_position(){
        var mapObj = new AMap.Map('iCenter');
        mapObj.plugin('AMap.Geolocation', function () {
            geolocation = new AMap.Geolocation({
                enableHighAccuracy: true, // 是否使用高精度定位，默认:true
                timeout: 10000,           // 超过10秒后停止定位，默认：无穷大
                maximumAge: 0,            // 定位结果缓存0毫秒，默认：0
                convert: true,            // 自动偏移坐标，偏移后的坐标为高德坐标，默认：true
                showButton: true,         // 显示定位按钮，默认：true
                buttonPosition: 'LB',     // 定位按钮停靠位置，默认：'LB'，左下角
                buttonOffset: new AMap.Pixel(10, 20), // 定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                showMarker: true,         // 定位成功后在定位到的位置显示点标记，默认：true
                showCircle: true,         // 定位成功后用圆圈表示定位精度范围，默认：true
                panToLocation: true,      // 定位成功后将定位到的位置作为地图中心点，默认：true
                zoomToAccuracy:true       // 定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            });
            mapObj.addControl(geolocation);
            geolocation.getCurrentPosition();
            AMap.event.addListener(geolocation, 'complete', onComplete); // 返回定位信息
        });
        function onComplete(obj){
            var res = obj.formattedAddress;
            $(".town").text(res);
        }
    }

    // 公开评价
    $(".content_03").click(function(){
        $(this).find("span").toggleClass("choosen");
    })


    uploadImage();
    map_position();
})