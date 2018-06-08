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
function bottomFloor(){
    var secondNotes = document.getElementById("secondNotes");
    var wrapper = document.getElementsByClassName("wrapper")[0];
    secondNotes.onclick = function(){
        var ev = ev||window.event;
        ev.cancelBubble = true;
        $(".secondFloor").show();
        $(".secondFloor p:nth-child(1)").click(function(){
            window.location.href = path+"/listen/note";
        })
        $(".secondFloor p:nth-child(2)").click(function(){
            window.location.href = path+"/history/history";
        })
    }
    wrapper.onclick = function(){
        $(".secondFloor").hide();
    }
    document.onscroll = function (){
        $(".secondFloor").hide();
    }
}
