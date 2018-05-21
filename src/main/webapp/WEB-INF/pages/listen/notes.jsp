<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="../../../static/css/public.css">
    <link rel="stylesheet" type="text/css" href="../../../static/css/index.css">
    <script type="text/javascript" src="../../../static/jquery/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.3&key=def2284f646e68d9760389eac586b046"></script>
    <script type="text/javascript" src="../../../static/jquery/pop.js"></script>
    <script type="text/javascript" src="../../../static/js/index.js"></script>
    <script type="text/javascript" src="../../../static/js/listen/note.js"></script>
    <title>高邮市教育局机关进校园系统</title>
</head>
<body>
<form class="wrapper">
    <div class="title">听课评价</div>
    <div class="content_01">
        <div class="inform">
            <div class="name" width="100px;">所属乡镇</div>
            <div class="text"></div>
            <div class="arrow" width="100px;">
                <img src="../../../static/images/right.png">
            </div>
            <select id="town" name="town"><option>请选择</option></select>
        </div>
        <div class="inform">
            <div class="name" width="100px;">学校类型</div>
            <div class="text"></div>
            <div class="arrow" width="100px;">
                <img src="../../../static/images/right.png">
            </div>
            <select id="school_lx" name="school_lx"><option>请选择</option></select>
        </div>
        <div class="inform">
            <div class="name" width="100px;">听课学校</div>
            <div class="text"></div>
            <div class="arrow" width="100px;">
                <img src="../../../static/images/right.png">
            </div>
            <select id="school" name="school"><option>请选择</option></select>
        </div>
        <div class="inform">
            <div class="name" width="100px;">班级年级</div>
            <div class="text">
                <input type="text" id="className" name="class" placeholder="请填写听课班级">
            </div>
            <div class="arrow" width="100px;"></div>
        </div>
        <div class="inform">
            <div class="name" width="100px;">听课学科</div>
            <div class="text"></div>
            <div class="arrow" width="100px;">
                <img src="../../../static/images/right.png">
            </div>
            <select id="subject"><option>请选择</option></select>
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
            <div class="name" width="100px;">课堂评价</div>
            <div class="textarea">
                <textarea id="comments" name="comments" placeholder="请填写课堂评价"></textarea>
            </div>
        </div>
        <div class="inform">
            <div class="name" width="100px;">课堂评分</div>
            <div class="text"></div>
            <div class="arrow" width="100px;">
                <img src="../../../static/images/right.png">
            </div>
            <select id="score" name="score"><option>请选择</option></select>
        </div>
    </div>
    <div class="content_02">
        <div class="image_num clearfix">
            <div>随堂照片</div>
            <div><span class="imagesNum">0</span>/4</div>
        </div>
        <div class="upload clearfix">
            <div class="addImage">
                <input type="file" accept="image/*" name="addImage" id="addImage" multiple>	<!-- multiple属性支持多张照片上传 -->
            </div>
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
</form>

<div class="footer">
    <a href="javascript:;">
            <span><img src="../../../static/images/icon_01.png"></span>
            <span style="color: #FFCC00;">听课评价</span>
    </a>
    <a href="javascript:;">
        <span><img src="../../../static/images/icon_06.png"></span>
        <span>机关进校</span>
    </a>
    <a href="http://www.baidu.com">
        <span><img src="../../../static/images/icon_07.png"></span>
        <span>历史评价</span>
    </a>
    <a href="javascript:;">
        <span><img src="../../../static/images/icon_08.png"></span>
        <span>用户中心</span>
    </a>
</div>
</body>
</html>
</body>
</html>