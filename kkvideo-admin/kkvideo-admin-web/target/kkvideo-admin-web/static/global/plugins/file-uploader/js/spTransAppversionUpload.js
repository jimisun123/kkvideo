$(function () {
	 //上传文件
	 $('#sptrans_versionupload').fileupload({
	        dataType: 'json',
	        done: function (e, data) {
	         
	        	if (data.result.status != "200") {
	        		alert("上传失败!");
	        	} else {
	                $.each(data.result.data, function (index, file) {
	                  $("#updateUrl").attr("value", file.urlDB); 
	                  $("#prompt").html("<font color='red'>上传成功</font></br>上传的文件地址:"+file.url);
	              }); 
	        	}
	        },
	        
	        progressall: function (e, data) {
		        var progress = parseInt(data.loaded / data.total * 100, 10);
		        $('#progress .bar').css(
		            'width',
		            progress + '%'
		        );
	   		},
			dropZone: $('#dropzone')
	    });
});