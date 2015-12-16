function open(){
	// init ocean
	$.getJSON("GetSettingJson?gameId=1", function() {
	    console.log("[INFO]READ SETTING 1");
	})
	.success(function(result) {
	    console.log("[INFO]READ SUCCEED");
        $.each(result.setting, function(i, field){
            $("#s1"+i).val(field);
        });
	})
	.error(function(jqXHR, textStatus, errorThrown) {
	    console.log("[ERROR]" + textStatus);
	    console.log("[ERROR]" + jqXHR.responseText);
	})
	.complete(function() {
	    console.log("[INFO]COMPLITE");
	});

	// init 大花火
	$.getJSON("GetSettingJson?gameId=2", function() {
	    console.log("[INFO]READ SETTING 2");
	})
	.success(function(result) {
	    console.log("[INFO]READ SUCCEED");
        $.each(result.setting, function(i, field){
            $("#s2"+i).val(field);
        });
	})
	.error(function(jqXHR, textStatus, errorThrown) {
	    console.log("[ERROR]" + textStatus);
	    console.log("[ERROR]" + jqXHR.responseText);
	})
	.complete(function() {
	    console.log("[INFO]COMPLITE");
	});

	// chnage event
	$("input").change(function(ev){
		//console.log(ev);
		var target = ev.target;
		var value = target.value;
		var id = target.id;
		var param = id+":"+value;
		console.log("[INFO]"+ param);

		$.getJSON("SetSettingService?param="+param, function() {
		    console.log("[INFO]RENEW SETTING");
		})
		.success(function(result) {
		    console.log("[INFO]RENEW SUCCEED");
		})
		.error(function(jqXHR, textStatus, errorThrown) {
		    console.log("[ERROR]" + textStatus);
		    console.log("[ERROR]" + jqXHR.responseText);
		})
		.complete(function() {
		    console.log("[INFO]COMPLITE");
		});
	});
}

$(document).ready(open);
