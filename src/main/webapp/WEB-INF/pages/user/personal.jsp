<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/22
  Time: 10:44
  To change this template use File | Settings | File Templates.
  个人中心
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="../../../static/css/public.css">
    <link rel="stylesheet" type="text/css" href="../../../static/css/notes.css">
    <script type="text/javascript" src="../../../static/jquery/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.3&key=def2284f646e68d9760389eac586b046"></script>
    <script type="text/javascript" src="../../../static/jquery/pop.js"></script>
    <script type="text/javascript" src="../../../static/js/user/personal.js"></script>
</head>
<body>
    <%--微信头像--%>
    头像：<img style="height: 100px;width: 100px"  src="${imgUrl}">
    <br>
    <%--听课人员姓名--%>
    <a>听课人员姓名：${listenerName}</a> <br>
    <%--本月听课节数--%>
    <a>本月听课节数：${thisMonthCount}</a> <br>
    <%--累计听课节数--%>
    <a>累计听课节数：${allCount}</a> <br>
</body>
</html>
