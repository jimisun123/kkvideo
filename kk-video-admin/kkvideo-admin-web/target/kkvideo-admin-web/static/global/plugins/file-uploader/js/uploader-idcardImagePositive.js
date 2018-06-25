$(function () {
    $('#idcardImagePositiveFileUpload').fileupload({
        dataType: 'json',
        done: function (e, data) {
        	console.log(data);  
        	
        	if (data.result.status != "200") {
        		alert(data.result.msg);
        	} else {
                $.each(data.result.data, function (index, file) {
                  $("#idcardImagePositiveContent").html("<a href='" + file.url + "' target='_blank'><img src='" + file.url + "' width='120'></img></a>");
                  $("#idcardImagePositive").attr("value", file.urlDB);
              }); 
        	}
        },
        
        change: function (e, data) {
        	var size = data.files[0].size;
        
    		if((size / 1024 / 1024) > 2) {
				SweetAlert.error("图片大小不能超过2M...");
				return false;
			}
   		}
        
//        progressall: function (e, data) {
//	        var progress = parseInt(data.loaded / data.total * 100, 10);
//	        $('#progress .bar').css(
//	            'width',
//	            progress + '%'
//	        );
//   		},
   		
//		dropZone: $('#dropzone')
    });
    
//    $('#idcardImagePositiveFileUpload').on('change', function() {
//		
//	    var filepath = $(this).val();
//		if(filepath==""){
//			return false;
//		}
//		var extStart = filepath.lastIndexOf(".");
//		var ext = filepath.substring(extStart, filepath.length).toUpperCase();
//		if(ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
//			SweetAlert.error("图片限于png,gif,jpeg,jpg格式...");
//			return false;
//		} 
//		
//		if(($("#upload-file").get(0).files[0].size / 1024 / 1024) > 2) {
//			SweetAlert.error("图片大小不能超过2M...");
//			return false;
//		}
//    
//		if(($("#idcardImagePositiveFileUpload").get(0).files[0].size / 1024 / 1024) > 2) {
//			SweetAlert.error("图片大小不能超过2M...");
//			return false;
//		}
//	});
});