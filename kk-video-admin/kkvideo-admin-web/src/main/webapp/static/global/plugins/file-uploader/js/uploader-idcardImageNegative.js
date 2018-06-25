$(function () {
    $('#idcardImageNegativeUpload').fileupload({
        dataType: 'json',
        done: function (e, data) {
        	console.log(data);  
        	
        	if (data.result.status != "200") {
        		alert(data.result.msg);
        	} else {
                $.each(data.result.data, function (index, file) {
                  $("#idcardImageNegativeContent").html("<a href='" + file.url + "' target='_blank'><img src='" + file.url + "' width='120'></img></a>");
                  $("#idcardImageNegative").attr("value", file.urlDB);
              }); 
        	}
        }//,
        
//        progressall: function (e, data) {
//	        var progress = parseInt(data.loaded / data.total * 100, 10);
//	        $('#progress .bar').css(
//	            'width',
//	            progress + '%'
//	        );
//   		},
   		
//		dropZone: $('#dropzone')
    });
});