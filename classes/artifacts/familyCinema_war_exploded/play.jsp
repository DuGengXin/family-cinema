<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${video.videoName}</title>
    <!-- Bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
            rel="stylesheet">
    <link href="css/video-js.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <style>
        h4 {
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 1;
            -webkit-box-orient: vertical;
            font-size: 1.5em;
        }
    </style>
</head>

<body class="bg-info" style="overflow-x: hidden; margin: 0; padding: 0;">
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
                <li><a href="#"> <span class="sr-only">(current)</span> </a>
                </li>
                <li><a href="home.jsp">首页</a>
                </li>
                <li><a href="manage.jsp">管理</a>
                </li>
                <li><a href="play.jsp">我的空间</a></li>
                </li>
                <li><a href="index.jsp">登录&注册</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<!--开始主体部分-->
<div class="row bg-info" style="margin-top: 1em;margin-bottom:20em;">
    <div class="col-md-7" id="bofang">
        <div class="row">
            <div class="col-md-12" align="center">
                <%--					<video id="video" src="${video.videoPathUrl}" controls="controls"--%>
                <%--						width="100%" autoplay>--%>
                <%--					</video>--%>
                <div id="video" width="80%" align="center"></div>
                <script type="text/javascript" src="js/ckplayer.js"></script>
                <script type="text/javascript">
                    var videoObject = {
                        container: '#video', //容器的ID或className
                        variable: 'player', //播放函数名称
                        poster: '${video.imgPathUrl}.png', //封面图片
                        video: [ //视频地址列表形式
                            ["http://"+window.location.host+"${video.videoPathUrl}", 'video/mp4', '中文标清', 0]
                        ]
                    };
                    var player = new ckplayer(videoObject);
                </script>
                <h4>${video.videoName}</h4>
            </div>
        </div>
        <br/>
        <div class="row" style="margin: 1em;">
            <div class="col-md-10 col-md-offset-1" align="center">
            <form action="mess_addMes" method="post">
                <div class="row">
                	<input type="text" hidden  name="vid" value="${video.id}">
                    <input type="text" hidden  name="urname" value="${loginUser.urname}">
                    <textarea class="form-control" name="mes" rows="3" placeholder="在这里输入你想说的！" ></textarea>
                </div>
                <br/>
                <div class="row">
                    <div class="col-md-4 col-md-offset-8">
                        <input type="submit" text="发表评论" class="btn btn-primary form-control" />
                    </div>
                </div>
             </form>
                <hr/>
                <div class="row">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">评论</h3>
                        </div>
                        <!--可循环-->
                         <c:forEach var="mess" items="${allMessage}">
                        <div class="panel-body" align="left">
                            <div class="alert alert-success" role="alert">
									<span class="glyphicon glyphicon glyphicon-user"
                                          aria-hidden="true"></span> <span class="userInfo">${mess.urname}</span>
                                <br> <br>
                                <p class="userSay"style="margin-left: 1em;">${mess.mes}</p>
                                <div align="right" role="alert">
                                    <i class="passTime">${mess.date}</i>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
                <!--移动端目录-->
                <div class="row visible-xs visible-sm">
                    <div class="panel panel-default">
                        <div class="panel-heading">目录</div>
                        <div class="panel-body" style="overflow-y: auto;height:25em;">
                            <c:forEach var="folder" items="${folderList}">
                                <!--可循环-->
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h2 class="panel-title">
                                                ${folder.folderName}<span class="label label-default"></span>
                                        </h2>
                                    </div>
                                    <div class="panel-body">
                                        <c:forEach var="video" items="${folder.myvideos}">
                                            <!-- 可循环 -->
                                            <a href="video_play?videoId=${video.id }"
                                               class="list-group-item">${video.videoName}</a>
                                            <!-- 可循环 -->
                                        </c:forEach>
                                    </div>
                                </div>
                                <!--可循环-->
                            </c:forEach>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="col-md-4 visible-md visible-lg" align="center">
        <!--轮播图-->
        <h3>最新视频</h3>
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
                        <img src="image/v1.png">
                    </div>
                    <div class="item">
                        <img src="image/v2.png">
                    </div>
                    <div class="item">
                        <img src="image/v3.png">
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
        </div>
        <hr/>
        <!--pc目录-->
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">目录</div>
                <div class="panel-body" style="overflow-y: auto;height:25em;">
                    <c:forEach var="folder" items="${folderList}">
                        <!--可循环-->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h2 class="panel-title">
                                        ${folder.folderName}<span class="label label-default"></span>
                                </h2>
                            </div>
                            <div class="panel-body">
                                <c:forEach var="video" items="${folder.myvideos}">
                                    <!-- 可循环 -->
                                    <a href="video_play?videoId=${video.id }"
                                       class="list-group-item">${video.videoName}</a>
                                    <!-- 可循环 -->
                                </c:forEach>
                            </div>
                        </div>
                        <!--可循环-->
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script
        src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        var i = 1;
        //				//隐藏目录
        //				$("#mulu").hide();
        //出现目录
        $("#mulubt").click(function () {
            i++;
            if (i % 2 == 0) {
                $("#mulu").hide();
            } else {
                $("#mulu").show();

            }

        });
        //变更视频源
        $(".check").click(function () {
            var src1 = "videos/" + $(this).text() + ".mp4";
            $("#video").attr("src", src1);
        });
    });
</script>
</body>

</html>