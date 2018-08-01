<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="../../styles/system/roleManage.css">
    <link href="/styles/zTreeStyle/zTreeStyle.css" rel="stylesheet">
    <link href="/css/control/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="wrapbox">
<div class="right-content">
    <div class="navBac">
        <div>
            <i class="glyphicon glyphicon-file" style="font-size: 18px;display: inline-block;margin-right: 10px"></i>
            <b style="font-size: 18px">系统管理</b>
            <b> &gt; </b>
            <span>当前位置 :</span>
            <span style="color: #1164c0">角色管理</span>
        </div>
    </div>
    <div class="row control">
        <div class="col-sm-6">
            <shiro:hasPermission name="role_add">
                <button type="button" class="btn btn-primary" id="newObj">新建</button>
            </shiro:hasPermission>
            <shiro:hasPermission name="role_delete">
                <button type="button" class="btn btn-primary" id="role_delete">删除</button>
            </shiro:hasPermission>
            <shiro:hasPermission name="role_update">
                <button type="button" class="btn btn-primary" id="modification">修改</button>
            </shiro:hasPermission>
            <shiro:hasPermission name="role_authorize">
                <button type="button" class="btn btn-primary" id="role">角色授权</button>
            </shiro:hasPermission>
        </div>
        <div class="col-sm-6 text-right">
            <shiro:hasPermission name="role_select"> <input type="text" placeholder="请输入角色名称" name="searchLike"
                                                            id="search"><%--
            --%>
                <button type="button" class="btn  btn-primary w70" id="role_search"><img
                        src="/images/search.png" alt="">
                </button>
            </shiro:hasPermission>
            </form>
            <%--<div class="modal-footer">--%>
                <%--<span id="packUp" class="glyphicon glyphicon-chevron-up text-center">--%>
                <%--</span>--%>
            <%--</div>--%>
        </div>
    </div>

    <div class="pageTable">
        <table class="table table-striped table-hover table-bordered" id="roleTab">
            <tbody>
            <tr>
                <th class="text-center">
                    <input type="checkbox" class="checkAll">全选
                </th>
                <th class="text-center">序号</th>
                <th class="text-center">角色代码</th>
                <th class="text-center">角色名称</th>
                <th class="text-center">所属站点</th>
                <th class="text-center">创建人</th>
            </tr>
            </tbody>
        </table>
        <div class="pull-right pagebody">
            <ul id="role_page" class="pagination pull-right"></ul>
        </div>
    </div>
</div>
</div>

<%--新建模态框--%>
<div class="modal fade" id="newProject" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document" style="width:55%;margin-top: 10%">
        <div class="modal-content">
            <div class="modal-header bg-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">新建</h4>
            </div>
            <div class="content">
                <div class="modal-body">
                    <form class="form-horizontal" id="new_info">
                        <div class="form-group">
                            <label for="role_roleCode" class="control-label col-sm-2"><span
                                    class="red">* </span>角色代码:</label>
                            <div class="col-sm-3">
                                <input type="text" name="roleCode" id="role_roleCode" class="form-control"
                                       placeholder="">
                            </div>
                            <label for="role_roleName" class="control-label col-sm-2"><span
                                    class="red">* </span>角色名称:</label>
                            <div class="col-sm-3">
                                <input type="text" name="roleName" id="role_roleName" class="form-control"
                                       placeholder="">
                            </div>

                        </div>
                        <div class="form-group">
                            <label for="role_siteId" class="control-label col-sm-2"><span
                            class="red">* </span>代表系统:</label>
                            <div class="col-sm-3">
                            <select type="text" name="siteId" id="role_siteId" class="form-control" placeholder=""></select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="role_roleBz" class="control-label col-sm-2">角色描述:</label>
                            <div class="col-sm-9">
                                <textarea name="roleBz" id="role_roleBz" cols="30" rows="5"
                                          class="form-control textareaResize"></textarea>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="role_saveRole">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

<%--角色管理--%>
<div class="modal fade" id="role-management" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document" style="width:60%;margin-top: 10%">
        <div class="modal-content">
            <div class="modal-header bg-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">角色授权</h4>
            </div>
            <div class="content">
                <div class="modal-body role_content">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="#func-resource" data-toggle="tab" id="tit_Role">功能资源</a>
                        </li>
                        <%--<li role="presentation"><a href="#ser-resource" data-toggle="tab" id="tit_Sever">服务资源</a></li>--%>
                    </ul>
                    <div class="tab-content">
                        <div class="metadata tab-pane active" id="func-resource">
                            <div id="resource-cont">
                                <div id="roleztree" class="ztree"></div>
                            </div>
                        </div>
                        <%--<div class="condition tab-pane " id="ser-resource">--%>
                            <%--<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">--%>
                                <%--<div class="panel panel-default">--%>
                                    <%--<div class="panel-heading source_heading" role="tab" id="headingOne">--%>
                                        <%--<h4 class="panel-title">--%>
                                            <%--<a role="button" data-toggle="collapse" href="#collapseOne"--%>
                                               <%--aria-expanded="true" aria-controls="collapseOne">--%>
                                                <%--数据资源--%>
                                            <%--</a>--%>
                                        <%--</h4>--%>
                                    <%--</div>--%>
                                    <%--<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"--%>
                                         <%--aria-labelledby="headingOne">--%>
                                        <%--<div class="panel-body">--%>
                                            <%--<div id="ztree_0" class="ztree"></div>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<div class="panel panel-default">--%>
                                    <%--<div class="panel-heading source_heading" role="tab" id="headingTwo">--%>
                                        <%--<h4 class="panel-title">--%>
                                            <%--<a class="collapsed" role="button" data-toggle="collapse"--%>
                                               <%--href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">--%>
                                                <%--地图服务--%>
                                            <%--</a>--%>
                                        <%--</h4>--%>
                                    <%--</div>--%>
                                    <%--<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"--%>
                                         <%--aria-labelledby="headingTwo">--%>
                                        <%--<div class="panel-body">--%>
                                            <%--<div id="ztree_1" class="ztree"></div>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<div class="panel panel-default">--%>
                                    <%--<div class="panel-heading source_heading" role="tab" id="headingThree">--%>
                                        <%--<h4 class="panel-title">--%>
                                            <%--<a class="collapsed" role="button" data-toggle="collapse"--%>
                                               <%--href="#collapseThree" aria-expanded="false"--%>
                                               <%--aria-controls="collapseThree">--%>
                                                <%--数据挂载--%>
                                            <%--</a>--%>
                                        <%--</h4>--%>
                                    <%--</div>--%>
                                    <%--<div id="collapseThree" class="panel-collapse collapse" role="tabpanel"--%>
                                         <%--aria-labelledby="headingThree">--%>
                                        <%--<div class="panel-body">--%>
                                            <%--<div id="ztree_2" class="ztree"></div>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<div class="panel panel-default">--%>
                                    <%--<div class="panel-heading source_heading" role="tab" id="headingFour">--%>
                                        <%--<h4 class="panel-title">--%>
                                            <%--<a class="collapsed" role="button" data-toggle="collapse"--%>
                                               <%--href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">--%>
                                                <%--组件管理--%>
                                            <%--</a>--%>
                                        <%--</h4>--%>
                                    <%--</div>--%>
                                    <%--<div id="collapseFour" class="panel-collapse collapse" role="tabpanel"--%>
                                         <%--aria-labelledby="headingThree">--%>
                                        <%--<div class="panel-body">--%>
                                            <%--<div id="ztree_3" class="ztree"></div>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    </div>
                </div>
            </div>
            <div class="modal-footer textCenter">
                <button type="button" class="btn btn-primary" id="tree_save">保存</button>
                <button type="button" class="btn btn-primary none" id="server_save">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="../../js/lib/jquery-3.2.1.min.js"></script>
<script src="../../js/lib/jquery.ztree.all.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/lib/bootbox.min.js"></script>
<script src="../../js/lib/pagination.js"></script>
<script src="../../js/lib/jquery.validate.min.js"></script>
<script src="../../js/init.js"></script>
<script src="../../js/config.js"></script>
<script src="../../js/system/roleManage.js"></script>
</html>
