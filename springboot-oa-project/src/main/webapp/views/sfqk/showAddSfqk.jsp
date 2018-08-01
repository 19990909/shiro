<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>确权登记系统——添加省份进展情况</title>

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
    <label>省区划代码:<input class="form-control" type="text" name="sqhdm" id="sqhdm" lay-verify="sqhdm" /></label>
</div>
    <div class="form-group">
        <label>
            省份名称:<textarea rows="1" cols="17" id="sfmc" name="sfmc" class="form-control"
                           lay-verify="sfmc"></textarea></label>
    </div>
    <div class="form-group">
        <label>实测承包地面积:<textarea rows="1" cols="17" id="sccbdmj" name="sccbdmj" class="form-control"
                                 lay-verify="sccbdmj"></textarea></label>
    </div>
    <div class="form-group">
        <label>确权面积:<textarea rows="1" cols="17" id="qqmj" name="qqmj" class="form-control"
                              lay-verify="qqmj"></textarea></label>
    </div>
    <div class="form-group">
        <label>颁发土地承包经营权证书:<textarea rows="1" cols="17" id="bzs" name="bzs" class="form-control"
                                     lay-verify="bzs"></textarea></label>
    </div>
    <div class="form-group">
        <label>完成土地确权情况:<textarea rows="1" cols="17" id="wcqqqk" name="wcqqqk" class="form-control"
                                  lay-verify="wcqqqk"></textarea></label>
    </div>
    <div class="form-group">
        <button class="btn-sm btn btn-primary" type="button" lay-submit="" lay-filter="insert">添加</button>
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
            }
        });

        //监听提交
        form.on('submit(insert)', function () {
            var url = "${ctx}/sfqk/addSfqk";
            var param = {
                flag: 2,
                sqhdm:$("#sqhdm").val(),
                sfmc:$("#sfmc").val(),
                sccbdmj:$("#sccbdmj").val(),
                qqmj:$("#qqmj").val(),
                bzs:$("#bzs").val(),
                wcqqqk:$("#wcqqqk").val(),
            }
            $.ajax({
                url: url,
                data: param,
                type: 'post',
                success: function (data) {
                    if (data == "success") {
                        layer.msg('添加成功', {icon: 1});
                        setTimeout(function () {
                            window.location.href = "${ctx}/sfqk/selectSfqk";
                        }, 2000);
                    }else{
                        layer.msg("添加失败", {icon: 2});
                    }
                },
                error: function () {
                    layer.msg("添加失败", {icon: 2});
                }
            })
        })
    });
</script>
</body>
</html>