<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>确权登记系统</title>
    <!--引入bootstrap -->
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">

    <!--引入layui -->
    <link href="${ctx}/layui/css/layui.css" rel="stylesheet">
</head>
<body>
<div class="layui-form">
    <!--第一行 -->
    <div class="layui-form-item" style="margin-top: 6px;margin-left: 10px">

        <div class="layui-inline">
            <label class="layui-form-label">承包地块编码:</label>
            <div class="layui-input-inline">
                <input class="form-control" type="text" name="dkbm" lay-verify="name" id="dkbm" value="${dkxx.dkbm}"/>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">东至信息:</label>
            <div class="layui-input-inline">
                <input class="form-control" type="text" name="dz" lay-verify="identity" id="dz" value="${dkxx.dz}">
            </div>
        </div>
    </div>


    <!--第三行 -->
    <div class="layui-form-item" style="margin-top: 6px;margin-left: 10px">

        <div class="layui-inline">
            <label class="layui-form-label">西至信息:</label>
            <div class="layui-input-inline">
                <input class="form-control" type="text" name="xz" lay-verify="xz" id="xz" value="${dkxx.xz}"/>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">南至信息:</label>
            <div class="layui-input-inline">
                <input class="form-control" type="text" name="nz" lay-verify="identity" id="nz" value="${dkxx.nz}">
            </div>
        </div>
    </div>

    <!--第四行 -->
    <div class="layui-form-item" style="margin-left: 10px">
        <!--手机 -->
        <div class="layui-inline">
            <label class="layui-form-label">北至信息:</label>
            <div class="layui-input-inline">
                <input class="form-control" name="bz" type="text" lay-verify="bz" id="bz" value="${dkxx.bz}">
            </div>
        </div>
        <!--邮箱 -->

    </div>




    <!--第六行 -->
    <div class="layui-form-item" style="margin-left: 10px">
        <!--QQ -->
        <div class="layui-inline">
            <label class="layui-form-label">QQ:</label>
            <div class="layui-input-inline">
                <input class="form-control" name="qqnum" type="text" id="qqnum" value="${employee.qqnum}">
            </div>
        </div>
        <!--生日 -->
        <div class="layui-inline">
            <label class="layui-form-label">生日:</label>
            <div class="layui-input-inline">
                <input class="form-control" name="birthday" type="text" id="date">
            </div>
        </div>
    </div>




    <div class="layui-form-item" style="margin-left: 10px">

        <div class="layui-inline">
            <label class="layui-form-label">承包方名称:</label>
            <div class="layui-input-inline">
                <select name="cid" lay-search="" id="dsearch">
                </select>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">承包经营权证编码:</label>
            <div class="layui-input-inline">
                <select name="jid" lay-search="" id="jsearch">
                </select>
            </div>
        </div>
    </div>
    <!--表单结束 -->
</div>
<!--引入jquery -->
<script src="${ctx}/js/jquery-3.1.1.min.js" charset="UTF-8"></script>
<!--引入layui.js -->
<script src="${ctx}/layui/layui.js" charset="UTF-8"></script>
<!--引入省市县三级联动js -->
<script src="${ctx}/js/city.js" charset="UTF-8"></script>

<script type="text/javascript">
    layui.use(['form', 'laydate'], function () {
        var form = layui.form,
            laydate = layui.laydate;

        <!--验证规则 -->
        form.verify({
            name: function (value) {
                if (value.length > 20) {
                    return "请输入正确的姓名"
                }
            }
        });

        <!--监听提交 -->
        form.on('submit(change)', function () {
            var url = "${ctx}/js.dkxx/updateDkxx";
            var param = {
                flag: 2,
                id:${dkxx.id},
                dkbm:$("#dkbm").val(),
                jid: $("#jsearch").val(),
                cid: $("#dsearch").val(),

                dz: $("#dz").val(),
                xz: $("#xz").val(),
                nz: $("#nz").val(),
                bz: $("#bz").val(),
            };
            $.ajax({
                url: url,
                data: param,
                type: 'get',
                success: function (res) {
                    if (res == "success") {
                        layer.msg("修改成功", {icon: 1});
                        setTimeout(function () {
                            window.location.href = "${ctx}/dkxx/selectDkxx";
                        });
                    }
                },
            error: function () {
            layer.msg("修改失败", {icon: 2});
        }
    })
        });



        //墨绿主题
        laydate.render({
            elem: '#date',
            theme: 'molv',
            max:getDate(),
            value:'${employee.birthday}'.substr(0,10)
        });
    });

    <!--获取当天日期 -->
    function getDate() {
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var date = date.getDate();
        return year + "-" + month + "-" + date;
    }


    //向select添加选项
    function initSelect() {
        <!--向部门下拉框中追加选项 -->
        //在最前面追加一个选项
        $("#dsearch").prepend("<option value=''>请输入或选择承包方姓名</option>");
        <!--获取所有部门信息 -->
        var cbfIdArray = new Array();
        var cbfNameArray = new Array();
        <!--遍历部门集合,取出所有部门的名字 -->
        <c:forEach items="${cbfList}" var="cbf">
        cbfIdArray.push(${cbf.id})
        cbfNameArray.push("${cbf.cbfmc}")
        </c:forEach>
        //向select中追加选项
        for (var i = 0; i < cbfIdArray.length; i++) {
            $("#dsearch").append("<option value='" + cbfIdArray[i] + "'>" + cbfNameArray[i] + "</option>");
        }

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
        //追加结束
    }

    //调用方法
    initSelect();
</script>
</body>
</html>