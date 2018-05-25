<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="../../../static/css/public.css">
    <link rel="stylesheet" type="text/css" href="../../../static/css/personal.css">
    <script type="text/javascript" src="../../../static/jquery/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../../../static/js/public.js"></script>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.3&key=def2284f646e68d9760389eac586b046"></script>
    <script type="text/javascript" src="../../../static/jquery/pop.js"></script>
    <script type="text/javascript" src="../../../static/js/user/personal.js"></script>
</head>
<body>
    <div class="wrapper">
        <div class="banner">
            <img src="../../../static/images/personal/banner.png">
            <div class="personal">
                <div class="personal_photo">
                    <img src="${imgUrl}">
                </div>
                <div class="personal_name">ID:<span>${listenerName}</span></div>
            </div>
        </div>
        <div class="content_01">
            <div class="newest">
                <div>最新公告：</div>
                <div id="notice"></div>
            </div>
            <div class="listen_num clearfix">
                <div class="listened">
                    <div>
                        <img src="../../../static/images/personal/have.png">
                    </div>
                    <div>本月已听<span>${thisMonthCount}</span>节</div>
                </div>
                <div class="listened">
                    <div>
                        <img src="../../../static/images/personal/all.png">
                    </div>
                    <div>总计评课<span>${allCount}</span>节</div>
                </div>
            </div>
        </div>
        <div class="content_02">
            <div class="newest">
                <div>共享评课</div>
                <div class="more">
                    <a href="/history/share">
                    更多
                    <span><img src="../../../static/images/personal/more.png"></span>
                    </a>
                </div>
            </div>
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
        <a href="/history/history">
            <span><img src="../../../static/images/listen/icon_07.png"></span>
            <span>历史评价</span>
        </a>
        <a href="javascript:;">
            <span><img src="../../../static/images/listen/icon_04.png"></span>
            <span  style="color: #FFCC00;">用户中心</span>
        </a>
    </div>
</body>
</html>
