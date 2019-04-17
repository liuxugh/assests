<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 模态框（Modal） -->
<div id="rejectModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss = "modal">&times;</button>
            </div>
            <div class="modal-body">
                <div class="modal-body" style="text-align: center;">
                    <div class="row">
                        <div class="form-group" >
                            <span class="col-sm-3 control-label" id="title">驳回意见：</span>
                            <div class="col-md-8">
                                <textarea hidden="hidden" class="form-control" id="idea" name="rejectIdea" placeholder="填写格式：手机号不符合要求" aria-describedby="sizing-addon2"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="hidden" id="modalId">
            </div>
            <div class="modal-footer">
                <div style="text-align: center;">
                    <button class="sbtn sbtn-blue sbtn30" id="rejectYes" >确认</button>
                    <button class="sbtn sbtn-default sbtn30" data-dismiss = "modal" style="margin-left: 45px;">取消</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
function rejectModal(){
	$('#rejectModal').modal('show');
}

</script>
