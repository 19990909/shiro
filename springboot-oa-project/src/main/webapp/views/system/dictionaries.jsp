<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../styles/system/institutional.css">
</head>
<body>
<div class="list_page right-content">
        <div class="navBac">
            <div>
                <i class="glyphicon glyphicon-file"
                   style="font-size: 18px;display: inline-block;margin-right: 10px"></i>
                <b style="font-size: 18px">系统管理</b>
                <b> &gt; </b>
                <span>当前位置 :</span>
                <span style="color: #1164c0">字典管理</span>
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
            <table class="table table-striped table-hover table-bordered" id="diction_table">
                <tbody>
                <tr>
                    <th class="text-center">序号</th>
                    <th class="text-center">名称</th>
                    <th class="text-center">编码</th>
                    <th class="text-center">所在目录</th>
                    <th class="text-center">类别</th>
                    <th class="text-center">操作</th>
                </tr>

                </tbody>
            </table>
            <div class="pull-right modal-pagebody">
                <ul id="dictionaries_page" class="pagination pull-right">
                </ul>
            </div>
        </div>
    </div>
</div>
<form id="uploadForm" enctype="multipart/form-data" style="display: none">
    <input type="text" id="p_id" name="pid" />
    <input type="file" id="file" name="file"/>
</form>



<%--新建弹出框--%>
<div class="modal fade" id="new_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document" style="margin-top: 10%;">
        <div class="modal-content">
            <div class="modal-header modal-header-pub">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="width: 15px"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新建字典</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal sub-tab" id="xj_valida">
                    <div class="form-group">
                        <label for="name" class="control-label col-sm-2 "><span class="red">* </span>名称:</label>
                        <div class="col-sm-9">
                            <input type="text" id="name" class="form-control" placeholder="" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="zdxbm" class="control-label col-sm-2"><span class="red">* </span>编码:</label>
                        <div class="col-sm-9">
                            <input type="text" id="zdxbm" class="form-control" placeholder="" name="zdxbm">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pid" class="control-label col-sm-2"><span class="red">* </span>所属目录:</label>
                        <div class="col-sm-9">
                            <input type="text" id="pid" class="form-control" placeholder="" disabled>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="zdlb" class="control-label col-sm-2"><span class="red">* </span>字典类别:</label>
                        <div class="col-sm-9">
                            <select type="text" id="zdlb" class="form-control" name="zdlb">
                                <%--<option value="1">目录</option>--%>
                                <%--<option value="2">字典</option>--%>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="remark" class="control-label col-sm-2">描述:</label>
                        <div class="col-sm-9">
                            <textarea  id="remark" cols="30" rows="5" class="form-control textareaResize"></textarea>
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
<%--编辑弹出框--%>
<div class="modal fade" id="change_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document" style="margin-top: 10%;">
        <div class="modal-content">
            <div class="modal-header modal-header-pub">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="width: 15px"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">编辑字典</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal sub-tab" id="bj_valida">
                    <div class="form-group">
                        <label for="name_c" class="control-label col-sm-2 "><span class="red">* </span>名称:</label>
                        <div class="col-sm-9">
                            <input type="text" id="name_c" class="form-control" name="name_c">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="zdxbm_c" class="control-label col-sm-2"><span class="red">* </span>编码:</label>
                        <div class="col-sm-9">
                            <input type="text" id="zdxbm_c" class="form-control" name="zdxbm_c">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pid_c" class="control-label col-sm-2"><span class="red">* </span>所属目录:</label>
                        <div class="col-sm-9">
                            <input type="text" id="pid_c" class="form-control"  disabled name="pid_c">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="zdlb_c" class="control-label col-sm-2"><span class="red">* </span>类别:</label>
                        <div class="col-sm-9">
                            <select type="text" id="zdlb_c" class="form-control" name="zdlb_c">
                                <%--<option value="目录">目录</option>--%>
                                <%--<option value="字典">字典</option>--%>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="remark_c" class="control-label col-sm-2">描述:</label>
                        <div class="col-sm-9">
                            <textarea  id="remark_c" cols="30" rows="5" class="form-control textareaResize"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer textCenter">
                <button type="button" class="btn btn-default ftBtn" id="cxj_yes" >确定</button>
                <button type="button" class="btn btn-primary ftBtn" id="cxj_no" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
<script src="../../js/system/dictionaries.js"></script>