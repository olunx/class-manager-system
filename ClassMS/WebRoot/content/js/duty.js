	$( function() {
		$(".table").tablesorter( {
			headers : {
				0 : {
					sorter :false
				},
				1 : {
					sorter :false
				},
				4 : {
					sorter :false
				},
				5 : {
					sorter :false
				},
				6 : {
					sorter :false
				}
			}
		});
	});

//$(function() {
//	
//	$("#dialog").dialog({
//		bgiframe: true,
//		autoOpen: false,
//		width:320,
//		height: 175,
//		modal: true
//	});
//	
//	$('#create').click(function() {
//		$('#dialog').dialog('open');
//	})
//	
//	$("a[rel='update']").click(function() {
//		
//		//alert($(this).attr('value'));
//		
//		$.get($(this).attr('value'), function(data){
//			  //alert("Data Loaded: " + data);
//			  $('#update-dialog').append(data);
//			  $('#update-dialog').dialog('open');
//		});
//		
//		
//		$("#update-dialog").dialog({
//			bgiframe: true,
//			autoOpen: false,
//			width:320,
//			height: 245,
//			modal: true,
//			close: function() {
//				$('#update-dialog').empty();
//			}
//		});
//	})
//	
//});


