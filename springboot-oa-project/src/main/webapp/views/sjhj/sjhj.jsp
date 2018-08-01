<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据汇交预约表</title>
    <link href="/css/control/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/system/tjsj.css">
    <script src="../../js/lib/pagination.js"></script>

</head>
<style>
    input[type=checkbox], input[type=radio]{
        margin: 0;
    }
    table tr th,table tr td{
        text-align: center;
    }
</style>
<body>
<div class="wrapbox">
<div class="list-page">
    <div id="panelPage">
        <div class="panel-heading">
            <h3 class="panel-title">
                <i class="glyphicon intNav actives">数据汇交</i>
            </h3>
            <div class="fh pull-right"></div>
        </div>
        <div id="zbgltxShow" class="nrCenter">
            <div class="panel-body" style="padding: 2px 15px;">
                <div class="row">
                    <div class="widget-box">
                        <form class="form-inline">
                            <button type="button" class="btn btn-info btnNew" id="btn-newObj"><span class="glyphicon glyphicon-plus"></span>&nbsp;新建</button>
                            <button type="button" class="btn btn-info" onclick="downModel()" ><span class="glyphicon glyphicon-arrow-down"></span>&nbsp;导出excel</button>
                            <div class="pull-right col-lg-4">
                                <div class="form-group" style="width: 75%">
                                    <input type="text" id="xmmc_query" placeholder="请输入省份" class="form-control" style="width: 100%">
                                </div>
                                <button class="btn btn-info" id="btn_query" type="button">
                                    <span class="glyphicon glyphicon-search"></span>查询
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table table-hover table-striped table-bordered" id="main_table">
                        <tr>
                            <th width="5%">序号</th>
                            <th width="10%">省区划代码</th>
                            <th width="8%">省份</th>
                            <th width="10%">县区划代码</th>
                            <th width="12%">县名</th>
                            <th width="15%">汇交人员姓名</th>
                            <th width="15%">汇交介质编码</th>
                            <th width="10%">汇交时间</th>
                            <th width="15%">操作</th>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="pull-right modal-pagebody">
                <ul id="tjsj_page" class="pagination pull-right">
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
<%--新建--%>
<div class="modal fade" id="newProject" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document" style="width: 60%;margin-top: 10%">
        <div class="modal-content">
            <div class="modal-header modal-header-pub">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title modal-tit">新建</h4>
            </div>
            <div class="personbox">
                <div class="tab-content user_content">
                    <div class="metadata tab-pane active" id="modal_login">
                        <form class="form-horizontal userInfo" id="login_form">
                            <input type="hidden" name="id" id="sjhj_id" class="form-control"
                                   placeholder="">
                            <div class="form-group">
                                <label for="sjhj_proname" class="control-label col-sm-2"><span class="red">* </span>省份:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="proname" id="sjhj_proname" class="form-control"
                                           placeholder="">
                                </div>
                                <label for="sjhj_provinceCode" class="control-label col-sm-2"><span
                                        class="red">* </span>省代码:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="provinceCode" id="sjhj_provinceCode" class="form-control"
                                           placeholder="">
                                </div>

                            </div>
                            <div class="form-group">
                                <label for="sjhj_cityname" class="control-label col-sm-2"><span class="red">* </span>县名:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="cityname" id="sjhj_cityname" class="form-control"
                                           placeholder="">
                                </div>
                                <label for="sjhj_cityCode" class="control-label col-sm-2">县代码:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="cityCode" id="sjhj_cityCode" class="form-control"
                                           placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sjhj_hjrxmId" class="control-label col-sm-2">汇交人姓名:</label>
                                <div class="col-sm-3">
                                    <select type="text" name="hjrxm" id="sjhj_hjrxmId" class="form-control" placeholder="">
                                        <option value="999999">暂无人员</option>
                                    </select>
                                </div>

                                <label for="sjhj_hjjzdmId" class="control-label col-sm-2"><span class="red">* </span>汇交介质编码:</label>
                                <div class="col-sm-3">
                                    <select type="text" name="hjjzdm" id="sjhj_hjjzdmId" class="form-control" placeholder="">
                                        <option value="999999">暂无编码</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sjhj_bz" class="control-label col-sm-2">备注:</label>
                                <div class="col-sm-8">
                                   <textarea name="bz" id="sjhj_bz" cols="30" rows="5"
                                             class="form-control textareaResize"></textarea>
                                </div>
                            </div>

                            <%--<div class="form-group">--%>
                            <%--<label for="user_createuser" class="control-label col-sm-2">创建人:</label>--%>
                            <%--<div class="col-sm-3">--%>
                            <%--<input type="text" id="user_createuser" class="form-control defaultName"--%>
                            <%--placeholder="" value="">--%>
                            <%--</div>--%>
                            <%--</div>--%>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="sjhj_save">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<%--导入弹的面板--%>
<div class="modal fade" id="lead_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document" style="width: 60%;margin-top: 5%;">
        <div class="modal-content">
            <div class="modal-header modal-header-pub">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="width: 15px"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">导入excel</h4>
            </div>
            <div class="modal-body">
                <form id="uploadForm" enctype="multipart/form-data" >
                    <input type="text" name="id" value= "" style="visibility:hidden"/>
                    <input class="pull-left" type="file" name="file" />
                    <span class="pull-right btn btn-success" id="btn-file">上传</span>&nbsp;
                </form>
            </div>
            <div class="modal-footer">
                <table class="table table-bordered table-striped" id="temp_table">
                    <tr >
                        <th width="5%">序号</th>
                        <th width="10%">年份</th>
                        <th width="20%">地区</th>
                        <th width="15%">指标</th>
                        <th width="15%">数值</th>
                        <th width="15%">来源</th>
                        <th width="20%">创建时间</th>
                    </tr>
                </table>
                <div class="pull-right modal-pagebody">
                    <ul id="temp_page" class="pagination pull-right">
                    </ul>
                </div>
            </div>
            <div class="modal-footer">
                <span class="small-text">请选择上传方式</span>
                <input type="radio" name="method" style="vertical-align: middle" data-id="1" checked/>添加导入
                <input type="radio" name="method"  style="vertical-align: middle" data-id="2"/>覆盖导入
            </div>
            <div class="modal-footer textCenter">
                <button type="button" class="btn btn-primary ftBtn" id="lead_yes">确认导入</button>
                <button type="button" class="btn btn-default ftBtn" id="lead_no" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>





</body>
<script src="../../js/jquery-3.1.1.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/lib/jquery.validate.min.js"></script>
<script src="../../js/lib/pagination.js"></script>
<script src="../../js/lib/bootbox.min.js"></script>
<script src="/js/sjhj/sjhj.js"></script>

<script>
    function downModel(){
        bootbox.confirm({
            message: "导出excel较慢，确定等待？",
            buttons: {
                confirm: {
                    label: '确定',
                    className: 'btn-success'
                },
                cancel: {
                    label: '取消',
                    className: 'btn-danger'
                }
            },
            callback: function (result) {
                if(result){
                    $(this).prop("disabled",true);
                    $.ajax({
                        url: "/sjhj/downloadFile",
                        type: "GET",
                        success: function (res) {
                            if(res.success){
                                var filePath = res.msg;
                                if(filePath != ''){
                                    window.location.href=filePath;
                                }else{
                                    bootbox.alert("导出失败");
                                }
                            }
                        },
                        error:function () {
                            bootbox.alert("导出失败");
                        }

                    });
                    $(this).prop("disabled",false);
                }
            }
            });

    }
</script>
</html>
