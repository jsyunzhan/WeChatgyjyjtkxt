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

// 居中效果
function center(obj){
    var win_width = $(window).width();
    var win_height = $(window).height();
    var obj_width = $(obj).width();
    var obj_height = $(obj).height();
    $(obj).css({"left":(win_width-obj_width)/2,"top":(win_height-obj_height)/2});
}

// 底部导航二级标题
function bottomFloor() {
    var footer = document.getElementById("footer");
    var footera = footer.getElementsByTagName("a");
    var wrapper = document.getElementsByClassName("wrapper")[0];
    for (var i=0;i<footera.length;i++){
        !(function (i){
            footera[i].onclick = function(ev){
                $(".secondFloor").hide();
                var secondFloor = this.getElementsByClassName("secondFloor")[0];
                secondFloor.style.display = "block";
                var ev = ev || window.event;
                ev.cancelBubble = true;
                wrapper.onclick = function(){
                    secondFloor.style.display = "none";
                }
            }
        })(i)
    }
    if(organFlag==0){
        $("#footer a:nth-child(2) .secondFloor p:nth-child(1)").hide();
    }else if(organFlag==1){
        $("#footer a:nth-child(2) .secondFloor p:nth-child(1)").show();
    }
}