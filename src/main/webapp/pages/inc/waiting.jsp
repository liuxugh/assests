<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="loadingModal">
	<div style="width: 200px;height:20px; z-index: 20000; position: absolute; text-align: center; left: 50%; top: 50%;margin-left:-100px;margin-top:-10px">
		<div class="progress progress-striped active" style="margin-bottom: 0;">
			<div class="progress-bar" style="width: 100%;"></div>
		</div>
		<h5 style="color:white" > <strong id="msg"></strong> </h5>
	</div>
</div>
<script type="text/javascript">
function showWaiting(msg){
	$("#msg").html(msg);
	$('#loadingModal').modal({backdrop: 'static', keyboard: false});
	$("#loadingModal").modal('show');
}
function hideWaiting(){
	$("#loadingModal").modal('hide');
}
</script>