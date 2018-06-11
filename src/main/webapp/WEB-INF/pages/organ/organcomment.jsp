<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    <script type="text/javascript" src="${APP_PATH}/static/jquery/pop.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/organ/organcomment.js"></script>
    <title>机关进校园</title>
</head>
<body>
    <div class="wrapper">
        <div class="title">机关进校园</div>
        <div class="content_01">
            <div class="inform" id="school">
                <div class="name" width="100px;">听课学校</div>
                <div class="text"></div>
                <div class="arrow" width="100px;">
                    <img src="${APP_PATH}/static/images/listen/right.png">
                </div>
            </div>
        </div>
        <div class="content_01">
            <div class="inform">
                <div class="name" width="100px;">活动小记</div>
                <div class="textarea">
                    <textarea id="checkContent" name="comments" placeholder="请填写校园活动内容和校园印象"></textarea>
                </div>
            </div>
        </div>
        <div class="content_02">
            <div class="image_num clearfix">
                <div>校园照片</div>
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
        </div>
        <div class="submit">提交</div>
    </div>
    <div class="footer">
        <a href="javascript:;" id="secondNotes1">
            <span><img src="${APP_PATH}/static/images/listen/icon_05.png"></span>
            <span>听课评价</span>
            <div class="secondFloor none">
                <p>新建听课</p>
                <p>历史评价</p>
            </div>
        </a>
        <a href="javascript:;"  id="secondNotes2">
            <span><img src="${APP_PATH}/static/images/listen/icon_02.png"></span>
            <span style="color: #FFCC00;">机关进校</span>
            <div class="secondFloor none">
                <p>机关进校</p>
                <p>历史评价</p>
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
<script>
    var path  = '<%=request.getContextPath()%>';
</script>
</html>
