<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>历史评课</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="../../../static/css/public.css">
    <link rel="stylesheet" type="text/css" href="../../../static/css/history.css">
    <script type="text/javascript" src="../../../static/jquery/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.3&key=def2284f646e68d9760389eac586b046"></script>
    <script type="text/javascript" src="../../../static/jquery/pop.js"></script>
    <script type="text/javascript" src="../../../static/js/history/history.js"></script>
</head>
<body>
    <div class="wrapper">
        <div class="title"></div>
        <div class="search">
            <div class="month">
                <span>按月查看</span>
                <span><img src="../../../static/images/history/down.png"></span>
            </div>
            <div class="font_search">
                <div>
                    <input type="text" placeholder="搜索关键字查询">
                </div>
                <span>搜索</span>
            </div>
        </div>
        <div class="content">

        </div>
    </div>
    <div class="footer">
        <div>
            <span><img src="../../../static/images/listen/icon_05.png"></span>
            <span>听课评价</span>
        </div>
        <div>
            <span><img src="../../../static/images/listen/icon_06.png"></span>
            <span>机关进校</span>
        </div>
        <div>
            <span><img src="../../../static/images/listen/icon_03.png"></span>
            <span style="color: #FFCC00;">历史评价</span>
        </div>
        <div>
            <span><img src="../../../static/images/listen/icon_08.png"></span>
            <span>用户中心</span>
        </div>
    </div>
历史记录

    <%--<form id="upladForm" method="post" action="/listen/picturecomment"  enctype="multipart/form-data">--%>
        <%--<input type="file"  name="singleFile1"  accept="image/*" multiple/>--%>
        <%--<input id="upladFile" type="submit" value="上传" />--%>
    <%--</form>--%>


</body>
    <script>
        var permissionFlag = "${permissionFlag}";

    </script>
</html>