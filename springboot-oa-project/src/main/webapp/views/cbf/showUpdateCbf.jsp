<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>确权登记系统——修改职位</title>

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
        <label>发包方名称:<input class="form-control" type="text" name="fbfmc" id="fbfmc" lay-verify="fbfmc"
                           value="${fbf.fbfmc}"/></label>
    </div>
    <div class="form-group">
        <label>发包方证件号码 :<textarea rows="1" cols="17" id="fbfzjhm" name="fbfzjhm" class="form-control"
                              lay-verify="fbfzjhm">${fbf.fbfzjhm}</textarea></label>
    </div>
    <div class="form-group">
        <label>发包方联系电话 :<textarea rows="1" cols="17" id="fbflxdh" name="fbflxdh" class="form-control"
                              lay-verify="fbflxdh">${fbf.fbflxdh}</textarea></label>
    </div>
    <div class="form-group">
        <label>发包方地址 :<textarea rows="1" cols="17" id="fbfdz" name="fbfdz" class="form-control"
                              lay-verify="fbfdz">${fbf.fbfdz}</textarea></label>
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
            fbfmc: function (value) {
                if (value.length == 0) {
                    return '发包方姓名不能为空哦';
                }
            },
           fbfzjhm: function (value) {
                if (value.length == 0) {
                    return "发包方证件号码不能为空哦";
                }
            },
            fbflxdh: function (value) {
                if (value.length == 0) {
                    return "发包方联系电话不能为空哦";
                }
            },
            fbfdz: function (value) {
                if (value.length == 0) {
                    return "发包方地址不能为空哦";
                }
            },
        });

        //监听提交
        form.on('submit(insert)', function () {
            layer.msg("hhh", {icon: 5});
            var url = "${ctx}/fbf/updateFbf";
            var param = {
                flag: 2,
                id:${fbf.id},
                fbfmc: $("#fbfmc").val(),
                fbfzjhm: $("#fbfzjhm").val(),
                fbflxdh: $("#fbflxdh").val(),
                fbfdz: $("#fbfdz").val(),
            }
            $.ajax({
                url: url,
                data: param,
                type: 'post',
                success: function (data) {
                    if (data == "success") {
                        layer.msg('修改成功', {icon: 1});
                        setTimeout(function () {
                            window.location.href = "${ctx}/fbf/selectFbf";
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