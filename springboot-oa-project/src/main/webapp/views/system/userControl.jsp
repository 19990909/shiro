<%@ page import="springboot.oa.utils.CommonUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <link href="/css/control/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../styles/system/userControl.css">
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
                <span style="color: #1164c0">用户管理</span>
            </div>
        </div>
        <div class="row control">
            <div class="col-sm-6"  style="padding-left:0px">
                <shiro:hasPermission name="user_add">
                    <button type="button" class="btn btn-primary" id="newObj">新建</button>
                </shiro:hasPermission>
                <shiro:hasPermission name="user_delete">
                    <button type="button" class="btn btn-primary" id="delete">删除</button>
                </shiro:hasPermission>
                <shiro:hasPermission name="user_update">
                    <button type="button" class="btn btn-primary" id="amend">修改</button>
                </shiro:hasPermission>
                <shiro:hasPermission name="user_authorize">
                    <button type="button" class="btn btn-primary" id="user_limits">用户授权</button>
                </shiro:hasPermission>
            </div>
            <div class="col-sm-6 text-right">
                <shiro:hasPermission name="user_select">
                    <input type="text" placeholder="请输入搜索的用户名称" id="search"><%--
            --%>
                    <button type="button" class="btn  btn-primary w70" id="user_search"><img
                            src="/images/search.png" alt="">
                    </button>
                </shiro:hasPermission>
            </div>
            <div class="control-modal" style="display: none">
                <form class="form-horizontal" id="high_form">
                    <div class="form-group">
                        <label for="username" class="control-label col-sm-1 ">用户登录名:</label>
                        <div class="col-sm-2">
                            <input type="text" id="username" class="form-control" placeholder="用户登录名">
                        </div>
                        <label for="nickName" class="control-label col-sm-1 ">用户名称:</label>
                        <div class="col-sm-2 ">
                            <input type="text" id="nickName" class="form-control" placeholder="用户名称">
                        </div>
                        <label for="authMode" class="control-label col-sm-1 ">认证模式:</label>
                        <div class="col-sm-2 ">
                            <input type="text" id="authMode" class="form-control" placeholder="认证模式">
                        </div>
                        <div class="col-sm-2 pull-right text-right">
                            <button type="button" class="btn btn-primary" id="high_query">确定</button>
                            <button type="reset" class="btn btn-default" id="high_clear">清除</button>
                        </div>
                    </div>
                </form>
                <div class="modal-footer">
                <span id="packUp" class="glyphicon glyphicon-chevron-up text-center">
                </span>
                </div>
            </div>
        </div>
        <div class="panel pan"></div>
        <table class="table table-striped table-hover table-bordered" id="userTab">
            <tbody>
            <tr>
                <th width="8%" class="text-center">
                    <input type="checkbox" class="checkAll">全选
                </th>
                <th width="7%" class="text-center">序号</th>
                <th width="15%" class="text-center">用户名</th>
                <th width="10%" class="text-center">姓名</th>
                <th width="10%" class="text-center">用户类型</th>
                <th width="20%" class="text-center">地址</th>
                <th width="15%" class="text-center">创建时间</th>
                <th width="10%" class="text-center">创建人</th>
                <th width="10%" class="text-center">用户状态</th>
            </tr>
            </tbody>
        </table>
        <div class="pull-right pagebody">
            <ul id="user_page" class="pagination pull-right"></ul>
        </div>
    </div>
</div>



<%--新建模态框--%>
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
                            <div class="form-group">

                                <label for="user_userName" class="control-label col-sm-2"><span class="red">* </span>用户名:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="userName" id="user_userName" class="form-control"
                                           placeholder="">
                                </div>
                                <label for="user_password" class="control-label col-sm-2"><span
                                        class="red">* </span>密码:</label>
                                <div class="col-sm-3">
                                    <input type="password" name="password" id="user_password" class="form-control"
                                           placeholder="">
                                </div>

                            </div>
                            <div class="form-group">
                                <label for="user_nickName" class="control-label col-sm-2"><span class="red">* </span>真实姓名:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="nickName" id="user_nickName" class="form-control"
                                           placeholder="">
                                </div>
                                <label for="user_tel" class="control-label col-sm-2">联系电话:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="tel" id="user_tel" class="form-control"
                                           placeholder="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="user_address" class="control-label col-sm-2">用户地址:</label>
                                <div class="col-sm-3">
                                    <input type="text" name="address" id="user_address" class="form-control"
                                           placeholder="">
                                </div>

                                <label for="user_userType" class="control-label col-sm-2"><span class="red">* </span>用户类型:</label>
                                <div class="col-sm-3">
                                    <select type="text" id="user_userType" class="form-control" placeholder="">
                                        <option value="1">内部人员</option>
                                        <option value="2">注册用户</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="user_xzdwId" class="control-label col-sm-2"><span class="red">* </span>行政单位:</label>
                                <div class="col-sm-3">
                                    <select type="text" id="user_xzdwId" class="form-control" placeholder="">
                                        <option value="100000">国家部级</option>
                                        <option value="230000">黑龙江省</option>
                                        <option value="230100">哈尔滨市</option>
                                        <option value="230800">佳木斯市</option>
                                        <option value="370000">山东省</option>
                                        <option value="370100">济南市</option>
                                        <option value="370200">青岛市</option>
                                    </select>
                                </div>
                                <label for="user_status" class="control-label col-sm-2">用户状态:</label>
                                <div class="col-sm-3">
                                    <select type="text" id="user_status" class="form-control" placeholder="">
                                        <option value="1">正常</option>
                                        <option value="0">停用</option>
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
                <button type="button" class="btn btn-primary" id="user_save">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<%--用户授权--%>
<div class="modal fade jurisdiction" id="jurisdiction" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document" style="width: 40%;margin-top: 10%">
        <div class="modal-content">
            <div class="modal-header modal-header-pub">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">用户权限</h4>
            </div>
            <div class="content">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-5">
                            <div class="user_left">
                                <p class="user_tit">
                                    <span>已授予角色</span>
                                </p>
                                <ul class="user_boxLeft"></ul>
                            </div>
                        </div>
                        <div class="col-xs-2 user-center">
                            <%--<div class="from-group">
                                <button class="btn btn-default form-control" type="button" id="role_cancel">></button>
                            </div>--%>
                            <div class="from-group">
                                <button class="btn btn-default form-control" type="button" id="role_Allcancel">>>
                                </button>
                            </div>
                            <%--  <div class="from-group">
                                  <button class="btn btn-default form-control" type="button" id="role_impower"><</button>
                              </div>--%>
                            <div class="from-group">
                                <button class="btn btn-default form-control" type="button" id="role_Allimpower"><<
                                </button>
                            </div>
                            <div class="from-group">
                                <button class="btn  btn-default form-control" type="button" id="role_Btnsave">保存
                                </button>
                            </div>
                        </div>
                        <div class="col-xs-5">
                            <div class="user_right">
                                <p class="user_tit">
                                    <span>未授予角色</span>
                                </p>
                                <ul class="user_boxRight"></ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script src="../../js/jquery-3.1.1.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/lib/jquery.validate.min.js"></script>
<script src="../../js/lib/pagination.js"></script>
<script src="../../js/init.js"></script>
<script src="../../js/config.js"></script>
<script src="../../js/lib/bootbox.min.js"></script>

<script src="../../js/system/userControl.js"></script>
</html>
