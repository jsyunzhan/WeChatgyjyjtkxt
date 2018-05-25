<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>高邮市机关进校园系统</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-wdith,initial-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/public.css">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/register.css">
    <script type="text/javascript" src="${APP_PATH}/static/jquery/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/register.js"></script>
</head>
<body>
    <div class="wrapper">
        <img src="${APP_PATH}/static/images/register/register_bg.jpg">
        <div class="content">
            <div class="title">高邮市机关进校园系统</div>
            <form>
                <input type="text" id="listenerName" name="listenerName" placeholder="输入姓名">
                <input type="text" id="listenerNumb" name="listenerNumb" placeholder="输入身份证号码验证">
            </form>
            <div class="input_error"></div>
            <div id="registerSub" class="submit">注册并登陆<div></div></div>
        </div>
    </div>
</body>
<script>
    var path  = '<%=request.getContextPath()%>';
</script>
</html>
