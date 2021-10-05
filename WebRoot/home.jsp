<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>逍遥天下</title>
    <!-- Bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
            rel="stylesheet">


    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <style>
        * {
            border-radius: 10px;
        }

        .row {
            margin: 0.1em;
            padding: 0.1em;
        }

        button {
            border-radius: 0;
            text-align: center;
        }

        /* 多余文字隐藏 */
        .text {
            text-decoration: none;
            color: black;
            font-size: 1.5em;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp:2;
            -webkit-box-orient: vertical;
        }

        .muLu {
            position: fixed;
            right: 0;
            top: 5em;
            z-index: 999;
            font-size: 1.5em;

        }

        #muLu1 {
            text-align: center;
            display: block;
            width: 2em;
            height: 4.5em;
            border: 1px solid black;
            background-color: #ffffff;
        }

        #muLu2 {
            opacity: 0.8;
        }
        a{
            text-decoration: none;
            color: black;
        }
        a:hover{
            color: dimgray;
            text-decoration: none;
        }
    </style>

</head>

<body class="bg-info" style="overflow-x: hidden;">
<!--导航开始-->
<nav class="navbar navbar-default navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">逍遥酒馆</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" id="nav">
                <li><a href="#"> <span class="sr-only">(current)</span> </a></li>
                <li><a href="home.jsp">首页</a></li>
                <li><a href="manage.jsp">管理</a></li>
                <li><a href="play.jsp">我的空间</a></li>
                <li><a href="index.jsp">登录&注册</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<!--开始主体部分-->
<div class="page-header" align="center">
    <h1>
       家庭影院 <br/> <small>POWER BY JAVA&HTML&JAVASCREPT</small>
       <br/> <small>欢迎您:${loginUser.urname}</small>
    </h1>
</div>
<!--轮播图-->
<div class="row">
    <div id="carousel-example-generic" class="carousel slide"
         data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0"
                class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="image/tkdt.jpg">
            </div>
            <div class="item">
                <img src="image/yzfc.png">
            </div>
            <div class="item">
                <img src="image/yzhx.jpg">
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic"
           role="button" data-slide="prev"> <span
                class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span> </a> <a
            class="right carousel-control" href="#carousel-example-generic"
            role="button" data-slide="next"> <span
            class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span> </a>
    </div>
    <hr/>
    <c:if test="${empty loginUser}">
    <div class="jumbotron" align="center">
        <h1>未登录</h1>
        <p>
            <a class="btn btn-primary btn-lg" href="index.jsp" role="button">你可以点此登录</a>
        </p>
    </div>
    </c:if>
    <c:if test="${!empty loginUser}">
    <c:if test="${empty folderList}">
    <div class="jumbotron" align="center">
        <h1>您好，暂无资源</h1>
        <p>
            <a class="btn btn-primary btn-lg" href="manage.jsp" role="button">你可以点此添加资源</a>
        </p>
    </div>
    </c:if>
    </c:if>

    <%--目录--%>
    <a class="muLu" id="muLu1"><span class="glyphicon glyphicon-triangle-left"></span><span>目<br>录</span></a>
    <div style="width:10em;height:15em;background-color:#ecf1eb"
         class="muLu" id="muLu2">
        <div style="border-bottom: 1px solid black;margin-bottom: 3px;" align="right">
            <span style="font-size: 1.5em;line-height: 1.5em;color: red">&nbsp;&nbsp;目录</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a id="muLuBtn" style="color: red;font-size:1.5em;"><span class="glyphicon glyphicon-remove"></span></a>
        </div>
        <br>
        <div class="list-group" style="overflow-x: hidden;overflow-y: auto;width:100%;height:80%;" >
            <c:set var="i" value="1"></c:set>
            <!--可循环-->
            <c:forEach var="folder" items="${folderList}">

                <c:if test="${i==1}">
                    <button id="f${folder.id}" type="button" onclick="showWin('${folder.id}');"
                            class="list-group-item check active">
                            ${i}. ${folder.folderName}
                    </button>
                </c:if>
                <c:if test="${i!=1}">
                    <button id="f${folder.id}" type="button" onclick="showWin('${folder.id}');"
                            class="list-group-item check">
                            ${i}. ${folder.folderName}
                    </button>
                </c:if>
                <c:set var="i" value="${i+1}"></c:set>
            </c:forEach>
            <!--可循环-->
        </div>
    </div>
    <!--视频缩略图-->
    <div>
        <c:set var="i" value="1"></c:set>
        <c:forEach var="folder" items="${folderList}" varStatus="index">
		
        <c:if test="${i==1}">
        <div class="row first check2" id="f${folder.id}2">
        </c:if>

            <c:if test="${i!=1}">
            <div class="row check2" id="f${folder.id}2" align="center">
                </c:if>
				<div class="row ">
                <div class="col-md-12 ">
                    <h1 style="text-align:center; ">${folder.folderName}</h1>
                    <hr style="margin-top: 20px;border: 2px #000000 solid;width: 50%; " />
                </div>
            </div>
                <!-- 可循环 -->
                <c:forEach var="video" items="${folder.myvideos}" varStatus="index">

                    <div class="col-md-3 col-md-offset-2"
                         style="margin:0;padding:5px;" align="center">
                        <br/> <img class="img-responsive imgs lazy" id="i${video.id}" src="${video.imgPathUrl}.png"
                                   title="${video.imgPathUrl}">
                        <div style="height: 4em;padding:1em;">
                            <a href="video_play?videoId=${video.id}"
                               class="text" title="${video.videoName}">${video.videoName}</a>
                        </div>
                    </div>
                </c:forEach>
                <!-- 可循环 -->
            </div>
            <c:set var="i" value="2"></c:set>
            </c:forEach>
        </div>


        <div style="margin-top: 20em;"></div>
</body>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script
        src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript" src="js/lazyload.js">

</script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="js/home_imgUtil.js"></script>
<script src="js/home_muluUtil.js"></script>

<script>
    //初始化
    $(function () {
        $(".check2").hide();
        $(".first").show();
        $(".muLu").hide();
    });
    //点击图片时使用Ajax生成Gif预览图
    //     function cutGif(img1){
    //         var a=img1.attr("data-videoId");
    //         var httpRequest = new XMLHttpRequest();//第一步：建立所需的对象
    //         httpRequest.open('GET','video_creGif?vid='+a, true);//第二步：打开连接
    //         httpRequest.send(); //第三步：发送请求  将请求参数写在URL中
    //     }
    // 	$(".lazy").click(function () {
    //         cutGif($(this));
    // 	});
    //     $(".lazy").mousemove(function () {
    //         cutGif($(this));
    //     });
</script>

</html>