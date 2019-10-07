/*
 * SWFUpload jQuery Plugin v1.0.0
 *
 * Copyright (c) 2009 Adam Royle
 * Licensed under the MIT license.
 * edit by aFen @2011
 */

(function($){
	
	var defaultHandlers = ['swfupload_loaded_handler','file_queued_handler','file_queue_error_handler','file_dialog_start_handler','file_dialog_complete_handler','upload_start_handler','upload_progress_handler','upload_error_handler','upload_success_handler','upload_complete_handler','queue_complete_handler'];
	var additionalHandlers = [];
	
	$.fn.swfupload = function(){
		var args = $.makeArray(arguments);
		return this.each(function(){
			var swfu;
			if (args.length == 1 && typeof(args[0]) == 'object') {
				swfu = $(this).data('__swfu');
				if (!swfu) {
					var settings = args[0];
					var $magicUploadControl = $(this);
					var handlers = [];
					$.merge(handlers, defaultHandlers);
					$.merge(handlers, additionalHandlers);
					$.each(handlers, function(i, v){
						var eventName = v.replace(/_handler$/, '').replace(/_([a-z])/g, function(){ return arguments[1].toUpperCase(); });
						settings[v] = function() {
							var event = $.Event(eventName);
							$magicUploadControl.trigger(event, $.makeArray(arguments));
							return !event.isDefaultPrevented();
						};
					});
					$(this).data('__swfu', new SWFUpload(settings));
				}
			} else if (args.length > 0 && typeof(args[0]) == 'string') {
				var methodName = args.shift();
				swfu = $(this).data('__swfu');
				if (swfu && swfu[methodName]) {
					swfu[methodName].apply(swfu, args);
				}
			}
		});
	};
	
	$.swfupload = {
		additionalHandlers: function() {
			if (arguments.length === 0) {
				return additionalHandlers.slice();
			} else {
				$(arguments).each(function(i, v){
					$.merge(additionalHandlers, $.makeArray(v));
				});
			}
		},
		defaultHandlers: function() {
			return defaultHandlers.slice();
		},
		getInstance: function(el) {
			return $(el).data('__swfu');
		}
	};

	$.fn.swupbind = function(callback){
		$(this)
		.bind('swfuploadLoaded', function(event){
		})
		.bind('fileQueued', function(event, file){
			$("#loading").remove();
			$('<div id="loading" style="z-index:1; padding:1px; left:0; top:0; color:#03C; background:#FFF; width:350px; border: 1px solid #03C; height: 15px;"><div id="complete" style="float:left;background: #2F63FF; z-index:2; color: #fff; font-size: 12px;width:0px; text-align: center; height: 15px; overflow: hidden;">uploading...</div></div>').appendTo(this);
			$(this).swfupload('startUpload');
		})
		.bind('fileQueueError', function(event, file, errorCode, message){
			$('<div id="loading" style="z-index:1; padding:1px; left:0; top:0; color:#03C; background:#FFF; width:350px; border: 1px solid #03C; height: 15px;"><div id="complete" style="float:left;background: #2F63FF; z-index:2; color: #fff; font-size: 12px;width:350px; text-align: center; height: 15px; overflow: hidden;">uploading...</div></div>').appendTo(this);
			$('#complete').html("File queue error:"+errorCode+" "+message);
		})
		.bind('fileDialogStart', function(event){
		})
		.bind('fileDialogComplete', function(event, numFilesSelected, numFilesQueued){
		})
		.bind('uploadStart', function(event, file){
			$('#uploading_status').val("1");
			$('#complete').html("uploading...");
		})
		.bind('uploadProgress', function(event, file, bytesLoaded,bytesTotal){
			$('#complete').width(350*bytesLoaded/bytesTotal);
		})
		.bind('uploadSuccess', function(event, file, serverData){
			//alert(serverData);
			eval("loaddata="+serverData);
			if(!loaddata.error){
				//$("#"+objinput).val(loaddata.normal);
				callback(loaddata);
				$("#loading").remove();
			}else{
				$('#complete').html(loaddata.error);
			}
		})
		.bind('uploadComplete', function(event, file){
			$(this).swfupload('startUpload');
			$('#uploading_status').val("0");
		})
		.bind('uploadError', function(event, file, errorCode, message){
			$('#complete').html("error:"+errorCode+" "+message);
		});
	}
	
})(jQuery);

/*
<script type="text/javascript" src="<?php echo base_url();?>js/swfupload/swfupload.js"></script>
<script type="text/javascript" src="<?php echo base_url();?>js/swfupload/jquery.swfupload.js"></script>
	$('#picupload').swfupload({
		upload_url: "<?php echo base_url();?>upload/uploads/image",
		file_size_limit : "2048", //2MB
		file_types : "*.jpeg;*.jpg;*.gif;*.png;",
		file_types_description : "All Files",
		file_upload_limit : "0",
		flash_url : "<?php echo base_url();?>js/swfupload/swfupload.swf",
		button_image_url : '<?php echo base_url();?>js/swfupload/XPButtonUploadText_61x22.png',
		button_width : 61,
		button_height : 22,
		button_placeholder : $('#picload')[0],
		post_params: {"PHPSESSID" : "","adminid":<?php echo($sessions['admin_id']) ?>}
	})
		$('#picupload').swupbind(function(data){$('#pic').val(data);})


		<div id="picupload">
			<input name="pic" type="text" class="input" id="pic" value="" size="30" />
			<div id="picload" style="width:61px;height:22px;"></div>(max 2M jpg gif png)
		</div>
*/