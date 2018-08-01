<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <link href="/css/control/bootstrap.min.css" rel="stylesheet">
    <link href="/styles/zTreeStyle/zTreeStyle.css" rel="stylesheet">
    <link href="/css/smartMenu.css" rel="stylesheet">
    <link rel="stylesheet" href="../../styles/system/institutional.css">
</head>
<body>
<div class="wrapbox">
<div class="list_page right-content">
        <div class="navBac">
            <div>
                <i class="glyphicon glyphicon-file"
                   style="font-size: 18px;display: inline-block;margin-right: 10px"></i>
                <b style="font-size: 18px">系统管理</b>
                <b> &gt; </b>
                <span>当前位置 :</span>
                <span style="color: #1164c0">菜单管理</span>
            </div>
        </div>
    <div class="row content-body">
        <div class="col-sm-2 left-info">
            <table id="leftTable">
                <tr>
                    <td>
                        <ul id="ztree" class="ztree"></ul>
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-sm-10 right-info">
            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="#basic-information" data-toggle="tab">菜单详情</a></li>
            </ul>
            <div id="tab_list" class="tab-content">
                <div class="metadata tab-pane active" id="basic-information">
                    <form class="form-horizontal" id="menu_form">
                        <div class="form-group">
                            <label for="page_name" class="control-label col-sm-1"><span class="red">* </span>资源名称:</label>
                            <div class="col-sm-4">
                                <input type="text" name="page_name" id="page_name" class="form-control" placeholder="">
                            </div>
                            <label for="page_funcType" class="control-label col-sm-2"><span class="red">* </span>资源类型:</label>
                            <div class="col-sm-4">
                                <select type="text" id="page_funcType" class="form-control" placeholder="">
                                    <option value="0">站点</option>
                                    <option value="1">标题</option>
                                    <option value="2">模块</option>
                                    <option value="3">菜单</option>
                                    <option value="4">按钮</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="page_funcUrl" class="control-label col-sm-1"><span class="red">* </span>资源路径:</label>
                            <div class="col-sm-4">
                                <input type="text" name="page_funcUrl" id="page_funcUrl" class="form-control" placeholder="">
                            </div>
                            <label for="page_classfield" class="control-label col-sm-2">图标:</label>
                            <div class="col-sm-4">
                                <input type="text" id="page_classfield" class="form-control" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="page_funcDesc" class="control-label col-sm-1"><span class="red">* </span>资源序号:</label>
                            <div class="col-sm-4">
                                <input type="text" name="page_funcDesc" id="page_funcDesc" class="form-control" placeholder="">
                            </div>
                            <label for="page_pid" class="control-label col-sm-2">父目录:</label>
                            <div class="col-sm-4">
                                <input type="text" id="page_pid" class="form-control" disabled placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="page_siteId" class="control-label col-sm-1"><span
                                    class="red">* </span>代表站点:</label>
                            <div class="col-sm-4">
                                <select type="text" name="authMode" id="page_siteId" class="form-control" placeholder=""></select>
                            </div>

                        </div>

                    </form>
                </div>
                <div class="textCenter">
                    <shiro:hasPermission name="menu_add">
                        <button type="button" class="btn btn-default" id="menu_btnSave">保存</button>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="menu_cancel">
                         <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                    </shiro:hasPermission>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<%--新建弹出框--%>
<div class="modal fade" id="new_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog myModal-lg" role="document" style="width:64%; margin-top: 5%;">
        <div class="modal-content">
            <div class="modal-header modal-header-pub">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="width: 15px"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新建</h4>
            </div>
            <div class="modal-body">
                <div class="panel">
                    <form class="form-horizontal" id="menu_formMode">

                        <div class="form-group">
                            <label for="menu_name" class="control-label col-sm-1"><span class="red">* </span>资源名称:</label>
                            <div class="col-sm-4">
                                <input type="text" name="menu_name" id="menu_name" class="form-control" placeholder="">
                            </div>
                            <label for="menu_funcType" class="control-label col-sm-2"><span class="red">* </span>资源类型:</label>
                            <div class="col-sm-4">
                                <select type="text" id="menu_funcType" class="form-control" placeholder="">
                                    <option value="0">站点</option>
                                    <option value="1">标题</option>
                                    <option value="2">模块</option>
                                    <option value="3">菜单</option>
                                    <option value="4">按钮</option>
                                </select>
                            </div>
                        </div>
                        <%--<div class="form-group">--%>
                            <%--<label for="menu_func_Code" class="control-label col-sm-2"><span class="red">* </span>资源代码:</label>--%>
                            <%--<div class="col-sm-4">--%>
                                <%--<input type="text" name="menu_func_Code" id="menu_func_Code" class="form-control" placeholder="">--%>
                            <%--</div>--%>
                            <%--<label for="menu_func_Seq" class="control-label col-sm-1"><span class="red">* </span>资源序号:</label>--%>
                            <%--<div class="col-sm-4">--%>
                                <%--<input type="text" name="menu_func_Seq" id="menu_func_Seq" class="form-control" placeholder="">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="form-group">
                            <label for="menu_funcUrl" class="control-label col-sm-1"><span class="red">* </span>资源路径:</label>
                            <div class="col-sm-4">
                                <input type="text" name="menu_funcUrl" id="menu_funcUrl" class="form-control" placeholder="">
                            </div>
                            <label for="menu_classfield" class="control-label col-sm-2">图标:</label>
                            <div class="col-sm-4">
                                <input type="text" id="menu_classfield" class="form-control" placeholder="">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="menu_funcDesc" class="control-label col-sm-1"><span class="red">* </span>资源序号:</label>
                            <div class="col-sm-4">
                                <input type="text" name="menu_funcDesc" id="menu_funcDesc" class="form-control" placeholder="">
                            </div>
                            <label for="menu_pid" class="control-label col-sm-2">父目录:</label>
                            <div class="col-sm-4">
                                <input type="text" id="menu_pid" class="form-control" disabled placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="menu_siteId" class="control-label col-sm-1"><span
                                class="red">* </span>代表站点:</label>
                            <div class="col-sm-4">
                                <select type="text" name="menu_siteId" id="menu_siteId" class="form-control" placeholder=""></select>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer textCenter">
                <button type="button" class="btn btn-default ftBtn" id="modemenu_new">确定</button>
                <button type="button" class="btn btn-primary ftBtn" id="xj_no" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<script src="../../js/lib/jquery-3.2.1.min.js"></script>
<script src="../../js/lib/jquery.ztree.all.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/lib/jquery.validate.min.js"></script>
<script src="../../js/lib/pagination.js"></script>
<script src="../../js/lib/jquery-smartMenu.js"></script>
<script src="../../js/init.js"></script>
<script src="../../js/config.js"></script>
<script src="../../js/lib/bootbox.min.js"></script>
<script src="../../js/system/menu.js"></script>
</body>

</html>
