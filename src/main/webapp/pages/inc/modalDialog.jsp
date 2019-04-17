<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" tabindex="-1" role="dialog" id="sodbGlobalModal" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document" style="width:500px;">
        <div class="modal-content">
            <div class="modal-header">
              <!--   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button> -->
                <h4 class="modal-title">提示</h4>
	        </div>
	        <div class="modal-body" id="sodbGlobalModalBody"></div>
	        <div class="modal-footer">
	            <button type="button" id="hideGlobalModalBtn" class="btn btn-primary">确定</button>
	        </div>
        </div>
    </div>
</div><!--禁止掉点击空白关闭和x号-->
<script type="text/javascript">
function showMsg(msg,time){
	$("#sodbGlobalModalBody").html(msg);
	$('#sodbGlobalModal').modal('show')
	if(time != undefined){
	    setTimeout(function(){
	        $("#sodbGlobalModalBody").html('');
	        $('#sodbGlobalModal').modal('hide');
	    },time * 1000)
	}
}
$("#hideGlobalModalBtn").click(function(){
	$("#sodbGlobalModalBody").html('');
    $('#sodbGlobalModal').modal('hide');
})
</script>