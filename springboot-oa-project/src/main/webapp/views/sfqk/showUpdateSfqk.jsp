<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>确权登记系统——修改个指标数据</title>

    <link rel="stylesheet" href="../css/vendor/bootstrap/css/bootstrap.min.css" type="text/css" charset="UTF-8"/>
    <link rel="stylesheet" href="../css/flat-ui.css" type="text/css" charset="UTF-8"/>
    <link href="../layui/css/layui.css" rel="stylesheet">
    <style type="text/css">
        .form-group {
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div class="layui-form">
    <div class="form-group">
        <label>省区划代码:<input class="form-control" type="text" name="sqhdm" id="sqhdm" lay-verify="sqhdm"
                            value="${sfqk.sqhdm}"/></label>
    </div>
    <div class="form-group">
        <label>省份名称:<input class="form-control" type="text" name="sfmc" id="sfmc" lay-verify="sfmc"
                            value="${sfqk.sfmc}"/></label>
    </div>
    <div class="form-group">
        <label>实测承包地面积:<input class="form-control" type="text" name="sccbdmj" id="sccbdmj" lay-verify="sccbdmj"
                           value="${sfqk.sccbdmj}"/></label>
    </div>
    <div class="form-group">
        <label>确权面积:<input class="form-control" type="text" name="qqmj" id="qqmj" lay-verify="qqmj"
                           value="${sfqk.qqmj}"/></label>
    </div>
    <div class="form-group">
        <label>承包经营权证颁证数:<input class="form-control" type="text" name="bzs" id="bzs" lay-verify="sfmc"
                           value="${sfqk.bzs}"/></label>
    </div>
    <div class="form-group">
        <label>完成土地确权情况:<input class="form-control" type="text" name="wcqqqk" id="wcqqqk" lay-verify="wcqqqk"
                           value="${sfqk.wcqqqk}"/></label>
    </div>

    <div class="form-group">
        <button class="btn-sm btn btn-primary" type="button" lay-submit="" lay-filter="insert">修改</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-sm btn-warning" type="reset">重置</button>
    </div>
</div>
<script src="../js/jquery-3.1.1.min.js" charset="UTF-8"></script>
<script src="../layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript">
    layui.use(['form', 'layer'], function () {
        var form = layui.form,
            layer = layui.layer;
        form.verify({
            sqhdm: function (value) {
                if (value.length == 0) {
                    return '省区划代码不能为空哦';
                }
            },
        });

        //监听提交
        form.on('submit(insert)', function () {
            layer.msg("hhh", {icon: 5});
            var url = "${ctx}/sfqk/updateSfqk";
            var param = {
                flag: 2,
                id:${sfqk.id},
                sqhdm: $("#sqhdm").val(),
                sfmc: $("#sfmc").val(),
                sccbdmj: $("#sccbdmj").val(),
                qqmj: $("#qqmj").val(),
                bzs: $("#bzs").val(),
                wcqqqk: $("#wcqqqk").val(),
           }
            $.ajax({
                url: url,
                data: param,
                type: 'post',
                success: function (data) {
                    if (data == "success") {
                        layer.msg('修改成功', {icon: 1});
                        setTimeout(function () {
                            window.location.href = "${ctx}/sfqk/selectSfqk";
                        }, 2000);
                    }
                },
                error: function () {
                    layer.msg("修改失败", {icon: 2});
                }
            })
        })
    });
</script>
</body>
</html>