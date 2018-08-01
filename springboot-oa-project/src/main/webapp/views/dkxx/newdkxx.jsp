<%@ page import="springboot.oa.domain.user.SysUser" %>
<%@ page import="springboot.oa.utils.CommonUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession session2 = request.getSession();
    SysUser user = (SysUser) session2.getAttribute(CommonUtils.SESSION_USER);
    String userName = user.getUserName();
    String userId = user.getId();
    String nickName = user.getNickName();
    String xzdwId = user.getXzdwId();
%>
<html>
<head>
    <title>承包地块信息</title>
    <link href="/css/control/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/system/tjsj.css">
    <script src="../../js/lib/pagination.js"></script>
    <script>
        var userName = "<%=userName%>" === "null" ? null : "<%=userName%>",
            userId = "<%=userId%>" === "null" ? null : "<%=userId%>",
            nickName = "<%=nickName%>" === "null" ? null : "<%=nickName%>";
        xzdwId = "<%=xzdwId%>" === "null" ? null : "<%=xzdwId%>";
    </script>
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
                <i class="glyphicon intNav actives">承包地块信息</i>
            </h3>
            <div class="fh pull-right"></div>
        </div>
        <div id="zbgltxShow" class="nrCenter">
            <div class="panel-body" style="padding: 2px 15px;">
                <div class="row">
                    <div class="widget-box">
                        <form class="form-inline">
                            <button type="button" class="btn btn-info btnNew" id="btn-newObj"><span class="glyphicon glyphicon-plus"></span>&nbsp;新建</button>
                            <%--<button type="button" class="btn btn-info" onclick="downModel()" ><span class="glyphicon glyphicon-arrow-down"></span>&nbsp;导出excel</button>--%>
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
                        <tr >
                            <th width="5%">序号</th>
                            <th width="10%">地块编码</th>
                            <th width="10%">东至信息</th>
                            <th width="10%">西至信息</th>
                            <th width="10%">南至信息</th>
                            <th width="10%">北至信息</th>
                            <th width="15%">承包方名称</th>
                            <th width="15%">权证编码</th>
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
                                <label for="sjhj_dkbm" class="control-label col-sm-2"><span class="red">* </span>地块编码:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="dkbm" id="sjhj_dkbm" class="form-control"
                                           placeholder="">
                                </div>
                                <label for="sjhj_dz" class="control-label col-sm-2"><span
                                        class="red">* </span>东至信息:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="dz" id="sjhj_dz" class="form-control"
                                           placeholder="">
                                </div>

                            </div>
                            <div class="form-group">
                                <label for="sjhj_xz" class="control-label col-sm-2"><span class="red">* </span>西至信息:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="xz" id="sjhj_xz" class="form-control"
                                           placeholder="">
                                </div>
                                <label for="sjhj_nz" class="control-label col-sm-2"><span class="red">* </span>南至信息:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="nz" id="sjhj_nz" class="form-control"
                                           placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sjhj_bz" class="control-label col-sm-2"><span class="red">* </span>北至信息:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="bz" id="sjhj_bz" class="form-control"
                                           placeholder="">
                                </div>

                                <label for="sjhj_cid" class="control-label col-sm-2">承包方名称:</label>
                                <div class="col-sm-3">
                                    <select type="text" name="cid" id="sjhj_cid" class="form-control" placeholder="">
                                        <option value="999999">暂无承包方名称</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sjhj_qzbm" class="control-label col-sm-2">权证编码:</label>
                                <div class="col-sm-3">
                                    <select type="text" name="qzbm" id="sjhj_qzbm" class="form-control" placeholder="">
                                        <option value="999999">暂无权证编码</option>
                                    </select>
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
                        <th width="10%">地块编码</th>
                        <th width="10%">东至信息</th>
                        <th width="15%">西至信息</th>
                        <th width="15%">南至信息</th>
                        <th width="15%">北至信息</th>
                        <th width="15%">承包方名称</th>
                        <th width="15%">权证编码</th>
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
<script src="/js/dkxx/newdkxx.js"></script>

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
