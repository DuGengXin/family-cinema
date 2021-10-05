//目录工具 1.显示/隐藏
function showWin(id) {
    $(".check").removeClass("active");
    $("#f" + id).addClass("active");
    //显示
    $(".check2").hide(100);
    $("#f" + id + "2").show(100);
}

// 2.悬浮
$(window).scroll(
    function () {
        if ($("#muLu2").is(':hidden')) {
            if ($(document).scrollTop() > 200) {
                $("#muLu1").show(100);
                $("#muLu1").css({
                    "position": "fixed",
                    "right": "0",
                    "top": "7em"
                });
            } else {
                $("#muLu1").hide();
            }
        }
    });
$("#muLuBtn").click(function () {
    $("#muLu2").hide(100);
    $("#muLu1").css("display", "block");
});
$("#muLu1").click(function () {
    $("#muLu2").show(100);
    $("#muLu1").css("display", "none");
});