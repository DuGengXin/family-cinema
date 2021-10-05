//图片工具类
$(function() {
	$(".imgs").click(function () {
		var url =$(this).attr("title");
		changeUrl($(this),url);
	});

	$(".imgs").error(function() {
		$(this).attr("src", "image/1000367.jpg");
		$(this).attr("alt", "正在处理...");
	});

});
function changeUrl(img, url) {
	img.attr("src", url + ".gif");
	setTimeout(function() {
		img.attr("src", url + ".png");
	}, 10000);
}