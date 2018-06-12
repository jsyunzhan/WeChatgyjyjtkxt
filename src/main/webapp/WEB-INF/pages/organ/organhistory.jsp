<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/public.css">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/history.css">
    <script type="text/javascript" src="${APP_PATH}/static/jquery/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/public.js"></script>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.3&key=def2284f646e68d9760389eac586b046"></script>
    <script type="text/javascript" src="${APP_PATH}/static/jquery/pop.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/organ/organhistory.js"></script>
    <title>机关进校园</title>
</head>
<body>
<div class="wrapper">
    <div class="title">
        <span><a href="javascript:;">机关进校园</a></span>
    </div>
    <div class="search">
        <div class="month">
            <span>按时间查看</span>
            <span><img src="${APP_PATH}/static/images/history/down.png"></span>
        </div>
        <div class="font_search">
            <div>
                <input type="text" placeholder="搜索课题关键字查询">
            </div>
            <span>搜索</span>
        </div>
    </div>
    <div class="content">

    </div>
</div>
<div class="footer" id="footer">
    <a href="javascript:;">
        <span><img src="${APP_PATH}/static/images/listen/icon_05.png"></span>
        <span>听课评价</span>
        <div class="secondFloor none">
            <p onclick='window.location.href = "${APP_PATH}/listen/note"'>新建听课</p>
            <p onclick='window.location.href = "${APP_PATH}/history/history"'>历史评价</p>
        </div>
    </a>
    <a href="javascript:;">
        <span><img src="${APP_PATH}/static/images/listen/icon_02.png"></span>
        <span style="color: #FFCC00;">机关进校</span>
        <div class="secondFloor none">
            <p onclick='window.location.href = "${APP_PATH}/organ/commentpage"'>机关进校</p>
            <p onclick='window.location.href = "${APP_PATH}/organ/historypage"'>历史评价</p>
        </div>
    </a>
    <a href="javascript:;">
        <span><img src="${APP_PATH}/static/images/listen/icon_07.png"></span>
        <span>历史评价</span>
    </a>
    <a href="${APP_PATH}/user/personal">
        <span><img src="${APP_PATH}/static/images/listen/icon_08.png"></span>
        <span>用户中心</span>
    </a>
</div>
<div class="bigImage none">
    <img src="">
</div>
</body>
<script>
    var organFlag = "${organFlag}";
    var path  = '<%=request.getContextPath()%>';
</script>
</html>
