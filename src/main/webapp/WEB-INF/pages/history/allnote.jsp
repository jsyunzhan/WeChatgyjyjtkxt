<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有评课</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="../../../static/css/public.css">
    <link rel="stylesheet" type="text/css" href="../../../static/css/history.css">
    <script type="text/javascript" src="../../../static/jquery/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.3&key=def2284f646e68d9760389eac586b046"></script>
    <script type="text/javascript" src="../../../static/jquery/pop.js"></script>
    <script type="text/javascript" src="../../../static/js/history/allnote.js"></script>
</head>
<body>
<div class="wrapper">
    <div class="title">
        <span><a href="/history/history">我的评课</a></span>
        <span><a href="/history/share">共享评课</a></span>
    </div>
    <div class="content">

    </div>
</div>
<div class="footer">
    <a href="/listen/note">
        <span><img src="../../../static/images/listen/icon_05.png"></span>
        <span>听课评价</span>
    </a>
    <a href="javascript:;">
        <span><img src="../../../static/images/listen/icon_06.png"></span>
        <span>机关进校</span>
    </a>
    <a href="javascript:;">
        <span><img src="../../../static/images/listen/icon_03.png"></span>
        <span style="color: #FFCC00;">历史评价</span>
    </a>
    <a href="/user/personal">
        <span><img src="../../../static/images/listen/icon_08.png"></span>
        <span>用户中心</span>
    </a>
</div>
</body>
<script>
    var allNoteUrl = "${allNoteUrl}";
</script>
</html>
