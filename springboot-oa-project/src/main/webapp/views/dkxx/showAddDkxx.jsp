<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>人事管理系统</title>
    <!-- jq -->
    <script src="${ctx}/js/jquery-3.1.1.min.js"></script>

    <!-- bootstrap -->
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/js/bootstrap.min.js"></script>

    <!-- 分页插件 -->
    <link href="${ctx}/css/bootstrap-table.min.css" rel="stylesheet">
    <script src="${ctx}/js/bootstrap-table.js"></script>
    <script src="${ctx}/js/bootstrap-table-locale-all.min.js"></script>

    <!--layer -->
    <link href="${ctx}/js/layer/theme/default/layer.css" rel="stylesheet">

    <!--layui -->
    <link href="${ctx}/layui/css/layui.css" rel="stylesheet" media="all">

    <!--flat -->
    <style type="text/css">
        .panel {
            margin-left: -56px;
            width: 1245px;
        }

        .col-sm-12 {
            margin-left: -70px;
            margin-top: 15px;
            width: 1270px;
        }

        thead {
            background: #428bca;
            color: white;
        }
        select {
            border:2px solid red;
        }
    </style>
</head>
<body>
<div class="layui-form">
    <!--第一行 -->
    <div class="layui-form-item" style="margin-top: 6px;margin-left: 10px">
        <!--地块编码 -->
        <div class="layui-inline">
            <label class="layui-form-label">地块编码:</label>
            <div class="layui-input-inline">
                <input class="form-control" type="text" name="cbdkbm" lay-verify="cbdkbm|required"  id="cbdkbm"/>
            </div>
        </div>
        <!--身份证号 -->
        <div class="layui-inline">
            <label class="layui-form-label">东至信息:</label>
            <div class="layui-input-inline">
                <input class="form-control" type="text" name="dz" lay-verify="identity" id="dz">
            </div>
        </div>
    </div>
    <!--第三行 -->
    <div class="layui-form-item" style="margin-left: 10px">
        <!--学历 -->
        <div class="layui-inline">
            <label class="layui-form-label">西至信息:</label>
            <div class="layui-input-inline">
                <input class="form-control" type="text" name="xz" id="xz">
            </div>
        </div>

        <!--专业 -->
        <div class="layui-inline">
            <label class="layui-form-label">南至信息:</label>
            <div class="layui-input-inline">
                <input class="form-control" type="text" name="nz" id="nz">
            </div>
        </div>
    </div>

    <!--第四行 -->
    <div class="layui-form-item" style="margin-left: 10px">
        <!--手机 -->
        <div class="layui-inline">
            <label class="layui-form-label">北至信息:</label>
            <div class="layui-input-inline">
                <input class="form-control" name="bz" type="text" lay-verify="bz" id="bz">
            </div>
        </div>
    </div>
    <!--第八行 -->
    <div class="layui-form-item" style="margin-left: 10px">
        <!--职位 -->
        <div class="layui-inline">
            <label class="layui-form-label">承包方名称:</label>
            <div class="layui-input-inline">
                <select name="cid" lay-search="" id="dsearch">
                </select>
            </div>
        </div>
        <!--所属部门 -->
        <div class="layui-inline">
            <label class="layui-form-label">承包经营权证书编码:</label>
            <div class="layui-input-inline">
                <select name="qzbm" lay-search="" id="jsearch">
                </select>
            </div>
        </div>
    </div>
    <!--第十一行 -->
    <div class="form-group" style="margin-left: 50px">
        <button class="btn-sm btn btn-primary" type="button" lay-submit="" lay-filter="insert" id="addDk">添加</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-sm btn-warning" type="reset">重置</button>
    </div>
    <!--表单结束 -->
</div>
<script type="text/javascript">
    $(function () {
        $("#addDk").on("click",function () {
            var url = "${ctx}/employee/addEmployee";
            var param = {
                flag: 2,
                cid: $("#dsearch").val(),
                qzbm: $("#jsearch").val(),
                cbdkbm: $("#cbdkbm").val(),
                dz: $("#dz").val(),
                xz: $("#xz").val(),
                nz: $("#nz").val(),
                bz: $("#bz").val(),
            };
            $.ajax({
                url: url,
                data: param,
                type: 'post',
                success: function (res) {
                    if (res == "success") {
                        layer.msg("添加成功", {icon: 1});
                        setTimeout(function () {
                            window.location.href = "${ctx}/dkxx/selectDkxx";
                        });
                    }
                },
                error: function () {
                    layer.msg("添加失败", {icon: 2});
                }
            })
         });
    });
    layui.use(['form', 'laydate'], function () {
        var form = layui.form,
            laydate = layui.laydate;
        <!--监听提交 -->
        <%--form.on('submit(change)', function () {--%>
            <%--var url = "${ctx}/employee/addEmployee";--%>
            <%--var param = {--%>
                <%--flag: 2,--%>
                <%--cid: $("#dsearch").val(),--%>
                <%--qzbm: $("#jsearch").val(),--%>
                <%--cbdkbm: $("#cbdkbm").val(),--%>
                <%--dz: $("#dz").val(),--%>
                <%--xz: $("#xz").val(),--%>
                <%--nz: $("#nz").val(),--%>
                <%--bz: $("#bz").val(),--%>
            <%--};--%>
            <%--$.ajax({--%>
                <%--url: url,--%>
                <%--data: param,--%>
                <%--type: 'post',--%>
                <%--success: function (res) {--%>
                    <%--if (res == "success") {--%>
                        <%--layer.msg("添加成功", {icon: 1});--%>
                        <%--setTimeout(function () {--%>
                            <%--window.location.href = "${ctx}/js.dkxx/selectDkxx";--%>
                        <%--});--%>
                    <%--}--%>
                <%--},--%>
                <%--error: function () {--%>
                    <%--layer.msg("添加失败", {icon: 2});--%>
                <%--}--%>
            <%--})--%>
        <%--});--%>
    });
    //向select添加选项
    function initSelect() {
        <!--向职位下拉框中追加选项 -->
        $("#jsearch").prepend("<option value=''>请输入或选择承包经营权证编码</option>");

        //获取joblist中所有的job
        var jobIdArray = new Array();
        var jobNameArray = new Array();
        <c:forEach items="${jobList}" var="job">
        jobIdArray.push(${job.id});
        jobNameArray.push("${job.name}");
        </c:forEach>
        //职位追加开始
        for (var i = 0; i < jobIdArray.length; i++) {
            $("#jsearch").append("<option value='" + jobIdArray[i] + "'>" + jobNameArray[i] + "</option>");
        }
        <!--向部门下拉框中追加选项 -->
        //在最前面追加一个选项
        $("#dsearch").prepend("<option value=''>请输入或选择承包方姓名</option>");
        <!--获取所有部门信息 -->
        var cbfIdArray = new Array();
        var cbfNameArray = new Array();
        /*    <!--遍历部门集合,取出所有部门的名字 --> */

        <c:forEach items="${cbfList}" var="cbf">
        cbfIdArray.push(${cbf.id})
        cbfNameArray.push("${cbf.cbfmc}")
        </c:forEach>
        //向select中追加选项
        for (var i = 0; i < cbfIdArray.length; i++) {
            $("#dsearch").append("<option value='" + cbfIdArray[i] + "'>" + cbfNameArray[i] + "</option>");
        }

        //追加结束
    }
    //调用方法
    initSelect();
</script>
</body>
</html>