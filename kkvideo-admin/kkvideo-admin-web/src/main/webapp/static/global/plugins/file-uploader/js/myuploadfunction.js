$(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
        
        done: function (e, data) {
        	console.log(data);  
        	$("tr:has(td)").remove();
            $.each(data.result.data, function (index, file) {
            	
//                $("#uploaded-files").append(
//                		$('<tr/>')
//                		.append($('<td/>').html("<img src='" + file.url + "' width='80' hight='80'></img>"))
//                		.append($('<td/>').text(file.fileSize))
//                		.append($('<td/>').text(file.fileType))
//                		.append($('<td/>').html("<a href='rest/controller/get/"+index+"'>Click</a>"))
//                		);
                		
                $("#lee").append("<a href='" + file.url + "'><img src='" + file.url + "' width='80' hight='80'></img></a>");
                $("#lee").append("<a href='" + file.smallUrl + "'><img src='" + file.smallUrl + "' width='80' hight='80'></img></a>");
            }); 
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