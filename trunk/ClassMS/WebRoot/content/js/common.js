/**
 * 获得当前的日期
 */
function getCurrentDate() {
	var today, hour, second, minute, year, month, date;
	today = new Date();
	year = addZero(today.getFullYear());
	month = addZero(today.getMonth() + 1);
	date = addZero(today.getDate());
	hour = addZero(today.getHours());
	minute = addZero(today.getMinutes());
	second = addZero(today.getSeconds());
	var currentDateStr = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minute + ":" + second; // 显示时间
	document.getElementById('header_datetime').innerHTML = "时间：" + currentDateStr;
	setTimeout("getCurrentDate();", 1000); // 设定函数自动执行时间为 1000 ms(1 s)
};

function addZero(num) {
	if (num < 10) {
		return "0" + num;
	} else {
		return num
	}
	;
};

function addNewActivity(obj) {
	var html = '<div>原因：<input type="text" name="reason" /> 分数：<input type="text" name="mark" />';
	html += ' <select name="type"><option value="德育"> 德育</option><option value="活动">活动</option>';
	html += '<option value="文体">文体</option></select> <a href="#" class="btn_del" onclick="delActivity(this)">删除</a></div>';
	for ( var i = 0; i < 3; i++) {
		$("#" + obj).append(html);
	}
};

function delActivity(obj) {
	$(obj).parent().remove();
};

function addNewVote(obj) {
	var html = '<div>选项：<input type="text" name="content" /> <a href="#" class="btn_del" onclick="return delVote(this)">删除</a></div>';
	for ( var i = 0; i < 3; i++) {
		$("#" + obj).append(html);
	}
	return false;
};

function delVote(obj) {
	$(obj).parent().remove();
	return false;
};

$(function() {
	// 选中checkbox变色
	$(".table tr :checkbox").click(function() {
		if ($(this).attr("checked")) {
			$(this).parent().parent().addClass("trselected");
		} else {
			$(this).parent().parent().removeClass("trselected");
		}
	});

	// 鼠标移上表格变色
	$(".table tr").hover(function() {
		$(this).addClass("trhover");
	}, function() {
		$(this).removeClass("trhover");
	});

	$("a[rel='checkall']").click(function() {
		$(":checkbox").each(function(i) {

			if ($(this).attr("checked")) {

				$(this).attr("checked", false);

			} else {
				$(this).attr("checked", true);
			}

		})
	});
});
