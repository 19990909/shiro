<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>确权登记系统——添加汇交人员信息</title>

    <link rel="stylesheet" href="/css/vendor/bootstrap/css/bootstrap.min.css" type="text/css" charset="UTF-8"/>
    <link rel="stylesheet" href="/css/flat-ui.css" type="text/css" charset="UTF-8"/>
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
        <label>汇交省份:<input class="form-control" type="text" name="hjsf" id="hjsf" lay-verify="hjsf" /></label>
    </div>
    <div class="form-group">
        <label>汇交人员姓名:<textarea rows="1" cols="17" id="hjryxm" name="hjryxm" class="form-control"
                              lay-verify="hjryxm"></textarea></label>
    </div>
    <div class="form-group">
        <label>汇交人员职位:<textarea rows="1" cols="17" id="hjzw" name="hjryzw" class="form-control"
                              lay-verify="hjzw"></textarea></label>
    </div>
     <div class="form-group">
        <label>地址:<textarea rows="1" cols="17" id="hjdz" name="hjdz" class="form-control"
                              lay-verify="hjdz"></textarea></label>
    </div>
    <div class="form-group">
        <label>邮箱:<textarea rows="1" cols="17" id="hjyx" name="hjyx" class="form-control"
                            lay-verify="hjyx"></textarea></label>
    </div>
    <div class="form-group">
        <label>联系电话:<textarea rows="1" cols="17" id="hjlxdh" name="hjlxdh" class="form-control"
                            lay-verify="hjlxdh"></textarea></label>
    </div>
    <div class="form-group">
        <button class="btn-sm btn btn-primary" type="button" lay-submit="" lay-filter="insert">添加</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-sm btn-warning" type="reset">重置</button>
    </div>
</div>
<script src="/js/jquery-3.1.1.min.js" charset="UTF-8"></script>
<script src="/layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript">
    layui.use(['form', 'layer'], function () {
        var form = layui.form,
            layer = layui.layer;
        form.verify({
            hjsf: function (value) {
                if (value.length == 0) {
                    return '汇交省份不能为空哦';
                }
            },
            hjryxm: function (value) {
                if (value.length == 0) {
                    return "汇交人员姓名不能为空哦";
                }
            },
            hjzw: function (value) {
                if (value.length == 0) {
                    return "汇交职位不能为空哦";
                }
            },
            hjdz: function (value) {
                if (value.length == 0) {
                    return "地址不能为空哦";
                }
            }
        });

        //监听提交
        form.on('submit(insert)', function () {
            var url = "${ctx}/hjry/addHjry";
            var param = {
                flag: 2,
                hjsf:$("#hjsf").val(),
                hjryxm:$("#hjryxm").val(),
                hjzw:$("#hjzw").val(),
                hjdz:$("#hjdz").val(),
                hjyx:$("#hjyx").val(),
                hjlxdh:$("#hjlxdh").val(),
            }
            $.ajax({
                url: url,
                data: param,
                type: 'post',
                success: function (data) {
                    if (data == "success") {
                        layer.msg('添加成功', {icon: 1});
                        setTimeout(function () {
                            window.location.href = "${ctx}/hjry/selectHjyr";
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