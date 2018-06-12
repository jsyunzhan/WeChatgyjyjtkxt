<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/public.css">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/notes.css">
    <script type="text/javascript" src="${APP_PATH}/static/jquery/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/public.js"></script>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.3&key=def2284f646e68d9760389eac586b046"></script>
    <script type="text/javascript" src="${APP_PATH}/static/jquery/pop.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/notes.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/listen/note.js"></script>
    <title>高邮市教育局机关进校园系统</title>
</head>
<body>
<div class="wrapper">
    <div class="title">听课评价</div>
    <div class="content_01">
        <div class="inform" id="school">
            <div class="name" width="100px;">听课学校</div>
            <div class="text"></div>
            <div class="arrow" width="100px;">
                <img src="${APP_PATH}/static/images/listen/right.png">
            </div>
        </div>
        <div class="inform" id="className">
            <div class="name" width="100px;">班级年级</div>
            <div class="text clearfix">
                <div class="left">年级</div>
                <div class="right">班级</div>
            </div>
        </div>
        <div class="inform" id="subject">
            <div class="name" width="100px;">听课学科</div>
            <div class="text"></div>
            <div class="arrow" width="100px;">
                <img src="${APP_PATH}/static/images/listen/right.png">
            </div>
        </div>
        <div class="inform">
            <div class="name" width="100px;">听课课题</div>
            <div class="text">
                <input type="text" id="topic" name="topic" placeholder="请填写听课课题">
            </div>
        </div>
        <div class="inform">
            <div class="name" width="100px;">执教老师</div>
            <div class="text">
                <input type="text" id="teacherName" name="teacher" placeholder="请填写执教老师">
            </div>
        </div>
        <div class="inform">
            <div class="name" width="100px;">听课内容</div>
            <div class="textarea">
                <textarea id="comments" name="comments" placeholder="请填写听课内容"></textarea>
            </div>
        </div>
        <div class="inform" id="score">
            <div class="name" width="100px;">课堂评价</div>
            <div class="text"></div>
            <div class="arrow" width="100px;">
                <img src="${APP_PATH}/static/images/listen/right.png">
            </div>
        </div>
    </div>
    <div class="content_02">
        <div class="image_num clearfix">
            <div>随堂照片</div>
        </div>
        <div class="upload">
            <form id="pictureForm" class="clearfix" enctype="multipart/form-data">
                <div class="addImage">
                    <input type="file" accept="image/*" name="singleFile1">	<!-- multiple属性支持多张照片上传 -->
                </div>
                <div class="addImage">
                    <input type="file" accept="image/*" name="singleFile1">
                </div>
                <div class="addImage">
                    <input type="file" accept="image/*" name="singleFile1">
                </div>
                <div class="addImage">
                    <input type="file" accept="image/*" name="singleFile1">
                </div>
            </form>
        </div>
        <div class="inform">
            <div class="name" width="100px;">听课地址</div>
            <div class="text town"></div>
            <div class="arrow" width="100px;"></div>
        </div>
    </div>
    <div class="content_03">
        <span></span>是否公开此评价
    </div>
    <div class="submit">提交</div>

</div>

<div class="footer" id="footer">
    <a href="javascript:;" id="secondNotes">
        <span><img src="${APP_PATH}/static/images/listen/icon_01.png"></span>
        <span style="color: #FFCC00;">听课评价</span>
        <div class="secondFloor none">
            <p onclick='window.location.href = "${APP_PATH}/listen/note"'>新建听课</p>
            <p onclick='window.location.href = "${APP_PATH}/history/history"'>历史评价</p>
        </div>
    </a>
    <a href="javascript:;">
        <span><img src="${APP_PATH}/static/images/listen/icon_06.png"></span>
        <span>机关进校</span>
        <div class="secondFloor none">
            <p onclick='window.location.href = "${APP_PATH}/organ/commentpage"'>机关进校</p>
            <p onclick='window.location.href = "${APP_PATH}/organ/historypage"'>历史评价</p>
        </div>
    </a>
    <a href="${APP_PATH}/history/history">
        <span><img src="${APP_PATH}/static/images/listen/icon_07.png"></span>
        <span>历史评价</span>
    </a>
    <a href="${APP_PATH}/user/personal">
        <span><img src="${APP_PATH}/static/images/listen/icon_08.png"></span>
        <span>用户中心</span>
    </a>
</div>
</body>
</html>
</body>
<script>
    var path  = '<%=request.getContextPath()%>';
</script>
</html>