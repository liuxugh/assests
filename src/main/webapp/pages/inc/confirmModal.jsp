<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 模态框（Modal） -->
<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">温馨提示：</h4>
            </div>
            <div class="modal-body">是否删除选中数据?</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="yes">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<script>
function confirmModal(str){
	$(".modal-body").html(str);
	$('#confirmModal').modal('show');
}
</script>
