<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>确权登记系统——添加承包方</title>

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
        <label>承包方编码:<input class="form-control" type="text" name="cbfbm" id="cbfbm" lay-verify="cbfbm" /></label>
    </div>
    <div class="form-group">
        <label>承包方姓名:<textarea rows="1" cols="17" id="cbfxm" name="cbfxm" class="form-control"
                              lay-verify="cbfxm"></textarea></label>
    </div>
    <div class="form-group">
        <label>承包方类型:<textarea rows="1" cols="17" id="cbflx" name="cbflx" class="form-control"
                              lay-verify="cbflx"></textarea></label>
    </div>
     <div class="form-group">
        <label>承包方证件号码:<textarea rows="1" cols="17" id="cbfzjhm" name="cbfzjhm" class="form-control"
                              lay-verify="cbfzjhm"></textarea></label>
    </div>

    <div class="form-group">
        <label>联系电话:<textarea rows="1" cols="17" id="lxdh" name="lxdh" class="form-control"
                                 lay-verify="lxdh"></textarea></label>
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
            cbfbm: function (value) {
                if (value.length == 0) {
                    return '承包方编码不能为空哦';
                }
            },
            cbfmc: function (value) {
                if (value.length == 0) {
                    return "承包方名称不能为空哦";
                }
            },
            cbflx: function (value) {
                if (value.length == 0) {
                    return "承包方类型不能为空哦";
                }
            },
            cbfzjhm: function (value) {
                if (value.length == 0) {
                    return "承包方证件号码不能为空哦";
                }
            },
            lxdh: function (value) {
                if (value.length == 0) {
                    return "承包方联系电话不能为空哦";
                }
            }
        });

        //监听提交
        form.on('submit(insert)', function () {
            var url = "${ctx}/cbf/addCbf";
            var param = {
                flag: 2,
                cbfbm:$("#cbfbm").val(),
                cbfmc:$("#cbfmc").val(),
                cbflx:$("#cbflx").val(),
                cbfzjhm:$("#cbfzjhm").val(),
                cbflxdh:$("#cbflxdh").val(),
            }
            $.ajax({
                url: url,
                data: param,
                type: 'post',
                success: function (data) {
                    if (data == "success") {
                        layer.msg('添加成功', {icon: 1});
                        setTimeout(function () {
                            window.location.href = "${ctx}/cbf/selectCbf";
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