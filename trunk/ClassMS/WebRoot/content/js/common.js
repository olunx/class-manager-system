
/** 
* 获得当前的日期 
*/ 
function getCurrentDate() { 
	var today,hour,second,minute,year,month,date;
	today = new Date();
	year = addZero(today.getFullYear());
	month = addZero(today.getMonth()+1);
	date = addZero(today.getDate());
	hour = addZero(today.getHours());
	minute =addZero(today.getMinutes());
	second = addZero(today.getSeconds());
	var currentDateStr = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minute + ":" + second; //显示时间
	document.getElementById('header_datetime').innerHTML = "时间："+currentDateStr; 
	setTimeout("getCurrentDate();", 1000); //设定函数自动执行时间为 1000 ms(1 s)
}; 

function addZero(num){
	if (num<10) {return "0"+num;} else {return num};
}


$(function(){	
	$(".table tr :checkbox").click(function(){
		if ($(this).attr("checked")){
			$(this).parent().parent().addClass("trselected");
		}
		else {
			$(this).parent().parent().removeClass("trselected");
		}
	});

	$(".table tr").hover(
	  function () {
		$(this).addClass("trhover");
	  },
	  function () {
		$(this).removeClass("trhover");
	  }
	);

});
