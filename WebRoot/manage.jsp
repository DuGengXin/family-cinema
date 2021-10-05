<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>视频资源管理</title>
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
                <li><a href="#"> <span class="sr-only">(current)</span> </a>
                </li>
                <li><a href="home.jsp">首页</a>
                </li>
                <li><a href="#">管理</a>
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
<div class="row" align="center">
    <h3 style="color: red;">${message}</h3>
</div>
<!-- pc端 -->
<div class="row" style="font-size:1em;">
    <div class="col-md-3 visible-md visible-lg" align="center">
        <div class="list-group">
            <button type="button" class="list-group-item active sel"
                    onclick="showMeun('fidn','fid');">查看资源分类
            </button>
            <button type="button" class="list-group-item sel"
                    onclick="showMeun('add1','add');">增加资源分类
            </button>
        </div>
    </div>
    <div class="col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-7 col-md-offset-1"
            style="overflow-y:auto; " align="center">
        <div class="row visible-md visible-lg" style="height: 5em;"></div>
        <div id="fid" class="row">
            <c:if test="${empty folderList}">
                <div class="jumbotron" align="center">
                    <h1>您好，暂无资源</h1>
                    <p>你可以点击右侧或下方的增加资源按钮</p>
                </div>
            </c:if>
            <c:if test="${!empty folderList}">
                <h2>当前所有视频源</h2>
            </c:if>
            <table class="table table-hover" width="100%" style="font-family: 黑体;font-size: 2rem;">
			<c:forEach var="folder" items="${folderList}">
				<tr>
					<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${folder.folderName} </td>
					<td align="right">
						<a onclick="warning('${folder.id}');" class="btn btn-danger" style="margin-right:10%;">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
        </div>

        <div id="add" class="row">
            <h2>添加视频源</h2>
            <form action="video_addFolder" method="post">
                <div class="form-group">
                    <label>分类名称</label> <input
                        class="form-control" type="text" name="folderName"
                        placeholder="请输入分类名称" required>
                </div>
                <div class="form-group">
                    <label>分类的绝对路径</label> <input
                        class="form-control" type="text" name="folderTrueUrl"
                        placeholder="例：G:\videos\爱与死亡与机器人" required>
                </div>
                <button type="submit" id="tj" class="btn btn-default">提交视频源</button>
            </form>
            <div class="alert alert-danger text2" role="alert"></div>
        </div>
        <br/> <br/>
    </div>
    <!-- 移动端 -->
    <div class="row isible-sm visible-xs" align="center">
        <button type="button" id="fidn" class="btn btn-default"
                onclick="showMeun('fidn','fid');">查看资源种类
        </button>
        <button type="button" id="add1" class="btn btn-default"
                onclick="showMeun('add1','add');">增加资源种类
        </button>
        <button type="button" id="dele" class="btn btn-default"
                onclick="showMeun('dele','del');">...
        </button>
    </div>

</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script
        src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script
        src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#add").hide();
        $("#del").hide();
        $(".text1").hide();
        $(".text2").hide();
    });

    function showMeun(id1, id2) {
        $(".sel").removeClass("active");
        $("#" + id1).addClass("active");
        $("#fid,#del,#add").hide();
        $("#" + id2).show();
    }

    function warning(id) {
        var r = confirm("你确定要删除该视频源及其相关信息吗?");
        if (r) {
            var httpRequest = new XMLHttpRequest();//第一步：建立所需的对象
            httpRequest.open('GET', 'video_delFAV?id=' + id, true);//第二步：打开连接  将请求参数写在url中  ps:"./Ptest.php?name=test&nameone=testone"
            httpRequest.send();//第三步：发送请求  将请求参数写在URL中
            setTimeout(function () {
                window.location.reload();
            }, 3000);
            $(".btn").attr("disabled", "disabled");
            $(".text").show();
            $(".text").text("正在删除请稍等...");
        }
        $(".tj").click(function () {
            $(".tj").attr("disabled", "disabled");
            $(".text2").show();
            $(".text2").text("正在处理！请稍后...");
        });
    }
</script>
</body>

</html>