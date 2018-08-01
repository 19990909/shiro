<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>确权登记系统</title>
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
</style>
</head>
<body>
	<div class="container" style="margin-top: 5px">
		<div class="row">
			<!--!查询区 -->
			<div class="panel panel-default">
				<div class="panel-heading"
					style="background-color: #428bca; color: white">查询条件</div>
				<div class="layui-form">
					<!--第一行 -->
					<div class="layui-form-item">
						<label class="col-sm-1" style="margin-top: 10px">承包方名称</label>
						<div class="layui-input-inline"
							style="margin-left: -25px; margin-top: 4px">
							<select name="cid" lay-verify="required" lay-search=""
								id="dsearch">
							</select>
						</div>
						<!--承包地块编码 -->
						<label class="col-sm-1" style="margin-top: 10px">承包地块编码</label>
						<div class="layui-input-inline"
							style="margin-left: -25px; margin-top: 4px">
							<input name="cbdkbm" autocomplete="off" placeholder="请输入承包地块编码"
								class="form-control" type="text" id="cbdkbm">
						</div>
					</div>

					<div class="layui-form-item">

						<label class="col-sm-1" style="margin-top: 10px">承包经营权证编码</label>
						<div class="layui-input-inline"
							 style="margin-left: -25px; margin-top: 4px">
							<select name="jid" lay-verify="required" lay-search=""
									id="jsearch">
							</select>
						</div>
					</div>
					<!--第三行 按钮 -->
					<div class="layui-form-item">
						<div class="col-sm-offset-9">
							<button class="btn btn-primary" type="button" id="search_btn"
								style="background-color: #0767C8">搜索</button>
						</div>
					</div>
				</div>
			</div>
			<div id="toolbar" class="btn-group">
				<button id="btn_add" type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<%--<button id="btn_edit" type="button" class="btn btn-primary" >--%>
				<%--<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改--%>
				<%--</button>--%>
				<button id="btn_delete" type="button" class="btn btn-danger"
					style="margin-left: 10px">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>批量删除
				</button>
			</div>
			<!-- 表格 -->
			<div class="col-sm-12">
				<table class="table table-striped table-bordered table-hover"
					id="table"></table>
			</div>

		</div>
	</div>
	<script src="${ctx}/layui/layui.js" charset="UTF-8"></script>
	<script src="${ctx}/js/layer/layer.js" charset="UTF-8"></script>
	<script type="text/javascript">
    //layui的表单
    layui.use(['form'], function () {
        var form = layui.form;
    });

    //获取选中的所有行的id
    function getIds() {
        return $.map($("#table").bootstrapTable('getSelections'), function (row) {
            return row.id;
        })
    }

    //向select添加选项
    function initSelect() {
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

    //新增
    $("#btn_add").click(function () {
        window.location.href = "${ctx}/dkxx/addDkxx?flag=1";
    })

    //批量删除的方法
    $("#btn_delete").click(function () {
        var ids = getIds();
        if (ids.length < 1) {
            layer.alert('请选择至少一个承包地块信息!', {
                skin: 'layui-layer-lan'
                , closeBtn: 0
            })
        } else {
            layer.confirm('确定删除这些承包地块吗?？', {
                btn: ['是的', '按错了'] //可以无限个按钮
            }, function () {
                //确定按钮的回调函数
                var url = "${ctx}/cbf/removeCbf";
                var params = {
                    flag: 2,
                    ids: ids
                }
                $.ajax({
                    url: url,
                    data: params,
                    type: "post",
                    dataType: "json",
                    error: function () {
                        $("#table").bootstrapTable("refresh", {url: '${ctx}/kjson'});
                    }
                })
            })
        }
    })


    function deleteone(id) {
        layer.confirm('确定删除这个承包地块吗？', {
            btn: ['是的', '按错了'] //可以无限个按钮
        }, function () {
            //确定按钮的回调函数
            window.location.href = "${ctx}/employee/removeEmployee?flag=1&id=" + id;
        })

    }


    class BstpTable {
        constructor(obj) {
            this.obj = obj;
        }

        inint() {
            //---先销毁表格 ---
            this.obj.bootstrapTable('destroy');
            //---初始化表格,动态从服务器加载数据---
            this.obj.bootstrapTable({
                //【发出请求的基础信息】
                url: '${ctx}/kjson',
                method: 'post',
                contentType: "application/x-www-form-urlencoded",//必须有
                //【查询设置】
                /* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                                  设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
                queryParamsType: '',
                queryParams: function queryParams(params) {
                    //自定义传递的参数
                    var param = {
                    	pageNumber: params.pageNumber,
                        pageSize: params.pageSize,
                        //承包方姓名
                        did: $("#dsearch").val(),
                        //承包经营权证编码
                        jid: $("#jsearch").val(),
                        //承包地块编码
                        cbdkbm: $("#cbdkbm").val(),
                        //东至信息
                        dz: $("#dz").val(),
                        //西至信息
                        xz: $("#xz").val(),
                        //南至信息
                        nz: $("#nz").val(),
						//北至
						bz:$("#bz").val(),

                    };
                    return param;
                },

                //【其它设置】
                locale: 'zh-CN',//中文支持
                pagination: true,//是否开启分页（*）
                striped: true,
                pageNumber:1,//初始化加载第一页，默认第一页
                pageSize: 5,//每页的记录行数（*）
                pageList: [5, 10, 15],//可供选择的每页的行数（*）
                sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
                showRefresh: true,//刷新按钮
                showToggle: true,//卡片视图
                toolbar: '#toolbar',//工具栏

                //【样式设置】
                height: 384,
                //按需求设置不同的样式：5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
                rowStyle: function (row, index) {
                    var style = "";
                    if (row.username == "千锋教育") {
                        style = 'success';
                    }
                    if (row.username == "lucifer") {
                        style = 'danger';
                    }
                    if (row.username == "一加") {
                        style = "active";
                    }
                    if (row.username == "联想") {
                        style = "warning";
                    }
                    return {classes: style}
                },

                //【设置列】
                columns: [
                    {
                        title: '全选',
                        field: 'select',
                        //复选框
                        checkbox: true,
                        width: 25,
                        align: 'center',
                        valign: 'middle'
                    },
                    {field: 'dkbm', title: '地块编码'},
                    {field: 'dz', title: '东至信息'},
                    {field: 'xz', title: '西至信息'},
                    {field: 'nz', title: '南至信息'},
                    {field: 'bz', title: '北至信息'},
                    {field: 'cid', title: '承包方姓名'},
                    {field: 'qzbm', title: '承包经营权证编码'},

                    {
                        field: 'tool', title: '操作', align: 'center',
                        formatter: function (value, row, index) {
                            var element =
                                "<a  data-id='" + row.id + "' href='${ctx}/js.dkxx/updateDkxx?flag=1&id=" + row.id + "' class='btn btn-info btn-sm'>编辑</a> &nbsp;" +
                                "<button  data-id='" + row.id + "' href='#' onclick='deleteone(" + row.id + ")' class='btn btn-danger btn-sm'>删除</button> ";
                            return element;
                        }
                    }
                ]
            })
        }
    }

    //初始化表格
    var bstpTable = new BstpTable($("table"));
    bstpTable.inint({})

    //查询按钮的逻辑
    $("#search_btn").click(function () {
        $("#table").bootstrapTable("refresh", {url: '${ctx}/ejson'})
    })

</script>
</body>
</html>