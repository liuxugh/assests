<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" tabindex="-1" role="dialog" id="changePwdModal" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width:500px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">提示</h4>
	        </div>
	        <div class="modal-body" id="changePwdBody"></div>
	        <div class="modal-footer">
	            <button type="button" id="changePwdBtn" class="btn btn-primary">确定</button>
	        </div>
        </div>
    </div>
</div>
<script type="text/javascript">
function changePwd(msg,time){
	$("#changePwdBody").html(msg);
	$('#changePwdModal').modal({backdrop: 'static', keyboard: false});
	if(time != undefined){
	    setTimeout(function(){
	        $("#changePwdBody").html('');
	        $('#changePwdModal').modal('hide');
	    },time * 1000)
	}
}


$("#changePwdBtn").click(function(){
	$("#changePwdBody").html('');
    $('#changePwdModal').modal('hide');
    top.location.href = '<c:url value="/loginPage" />';
})
$(".close").click(function(){
	$('#changePwdModal').modal('hide');
})
</script>