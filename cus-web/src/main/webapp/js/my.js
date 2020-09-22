/** 给数据行绑定鼠标覆盖以及鼠标移开事件 */
function tableMouseHover() {
    $("tr[id^='data_']").hover(function() {
	$(this).css("backgroundColor", "#eeccff");
    }, function() {
	$(this).css("backgroundColor", "#ffffff");
    })
}