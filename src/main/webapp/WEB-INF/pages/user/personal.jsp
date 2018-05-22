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
