<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>林业统计分析</title>
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
                <i class="glyphicon intNav actives">统计数据</i>
            </h3>
            <div class="fh pull-right"></div>
        </div>
        <div id="zbgltxShow" class="nrCenter">
            <div class="panel-body" style="padding: 2px 15px;">
                <div class="row">
                    <div class="widget-box">
                        <form class="form-inline">
                            <button type="button" class="btn btn-info btnNew" id="btn-lead"><span class="glyphicon glyphicon-plus"></span>&nbsp;导入excel</button>
                            <button type="button" class="btn btn-info" onclick="downModel()" ><span class="glyphicon glyphicon-arrow-down"></span>&nbsp;下载模板</button>
                            <div class="pull-right col-lg-4">
                                <div class="form-group" style="width: 75%">
                                    <input type="text" id="xmmc_query" placeholder="请输入关键字查询" class="form-control" style="width: 100%">
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
                            <th width="10%">年份</th>
                            <th width="15%">地区</th>
                            <th width="15%">指标</th>
                            <th width="15%">数值</th>
                            <th width="15%">来源</th>
                            <th width="10%">创建时间</th>
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
        window.location.href="/excelmodel/tjsjmodel.xlsx";
    }
</script>
</html>
