<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 模态框（Modal） -->

<div id="editInsuranceModal" class="modal fade">
<form class="form-horizontal" action="" id="editForm" method="post">
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button class="close" data-dismiss = "modal">&times;</button>
        </div>
        <div class="modal-body">
            <div class="modal-body" style="text-align: center;">
                <div class="row">
                    <div class="form-group">
                        <span class="col-sm-4 control-label">保险名称：</span>
                        <div class="col-md-6">
                            <input type="hidden" name="insId" id="insId" value="" />
                            <input type="text" class="form-control" id="insName" name="insName" aria-describedby="sizing-addon2" placeholder="请输入保险名称" />
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-4 control-label">金额：</span>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="insMoney" name="insMoney" aria-describedby="sizing-addon2" placeholder="请输入保险金额" />
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-4 control-label">份额：</span>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="quotient" name="quotient" aria-describedby="sizing-addon2" placeholder="请输入保险份额" />
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-4 control-label">有效期：</span>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="insTime" name="insTime" aria-describedby="sizing-addon2" placeholder="请输入保险有效期" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <div style="text-align: center;">
                <button class="sbtn sbtn-blue sbtn30" id="insYes" >确认</button>
                <button class="sbtn sbtn-default sbtn30" data-dismiss = "modal" style="margin-left: 45px;">取消</button>
            </div>
        </div>
    </div>
</div>
</form>
</div>

<div class="modal fade" id="publicModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">温馨提示：</h4>
            </div>
            <div class="modal-body" id="publicContent">是否发布所选保险?</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="publicYes">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<div class="modal fade" id="expireModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">温馨提示：</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <span class="col-sm-4 control-label">请选择保险到期筛选日：</span>
                    <div class="col-md-8">
                        <select id="maxExpireTime" class="selectpicker show-tick form-control" multiple data-live-search="true" data-live-search-placeholder="Search" data-actions-box="true">
                          <!-- <option selected="selected">2017-09-20</option>
                          <option>2017-10-10</option>
                          <option>2017-11-15</option>
                          <option>2017-12-30</option>
                          <option>2018-03-16</option>
                          <option>2018-04-20</option>
                          <option>2018-05-23</option> -->
                      </select>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="expireYes">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div> 

<div class="modal fade" id="statisticsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">提示：</h4>
            </div>
            <div class="modal-body">
                <div class="form-group" style="height: 20px;">
                    <span class="col-sm-6 control-label" id="titleTip" style="font-size:16px;">请选择保险购买日：</span>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="purchaseTime" name="purchaseTime">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="purchaseYes">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


<script>


function showEditInsModal(insId, insName, insMoney, quotient, insTime){
    $("#insId").val(insId);
    $("#insName").val(insName);
    $("#insMoney").val(insMoney);
    $("#quotient").val(quotient);
    $("#insTime").val(insTime);
    $("#editInsuranceModal").modal('show');
}

function showPublicModal(str){
    $("#publicContent").text(str);
    $("#publicModal").modal('show');
}


 function showExpireModal(){
    $("#expireModal").modal('show');
} 
 
 function showStatisticsModal(str, mark){
	 $("#titleTip").html(str);
	 if(mark == 3){
		 $("#purchaseTime").hide();
	 }else if(mark == 4){
		 $("#purchaseTime").show();
	 }
	 $("#statisticsModal").modal('show');
 }
 
  $("#purchaseTime").datetimepicker({  
     format: 'YYYY-MM-DD',  
     locale: moment.locale('zh-cn'),
 });


</script>
