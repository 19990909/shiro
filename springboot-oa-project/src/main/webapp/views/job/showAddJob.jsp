<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>确权登记系统——添加职位</title>

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
        <label>承包经营权证编码:<input class="form-control" type="text" name="name" id="jname" lay-verify="jname" /></label>
    </div>
    <div class="form-group">
        <label>权证领取时间:<textarea rows="1" cols="17" id="remanrk" name="remanrk" class="form-control"
                              lay-verify="remanrk"></textarea></label>
    </div>
    <div class="form-group">
        <label>权证领取人姓名:<textarea rows="1" cols="17" id="qzlqrxm" name="qzlqrxm" class="form-control"
                                lay-verify="qzlqrxm"></textarea></label>
    </div>
    <div class="form-group">
        <label>权证领取人证件号码:<textarea rows="1" cols="17" id="qzlqrzjhm" name="qzlqrzjhm" class="form-control"
                                lay-verify="qzlqrzjhm"></textarea></label>
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
            jname: function (value) {
                if (value.length == 0) {
                    return '承包经营权证领取人证件号码不能为空哦';
                }
            },
            remanrk: function (value) {
                if (value.length == 0) {
                    return "领取时间不能为空哦";
                }
            },
            qzlqrxm: function (value) {
                if (value.length == 0) {
                    return "权证领取人姓名不能为空";
                }
            },
            qzlqrzjhm: function (value) {
                if (value.length == 0) {
                    return "权证领取人证件号码不能为空";
                }
            }
        });

        //监听提交
        form.on('submit(insert)', function () {
            layer.msg("hhh",{icon:3});
            var url = "${ctx}/job/addJob";
            var param = {
                flag: 2,
                name:$("#jname").val(),
                remanrk:$("#remanrk").val(),
                qzlqrxm:$("#qzlqrxm").val(),
                qzlqrzjhm:$("#qzlqrzjhm").val()
            }
            $.ajax({
                url: url,
                data: param,
                type: 'post',
                success: function (data) {
                    if (data == "success") {
                        layer.msg('添加成功', {icon: 1});
                        setTimeout(function () {
                            window.location.href = "${ctx}/job/selectJob";
                        }, 2000);
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