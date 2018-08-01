<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../styles/system/institutional.css">
</head>
<body>

<div class="right-content">
    <div class="navBac">
        <div class="col-sm-12">
            <i class="glyphicon glyphicon-file" style="font-size: 18px;display: inline-block;margin-right: 10px"></i>
            <b style="font-size: 18px">系统管理</b>
            <b> &gt; </b>
            <span>当前位置 :</span>
            <span style="color: #1164c0">组织机构</span>
        </div>
    </div>
    <div class="row content-body">
        <div class="col-sm-2 left-info">
            <table id="leftTable">
                <tr>
                    <td>
                        <ul id="tree" class="ztree"></ul>
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-sm-10 right-info">
            <ul class="nav nav-tabs">
                <li role="presentation" class="active" id="nav_leavel"><a href="#institution_b" data-toggle="tab">本级机构</a></li>
                <li role="presentation" id="nav_subordinate"><a href="#institution_x" data-toggle="tab">下级机构</a></li>
                <li role="presentation" id="nav_relevance"><a href="#institution_user" data-toggle="tab">关联用户</a></li>
            </ul>
            <div id="tab_list" class="tab-content">
                <div class="metadata tab-pane active" id="institution_b">
                    <form class="form-horizontal sub-tab" id="nature_org">
                        <div class="form-group">
                            <label for="name" class="control-label col-sm-2"><span class="red">* </span>机构名称:</label>
                            <div class="col-sm-4">
                                <input type="text" id="name" class="form-control" placeholder="" name="name">
                            </div>
                            <label for="orgCode" class="control-label col-sm-1"><span class="red">* </span>机构代码:</label>
                            <div class="col-sm-4">
                                <input type="text" id="orgCode" class="form-control" placeholder="" name="orgCode">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pidName" class="control-label col-sm-2"><span class="red">* </span>上级机构:</label>
                            <div class="col-sm-4">
                                <input type="text" id="pidName" class="form-control" placeholder="" >
                            </div>
                            <label for="orgType" class="control-label col-sm-1"><span class="red">* </span>机构类型:</label>
                            <div class="col-sm-4">
                                <select type="text" id="orgType" class="form-control" name="orgType">
                                    <option value="私营">私营</option>
                                    <option value="国企">国企</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="orgDegree" class="control-label col-sm-2"><span class="red">* </span>机构等级:</label>
                            <div class="col-sm-4">
                                <select type="text" id="orgDegree" class="form-control" name="orgDegree">
                                    <option value="一级">一级</option>
                                    <option value="二级">二级</option>
                                </select>
                            </div>
                            <label for="status" class="control-label col-sm-1"><span class="red">* </span>机构状态:</label>
                            <div class="col-sm-4">
                                <select type="text" id="status" class="form-control" name="status">
                                    <option value="运营">运营</option>
                                    <option value="非运营">非运营</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="orgManager" class="control-label col-sm-2"><span class="red">* </span>机构负责人:</label>
                            <div class="col-sm-4">
                                <input type="text" id="orgManager" class="form-control" placeholder="" name="orgManager">
                            </div>
                            <label for="area" class="control-label col-sm-1">所属地域:</label>
                            <div class="col-sm-4">
                                <input type="text" id="area" class="form-control" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="orgAddr" class="control-label col-sm-2">机构地址:</label>
                            <div class="col-sm-4">
                                <input type="text" id="orgAddr" class="form-control" placeholder="">
                            </div>
                            <label for="zipCode" class="control-label col-sm-1">邮编:</label>
                            <div class="col-sm-4">
                                <input type="text" id="zipCode" class="form-control" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="linkMan" class="control-label col-sm-2"><span class="red">* </span>联系人:</label>
                            <div class="col-sm-4">
                                <input type="text" id="linkMan" class="form-control" placeholder="" name="linkMan">
                            </div>
                            <label for="linkTel" class="control-label col-sm-1"><span class="red">* </span>联系电话:</label>
                            <div class="col-sm-4">
                                <input type="tel" id="linkTel" class="form-control" placeholder="" name="linkTel">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="control-label col-sm-2">电子邮件:</label>
                            <div class="col-sm-4">
                                <input type="email" id="email" class="form-control" placeholder="">
                            </div>
                            <label for="sortNo" class="control-label col-sm-1"><span class="red">* </span>排列顺序:</label>
                            <div class="col-sm-4">
                                <input type="text" id="sortNo" class="form-control" placeholder="" name="sortNo">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="startDate" class="control-label col-sm-2">生效日期:</label>
                            <div class="col-sm-4">
                                <input type="text" id="startDate" class="form-control choose-date input-date"
                                       placeholder="">
                            </div>
                            <label for="endDate" class="control-label col-sm-1">失效日期:</label>
                            <div class="col-sm-4">
                                <input type="text" id="endDate" class="form-control choose-date input-date"
                                       placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="remark" class="control-label col-sm-2">备注:</label>
                            <div class="col-sm-9">
                                <textarea name="" id="remark" cols="30" rows="5" class="form-control"></textarea>
                            </div>
                        </div>
                    </form>
                    <div class="modal-footer textCenter">
                        <button type="button" class="btn btn-default ftBtn" id="xg_btnSure" >确定</button>
                        <button type="button" class="btn btn-primary ftBtn" id="xg_btnCacle" data-dismiss="modal">取消</button>
                    </div>
                </div>
                <div class="condition tab-pane clearfix" id="institution_x">
                    <form class="form-horizontal">
                        <div class="row control">
                            <div class="pull-right text-right">
                                <input type="text" class="form-control query" placeholder="请输入搜索内容" id="search_text"><%--
                                --%>
                                <button id="searchDown" type="button" class="btn  btn-primary w70"><img
                                        src="../../styles/images/search.png" alt=""></button>
                                <%--<button type="button" class="btn btn-success" id="subsidiaries-query">高级查询</button>--%>
                            </div>
                        </div>
                        <div class="control-modal none subsidiaries-modal">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="subsidiaries_dlmc" class="control-label col-sm-2">用户登录名:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" placeholder="用户名.." id="subsidiaries_dlmc">
                                    </div>
                                    <label for="subsidiaries_zybm" class="control-label col-sm-2 ">用户名称:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" placeholder="名称.." id="subsidiaries_zybm">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="subsidiaries_zymc" class="control-label col-sm-2">认证模式:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" placeholder="名称.." id="subsidiaries_zymc">
                                    </div>
                                    <div class="col-sm-3 pull-right text-right">
                                        <button type="button" class="btn btn-primary">确定</button>
                                        <button type="reset" class="btn btn-default">清除</button>
                                    </div>
                                </div>
                            </form>
                            <div class="modal-footer modal_toggle">
                                <span class="glyphicon glyphicon-chevron-up text-center packUp"></span>
                            </div>
                        </div>
                        <table class="table table-striped table-hover table-bordered">
                            <tbody>
                            <tr>
                                <th class="text-center">序号</th>
                                <th class="text-center">机构名称</th>
                                <th class="text-center">机构代码</th>
                                <th class="text-center">上级机构</th>
                                <th class="text-center">机构等级</th>
                                <th class="text-center">机构状态</th>
                                <th class="text-center">建立时间</th>
                                <th class="text-center">备注</th>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                    <div class="pull-right subsidiaries-pagebody">
                        <ul id="subsidiaries_page" class="pagination pull-right"></ul>
                    </div>
                </div>
                <div class="condition tab-pane" id="institution_user">
                    <form class="form-horizontal">
                        <div class="row pad-15">
                            <div class="pull-right text-right">
                                <input type="text" class="form-control query" placeholder="请输入搜索内容" id="search"><%--
                                --%>
                                <button id="releBtn" type="button" class="btn btn-primary w70"><img
                                        src="../../styles/images/search.png" alt=""></button>
                                <%--<button type="button" class="btn btn-success" id="users-query">高级查询</button>--%>
                            </div>
                        </div>
                        <div class="control-modal none users-modal">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="use_dlmc" class="control-label col-sm-2">用户登录名:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" placeholder="用户名.." id="use_dlmc">
                                    </div>
                                    <label for="use_zybm" class="control-label col-sm-2 ">用户名称:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" placeholder="名称.." id="use_zybm">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="use_zymc" class="control-label col-sm-2">认证模式:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" placeholder="名称.." id="use_zymc">
                                    </div>
                                    <div class="col-sm-3 pull-right text-right">
                                        <button type="button" class="btn btn-primary">确定</button>
                                        <button type="reset" class="btn btn-default">清除</button>
                                    </div>
                                </div>
                            </form>
                            <div class="modal-footer modal_toggle">
                                <span class="glyphicon glyphicon-chevron-up text-center packUp"></span>
                            </div>
                        </div>
                        <table class="table table-striped table-hover table-bordered">
                            <tbody>
                            <tr>
                                <th class="text-center">序号</th>
                                <th class="text-center">用户登录名</th>
                                <th class="text-center">用户名称</th>
                                <th class="text-center">认证模式</th>
                                <th class="text-center">用户状态</th>
                                <th class="text-center">手机号</th>
                                <th class="text-center">创建人</th>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                    <div class="pull-right pagebody">
                        <ul id="org_page" class="pagination pull-right"></ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--新建目录弹出框--%>
<div class="modal fade" id="xj_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog myModal-lg" role="document" style="width:64%; margin-top: 5%;">
        <div class="modal-content">
            <div class="modal-header modal-header-pub">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="width: 15px"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新建目录</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal sub-tab" id="createOrga">
                    <div class="form-group">
                        <label for="name_1" class="control-label col-sm-2"><span class="red">* </span>机构名称:</label>
                        <div class="col-sm-4">
                            <input type="text" id="name_1" class="form-control" name="name_1" placeholder="">
                        </div>
                        <label for="orgCode_1" class="control-label col-sm-1"><span class="red">* </span>机构代码:</label>
                        <div class="col-sm-4">
                            <input type="text" id="orgCode_1" class="form-control" name="orgCode_1" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pidName_1" class="control-label col-sm-2"><span class="red">* </span>上级机构:</label>
                        <div class="col-sm-4">
                            <input type="text" id="pidName_1" class="form-control" placeholder="" disabled>
                        </div>
                        <label for="orgType_1" class="control-label col-sm-1"><span class="red">* </span>机构类型:</label>
                        <div class="col-sm-4">
                            <select type="text" id="orgType_1" class="form-control" name="orgType_1">
                                <option value="私营">私营</option>
                                <option value="国企">国企</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="orgDegree_1" class="control-label col-sm-2"><span class="red">* </span>机构等级:</label>
                        <div class="col-sm-4">
                            <select type="text" id="orgDegree_1" class="form-control" name="orgDegree_1">
                                <option value="一级">一级</option>
                                <option value="二级">二级</option>
                            </select>
                        </div>
                        <label for="status_1" class="control-label col-sm-1"><span class="red">* </span>机构状态:</label>
                        <div class="col-sm-4">
                            <select type="text" id="status_1" class="form-control" name="status_1">
                                <option value="运营">运营</option>
                                <option value="非运营">非运营</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="orgManager_1" class="control-label col-sm-2"><span class="red">* </span>机构负责人:</label>
                        <div class="col-sm-4">
                            <input type="text" id="orgManager_1" class="form-control" placeholder="" name="orgManager_1">
                        </div>
                        <label for="area_1" class="control-label col-sm-1">所属地域:</label>
                        <div class="col-sm-4">
                            <input type="text" id="area_1" class="form-control" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="orgAddr_1" class="control-label col-sm-2">机构地址:</label>
                        <div class="col-sm-4">
                            <input type="text" id="orgAddr_1" class="form-control" placeholder="">
                        </div>
                        <label for="zipCode_1" class="control-label col-sm-1">邮编:</label>
                        <div class="col-sm-4">
                            <input type="text" id="zipCode_1" class="form-control" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="linkMan_1" class="control-label col-sm-2"><span class="red">* </span>联系人:</label>
                        <div class="col-sm-4">
                            <input type="text" id="linkMan_1" class="form-control" placeholder="" name="linkMan_1">
                        </div>
                        <label for="linkTel_1" class="control-label col-sm-1"><span class="red">* </span>联系电话:</label>
                        <div class="col-sm-4">
                            <input type="tel" id="linkTel_1" class="form-control" placeholder="" name="linkTel_1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_1" class="control-label col-sm-2">电子邮件:</label>
                        <div class="col-sm-4">
                            <input type="email" id="email_1" class="form-control" placeholder="">
                        </div>
                        <label for="sortNo_1" class="control-label col-sm-1"><span class="red">* </span>排列顺序:</label>
                        <div class="col-sm-4">
                            <input type="text" id="sortNo_1" class="form-control" placeholder="" name="sortNo_1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="startDate_1" class="control-label col-sm-2">生效日期:</label>
                        <div class="col-sm-4">
                            <input type="text" id="startDate_1" name="startDate_1" class="form-control choose-date input-date"
                                   placeholder="">
                        </div>
                        <label for="endDate_1" class="control-label col-sm-1">失效日期:</label>
                        <div class="col-sm-4">
                            <input type="text" id="endDate_1" name="endDate_1" class="form-control choose-date input-date"
                                   placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="remark_1" class="control-label col-sm-2">备注:</label>
                        <div class="col-sm-9">
                            <textarea name="" id="remark_1" cols="30" rows="5" class="form-control"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer textCenter">
                <button type="button" class="btn btn-default ftBtn" id="xj_yes" >确定</button>
                <button type="button" class="btn btn-primary ftBtn" id="xj_no" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

<%--增加机构员工--%>
<div class="modal fade" id="organization_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog myModal-lg" role="document" style="width:60%; margin-top: 5%;">
        <div class="modal-content">
            <div class="modal-header modal-header-pub">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="width: 15px"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加机构员工</h4>
            </div>
            <div class="modal-body">
                <div id="organization_list">
                    <div class="condition tab-pane clearfix">
                        <div class="row pad-15">
                            <div class="pull-right text-right">
                                <input type="text" class="form-control query" placeholder="请输入搜索内容" id="search_staff"><%--
                                --%>
                                <button id="staffBtn" type="button" class="btn  btn-primary w70"><img
                                        src="../../styles/images/search.png" alt=""></button>
                                <%--<button type="button" class="btn btn-success " id="modal-query" >高级查询</button>--%>
                                <button type="button" class="btn btn-primary" id="btn-save">保存</button>
                            </div>
                        </div>
                        <div class="control-modal none modal-box">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="staff_dlmc" class="control-label col-sm-2">用户登录名:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" placeholder="用户名.." id="staff_dlmc">
                                    </div>
                                    <label for="staff_zybm" class="control-label col-sm-2 ">用户名称:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" placeholder="名称.." id="staff_zybm">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <label for="staff_zymc" class="control-label col-sm-2">认证模式:</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" placeholder="名称.." id="staff_zymc">
                                    </div>
                                    <div class="col-sm-3 pull-right text-right">
                                        <button type="button" class="btn btn-primary">确定</button>
                                        <button type="reset" class="btn btn-default">清除</button>
                                    </div>
                                </div>
                            </form>
                            <div class="modal-footer modal_toggle">
                                <span class="glyphicon glyphicon-chevron-up text-center packUp"></span>
                            </div>
                        </div>
                        <table class="table table-striped table-hover table-bordered" id="tabUser">
                            <tbody>
                            <tr>
                                <th class="text-center">全选</th>
                                <th class="text-center">序号</th>
                                <th class="text-center">登录名称</th>
                                <th class="text-center">真实姓名</th>
                                <th class="text-center">认证模式</th>
                                <th class="text-center">用户状态</th>
                                <th class="text-center">用户类型</th>
                                <th class="text-center">创建人</th>
                                <th class="text-center">创建时间</th>
                            </tr>
                            </tbody>
                        </table>
                        <div class="pull-right modal-pagebody">
                            <ul id="user_page" class="pagination pull-right">
                        </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../js/system/institutional.js"></script>
</body>
</html>
