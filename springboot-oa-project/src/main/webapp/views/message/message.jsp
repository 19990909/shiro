<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="springboot.oa.domain.user.SysUser" %>
<%@ page import="springboot.oa.utils.CommonUtils" %>
<%
    HttpSession session1 = request.getSession();
    SysUser user = (SysUser) session1.getAttribute(CommonUtils.SESSION_USER);
    String username = user.getUserName();
    String nickname = user.getNickName();
%>
<!DOCTYPE HTML >
<html>
<head>
    <title>国家级电子政务平台</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="/css/control/bootstrap.min.css" rel="stylesheet">
    <link href="/css/message/layer.css" rel="stylesheet" type="text/css"/>
    <link title=css1 href="/css/message/s1_1.css" rel="stylesheet" type="text/css"/>
    <link title=css2 href="/css/message/s1_2.css" rel="stylesheet" type="text/css"/>
    <link href="/css/message/mCustomScrollbar.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/css/message/font-awesome.css"/>
    <link rel="stylesheet" type="text/css" href="/css/message/simditor.css"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/message/job.css">
    <link rel="stylesheet" href="/css/message/loaders.css">
    <script>
        var username = "<%=username%>";
        var nickname = "<%=nickname%>";
    </script>
</head>
<style>

    .form-horizontal .form-group {
        margin-left: 0;
        margin-right: 0;
    }

    .table {
        margin-bottom: 0;
    }

    .delete {
        position: absolute;
        right: 16px;
        top: 12px;
        font-size: 26px;
        background: none;
        color: #000;
        padding: 0 10px;
    }

    .modal {
        top: 13%;
    }
    .dropdown-menu{
        z-index: 9999999;
    }
    .searchInput{
        display: inline-block;
        width: 78%;
        height: 34px;
        font-size: 14px;
        line-height: 1.42857;
        color: rgb(85, 85, 85);
        background-color: rgb(255, 255, 255);
        background-image: none;
        box-shadow: rgba(0, 0, 0, 0.075) 0px 1px 1px inset;
        padding: 6px 12px;
        border-width: 1px;
        border-style: solid;
        border-color: rgb(204, 204, 204);
        border-image: initial;
        border-radius:  4px;
        margin-right: -8px;
    }
    .searchBtn{
        width: 20%;
        display: inline-block;
        margin-bottom: 1px;
        color: #fff;
        padding: 5px 12px;
        font-size: 16px;
        font-weight: normal;
        line-height: 1.42857143;
        text-align: center;
        white-space: nowrap;
        vertical-align: middle;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        background-image: none;
        border: 1px solid transparent;
        border-radius: 0 4px 4px 0;
    }
    .checkTitle{
        width: 100%;
        height: 34px;
        line-height: 34px;
        padding: 0 10px;
        background: #f0f4fc;
        margin: 20px 0;
        font-weight: 600;
    }
    .checkTitle span{
        font-weight: normal;
        font-size: 14px;
    }
    .detailContent p,.detailContent h3,.listContent p,.listContent h3{
        margin: 20px 0;
    }
    .detailDown,.listDown{
        margin: 15px 0;
        color: #068cce;
        font-size: 14px;
    }
    .detailDown span,.listDown span{
        margin: 3px 5px 0;
        cursor: pointer;
    }
    h4{
        display: inline-block;
        font-size: 20px;
    }
    .none{
        display:  none;
    }

    .jobdiv {
        height: 100%;!important;
    }
    table th,table td{
        font-size: 18px;
    }
</style>
<body class="bjbody">
<!--  地图操作控件 -->
<div id="znxd-maptools" style="display:none;">
    <div class="list-group "><a id="znxd-maptool-py" title="平移" href="javascript:void(0);"
                                class="list-group-item znxd-maptool "> <span
            class="glyphicon glyphicon-hand-up" aria-hidden="true"></span> </a> <a id="znxd-maptool-fd" title="放大"
                                                                                   href="javascript:void(0);"
                                                                                   class="list-group-item znxd-maptool"> <span
            class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span> </a> <a id="znxd-maptool-sx" title="缩小"
                                                                                   href="javascript:void(0);"
                                                                                   class="list-group-item znxd-maptool"> <span
            class="glyphicon glyphicon-zoom-out" aria-hidden="true"></span> </a> <a id="znxd-maptool-measure" title="量测"
                                                                                    href="javascript:void(0);"
                                                                                    class="list-group-item znxd-maptool"> <span
            class="glyphicon glyphicon-wrench" aria-hidden="true"></span> </a> <a id="znxd-maptool-xz" title="选择"
                                                                                  href="javascript:void(0);"
                                                                                  class="list-group-item znxd-maptool"> <span
            class="glyphicon glyphicon-search"
            aria-hidden="true"></span> </a> <a
            id="znxd-maptool-ck" title="查看属性" href="javascript:void(0);" class="list-group-item znxd-maptool"> <span
            class="glyphicon glyphicon-info-sign"
            aria-hidden="true"></span> </a> <a
            id="znxd-maptool-qcxz" title="清除选择" href="javascript:void(0);" class="list-group-item znxd-maptool"> <span
            class="glyphicon glyphicon-trash"
            aria-hidden="true"></span> </a> <a
            id="znxd-maptool-qt" title="显示全图" href="javascript:void(0);" class="list-group-item znxd-maptool"> <span
            class="glyphicon glyphicon-globe"
            aria-hidden="true"></span> </a> <a
            id="znxd-maptool-bj" title="动态标记" href="javascript:void(0);" class="list-group-item znxd-maptool"> <span
            class="glyphicon glyphicon-flag"
            aria-hidden="true"></span> </a> <a
            id="znxd-maptool-marker" title="添加标注" href="javascript:void(0);" class="list-group-item znxd-maptool"> <span
            class="glyphicon glyphicon-map-marker"
            aria-hidden="true"></span> </a> <a
            id="znxd-maptool-sc" title="添加收藏" href="javascript:void(0);" class="list-group-item znxd-maptool"> <span
            class="glyphicon glyphicon-bookmark"
            aria-hidden="true"></span> </a> <a
            id="znxd-maptool-dy" title="地图打印" href="javascript:void(0);" class="list-group-item znxd-maptool "> <span
            class="glyphicon glyphicon-print"
            aria-hidden="true"></span> </a></div>
</div>
<!--  地图操作控件-结束 -->
<div class="navall">
    <div class="navcenter">
        <div class="narright">
            <div class="nrdiv">
                <div class="imgall">
                    <div class="nrimg03"></div>
                    <div class="divimg divimg03" style="display:none;">
                        <div class="jiaodiv">
                            <div class="pfqh"><a class="styleswitch a1" style="CURSOR: pointer" title="白" rel=css1><i
                                    class="glyphicon  glyphicon-check skinIcon"></i>&nbsp;白色</a></div>
                            <div class="pfqh"><a class="styleswitch a2" style="CURSOR: pointer; color:#162e64;"
                                                 title="蓝"
                                                 rel=css2><i
                                    class="glyphicon  glyphicon-check skinIcon"></i>&nbsp;蓝色</a></div>
                        </div>
                    </div>
                </div>
                <div class="imgall">
                    <div class="nrimg04"></div>
                    <div class="divimg divimg04" style="display:none;">
                        <div class="jiaodiv">
                            <p id="toOut"><i class="glyphicon glyphicon-log-out"></i>&nbsp;退出</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="narleft">
        <div class="narbtn"></div>
        <%--<div class="narbody">--%>
            <%--<jsp:include page="nav.jsp"></jsp:include>--%>
        <%--</div>--%>
    </div>
</div>
<div id="title"></div>
<div class="jobdiv">
    <div class="dxcont">
        <ul class="jobslidings">
            <%--<li  id="two1" onclick="index_2('two',1,2)"><a>工作通知</a></li>--%>
            <li id="two2" class="hover" onclick="index_2('two',2,2)"><a>工作信箱</a></li>
        </ul>
        <%--<div id="con_two_1" class="jobslidnr  sliding_yc">--%>
            <%--<button class="btn btn-top btn-primary" id="btn_gztz">工作通知</button>--%>
            <%--<button class="btn btn-default btn-top" id="new">新建</button>--%>
            <%--<button class="btn btn-default btn-top" id="btn_cg">草稿</button>--%>
            <%--&lt;%&ndash;<button class="btn btn-default btn-top" id="btn_publish">已发布</button>&ndash;%&gt;--%>
            <%--<button class="btn btn-default btn-top" id="btn_delete">已删除</button>--%>
            <%--<div class="btn-group">--%>
                <%--<button type="button" class="btn btn-default dropdown-toggle btn-top" data-toggle="dropdown"--%>
                        <%--aria-haspopup="true"--%>
                        <%--aria-expanded="false">--%>
                    <%--标记 <span class="caret"></span>--%>
                <%--</button>--%>
                <%--<ul class="dropdown-menu" id="bjdj">--%>
                    <%--<li><a class="icon-star star1" bjdj="1" href="javascript:">一级重要</a></li>--%>
                    <%--<li><a class="icon-star star2" bjdj="2" href="javascript:">二级重要</a></li>--%>
                    <%--<li><a class="icon-star star3" bjdj="3" href="javascript:">三级重要</a></li>--%>
                    <%--<li role="separator" class="divider"></li>--%>
                    <%--<li><a class="icon-star star0" bjdj="0" href="javascript:">取消星标</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <%--<div class="btn-group">--%>
                <%--<button type="button" class="btn btn-default dropdown-toggle btn-top note-sel" data-toggle="dropdown"--%>
                        <%--aria-haspopup="true"--%>
                        <%--aria-expanded="false">--%>
                    <%--筛选 <span class="caret"></span>--%>
                <%--</button>--%>
                <%--<ul class="dropdown-menu">--%>
                    <%--<li id="all"><a href="javascript:">所有</a></li>--%>
                    <%--<li role="separator" class="divider"></li>--%>
                    <%--<li id="rules"><a href="javascript:">规章制度</a></li>--%>
                    <%--<li id="brief"><a href="javascript:">简报</a></li>--%>
                    <%--<li id="notice"><a href="javascript:">通知</a></li>--%>
                    <%--<li id="infor"><a href="javascript:">信息动态</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <%--<div class="pull-right col-sm-3">--%>
                <%--<input type="text" class="searchInput" placeholder="请输入关键字...">--%>
                <%--<button class="btn-primary searchBtn"><span class="glyphicon glyphicon-search"></span></button>--%>
            <%--</div>--%>
            <%--<div class="note-list">--%>
                <%--<div class="checkTitle">--%>
                    <%--通知列表<span class="tzNum">（共62封）</span>--%>
                    <%--<a class="pull-right" href="javascript:" style="margin-left: 10px" id="gztzDelete">删除</a>--%>
                    <%--<a class="pull-right mgr-10" href="javascript:"  id="gztzZf">转发</a>--%>
                <%--</div>--%>
                <%--<table class="table table-hover table-condensed table-sm" id="note_table">--%>
                    <%--<tr>--%>
                        <%--&lt;%&ndash;<th width="10%">序号</th>&ndash;%&gt;--%>
                        <%--<th width="50%"><input type="checkbox" value="" class="allCheck">通知主题</th>--%>
                        <%--<th width="15%">通知类型</th>--%>
                        <%--<th width="20%">收件单位</th>--%>
                        <%--<th width="15%">通知日期</th>--%>
                    <%--</tr>--%>
                    <%--<tr style="color: #000">--%>
                        <%--<td><input type="checkbox"><span class='td-mid cursor detail'>" + title + "</span></td>--%>
                        <%--<td>简章</td>--%>
                        <%--<td>山东省</td>--%>
                        <%--<td><span class='td-text'>" + tzrq  + "</span><span class='icon-star star1 inline'></span></td>--%>
                    <%--</tr>--%>
                    <%--<tr style="color: #666">--%>
                        <%--<td><input type="checkbox"><span class='td-mid cursor detail'>" + title + "</span></td>--%>
                        <%--<td>简章</td>--%>
                        <%--<td>山东省</td>--%>
                        <%--<td><span class='td-text'>" + tzrq  + "</span><span class='icon-star star1 inline'></span></td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
                <%--<ul id="notePager" class="pagination pull-right"></ul>--%>
            <%--</div>--%>
            <%--<div class="send-note">--%>
                <%--<div class="checkTitle" style="margin-top: 0">--%>
                    <%--新建通知--%>
                <%--</div>--%>
                <%--<div class="sendBox">--%>
                    <%--<div class="send-cont">--%>
                        <%--<form class="form-horizontal" id="publish_form">--%>
                            <%--<div class="form-group none">--%>
                                <%--<div class="col-sm-11">--%>
                                    <%--<input type="text" class="form-control publish-id" name="id">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="title" class="col-sm-1 control-label">公告标题</label>--%>
                                <%--<div class="col-sm-11">--%>
                                    <%--<input type="text" class="form-control publish-title" name="title">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="tzlx" class="col-sm-1 control-label">公告类型</label>--%>
                                <%--<div class="col-sm-11">--%>
                                    <%--<select class="form-control publish-tzlx" name="tzlx">--%>
                                        <%--<option value="1">规章制度</option>--%>
                                        <%--<option value="2">简报</option>--%>
                                        <%--<option value="3">通知</option>--%>
                                        <%--<option value="4">信息动态</option>--%>
                                    <%--</select>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="mail_sjr" class="col-sm-1 control-label">收件单位</label>--%>
                                <%--<div class="col-sm-11">--%>
                                    <%--<input type="text" class="form-control" id="gztz_sjr" name="" placeholder="收件单位" readonly="">--%>
                                    <%--<input type="text" class="form-control none" id="gztz_sjr_hide" name="sjdw" placeholder="收件单位">--%>
                                    <%--&lt;%&ndash;<input type="text" class="form-control none" id="uploadDir" name="uploadDir" placeholder="uploadDir" value="gzxx">&ndash;%&gt;--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<label for="inputPassword3" class="col-sm-1 control-label">发送对象</label>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="col-sm-11">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<select class="form-control isAll">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<option value="all">全部</option>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<option value="province">省</option>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</select>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="form-group none" id="province">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="col-sm-offset-1 col-sm-11">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="checkbox">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<label>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<input type="checkbox" value="1" class="allCheck-pro">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;全选&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</label>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<label>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<input type="checkbox" value="0" class="province">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;省及其下属县&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</label>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="proBox"></div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="inputPassword3" class="col-sm-1 control-label">公告内容</label>--%>
                                <%--<div class="col-sm-11">--%>
                            <%--<textarea class="form-control publish-tznr" id="note-content" name="tznr"--%>
                                      <%--autofocus></textarea>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="inputPassword3" class="col-sm-1 control-label">上传附件</label>--%>
                                <%--<div class="col-sm-11">--%>
                                    <%--<input type="file" name="file">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="inputEmail3" class="col-sm-1 control-label">发件单位</label>--%>
                                <%--<div class="col-sm-11">--%>
                                    <%--<input type="text" class="form-control defaultName" name="by1">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<input type="text" class="form-control none"  name="uploadDir" placeholder="uploadDir" value="gztz">--%>
                            <%--<div class="form-group">--%>
                                <%--<div class="col-sm-offset-1 col-sm-11">--%>
                                    <%--<button type="button" class="btn btn-primary" id="publish_save">发布</button>--%>
                                    <%--<button type="button" class="btn btn-default btn-back" id="publish_saveInBag">存草稿</button>--%>
                                    <%--<button type="button" class="btn btn-default btn-back">关闭</button>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                    <%--<div class="send-contacts">--%>
                        <%--<h5>最近联系人<span class="pull-right cursor">清空</span></h5>--%>
                        <%--<input type="text" class="form-control input-sm" placeholder="查找联系人">--%>
                        <%--<div class="contacts-list"></div>--%>
                    <%--</div>--%>
                <%--</div>--%>

            <%--</div>--%>
            <%--<div class="note-detail none">--%>
                <%--<div class="fgLine" style="width: 100%;border-bottom: 1px solid #c3c3c3; margin: 30px 0"></div>--%>
                <%--<div class="detailContent"  style="padding: 0 20px">--%>
                    <%--<input type="text" class="detailId none">--%>
                    <%--<h3 class="detailChange detailTitle">农业部办公厅关于印发《农村土地承包经营权确权登记成果制图规范（试行）》的通知（农办经（2015）23号）</h3>--%>
                    <%--<p class="detailPeople">发件人：<span class="detailChange detailJbr">张三</span></p>--%>
                    <%--<p class="detailTime">发件时间：<span class="detailChange detailJbsj">2017年10月20日（星期六）下午5:31</span></p>--%>
                    <%--<p class="detailSjpeople">收件人：<span class="detailChange detailSjr">李四</span></p>--%>
                    <%--&lt;%&ndash;<p class="detailFj">附件：<a href="javascript:void 0" class="detailChange" download></a></p>&ndash;%&gt;--%>
                    <%--<textarea name="" id="detailTextarea" cols="30" rows="10" style="width: 100%"></textarea>--%>
                    <%--<div class="detailFj">附件（1个）</div>--%>
                    <%--<div class="detailDown">--%>
                        <%--<img src="/images/downIcon.png" alt="">--%>
                        <%--&lt;%&ndash;<span class="detailYl">预览</span>&ndash;%&gt;--%>
                        <%--<a href="javascript:void (0)" class="detailXz" download>下载</a>--%>
                    <%--</div>--%>
                    <%--<div style="margin-top: 20px">--%>
                        <%--<button class="btn btn-default" id="detailDelete">删除</button>--%>
                        <%--<button class="btn btn-default" id="detailDeleteCd">彻底删除</button>--%>
                    <%--</div>--%>
                <%--</div>--%>

            <%--</div>--%>
        <%--</div>--%>
        <div id="con_two_2" class="jobslidnr">
            <button class="btn btn-default btn-mail" id="3">发件箱</button>
            <button class="btn btn-primary btn-mail" id="2">收件箱</button>
            <button class="btn btn-default btn-mail" id="1">发件</button>
            <button class="btn btn-default btn-mail" id="4">草稿箱</button>
            <%--<button class="btn btn-default btn-mail" id="5">删除</button>--%>
            <button class="btn btn-default btn-mail" id="5">已删除</button>
            <%--<button class="btn btn-default btn-mail" id="6">顶置</button>--%>
            <%--<div class="btn-group">--%>
            <%--<button type="button" class="btn btn-default dropdown-toggle btn-top" data-toggle="dropdown"--%>
            <%--aria-haspopup="true"--%>
            <%--aria-expanded="false">--%>
            <%--标记 <span class="caret"></span>--%>
            <%--</button>--%>
            <%--<ul class="dropdown-menu" id="bjdj">--%>
            <%--<li><a class="icon-star star1" bjdj="1" href="javascript:">一级重要</a></li>--%>
            <%--<li><a class="icon-star star2" bjdj="2" href="javascript:">二级重要</a></li>--%>
            <%--<li><a class="icon-star star3" bjdj="3" href="javascript:">三级重要</a></li>--%>
            <%--<li role="separator" class="divider"></li>--%>
            <%--<li><a class="icon-star star0" bjdj="0" href="javascript:">取消星标</a></li>--%>
            <%--</ul>--%>
            <%--</div>--%>
            <%--<div class="btn-group">--%>
            <%--<button type="button" class="btn btn-default dropdown-toggle btn-top note-sel" data-toggle="dropdown"--%>
            <%--aria-haspopup="true"--%>
            <%--aria-expanded="false">--%>
            <%--筛选 <span class="caret"></span>--%>
            <%--</button>--%>
            <%--<ul class="dropdown-menu">--%>
            <%--<li id="all"><a href="javascript:">所有</a></li>--%>
            <%--<li role="separator" class="divider"></li>--%>
            <%--<li id="rules"><a href="javascript:">规章制度</a></li>--%>
            <%--<li id="brief"><a href="javascript:">简报</a></li>--%>
            <%--<li id="notice"><a href="javascript:">通知</a></li>--%>
            <%--<li id="infor"><a href="javascript:">信息动态</a></li>--%>
            <%--</ul>--%>
            <%--</div>--%>
            <div id="list_1" class="none">
                <div class="mail-head">
                    <h4>写邮件</h4>
                </div>
                <div class="sendBox">
                    <div class="send-cont">
                        <form class="form-horizontal" id="mail_form">
                            <div class="form-group">
                                <label for="mail_sjr" class="col-sm-2 control-label">收件单位</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="mail_sjr" name="" placeholder="收件单位" readonly>
                                    <input type="text" class="form-control none" id="mail_sjr_hide" name="sjr" placeholder="收件单位">
                                    <input type="text" class="form-control none" id="uploadDir" name="uploadDir" placeholder="uploadDir" value="gzxx">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mail_zt" class="col-sm-2 control-label">主题</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="mail_zt" name="zt" placeholder="主题">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="file" class="none" name="file" id="mail_file" style="display: none">
                                <div class="col-sm-offset-2 col-sm-10" id="mail_fj">
                                    <span class="glyphicon glyphicon-paperclip"></span> 附件
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mail_zw" class="col-sm-2 control-label">正文</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="8" name="zw" id="mail_zw"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mail_sjr" class="col-sm-2 control-label">发件单位</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control defaultName" id="mail_fjr" name="fjr">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" class="btn btn-primary" id="btn_mailSend">发送</button>
                                    <button type="button" class="btn btn-default" id="btn_mailInBag">存草稿</button>
                                    <button type="button" class="btn btn-default" id="btn_mailClose">关闭</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="send-contacts">
                        <h5>最近联系人<span class="pull-right cursor">清空</span></h5>
                        <input type="text" class="form-control input-sm" placeholder="查找联系人">
                        <div class="contacts-list"></div>
                    </div>
                </div>
            </div>
            <div id="list_2">
                <div class="mail-head">
                    <h4>收件箱<span class="sub-title">（共<span class="totalNum">0</span>封）</span></h4>
                    <a class="pull-right" href="javascript:" style="margin-left: 10px" onclick="deleteYj()">删除</a>
                    <a class="pull-right mgr-10" href="javascript:" onclick="zfYj()">转发</a>
                </div>
                <table class="table table-sm" id="send_table2">
                    <tr>
                        <th width="15%"> <input type="checkbox" value="" class="allCheck">发件人</th>
                        <th width="70%">主题</th>
                        <th width="15%">日期</th>
                        <%--<th width="10%">附件</th>--%>
                    </tr>
                    <%--<tr>--%>
                        <%--<td colspan="5" style="color: #1e5494;border-bottom: 2px solid #666;font-weight: 600">今天 <span style="font-weight: normal">(2封)</span></td>--%>
                    <%--</tr>--%>
                    <%--<tr class="cursor">--%>
                        <%--<td>--%>
                            <%--<input class="td-mid" type="checkbox" value="" style="margin-top: -3px">--%>
                            <%--<span class="td-mid">张伞</span>--%>
                        <%--</td>--%>
                        <%--<td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>--%>
                        <%--<td>--%>
                            <%--<span class="td-text">2017-03-21</span>--%>
                            <%--<span class="icon-star star0 inline"></span>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr class="cursor">--%>
                        <%--<td>--%>
                            <%--<input class="td-mid" type="checkbox" value="" style="margin-top: -3px">--%>
                            <%--<span class="td-mid">张伞</span>--%>
                        <%--</td>--%>
                        <%--<td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>--%>
                        <%--<td>--%>
                            <%--<span class="td-text">2017-03-21</span>--%>
                            <%--<span class="icon-star star0 inline"></span>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td colspan="5" style="color: #1e5494;border-bottom: 2px solid #666;font-weight: 600">昨天天 <span style="font-weight: normal">(2封)</span></td>--%>
                    <%--</tr>--%>
                    <%--<tr class="cursor">--%>
                        <%--<td>--%>
                            <%--<input class="td-mid" type="checkbox" value="" style="margin-top: -3px">--%>
                            <%--<span class="td-mid">张伞</span>--%>
                        <%--</td>--%>
                        <%--<td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>--%>
                        <%--<td>--%>
                            <%--<span class="td-text">2017-03-21</span>--%>
                            <%--<span class="icon-star star0 inline"></span>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr class="cursor">--%>
                        <%--<td>--%>
                            <%--<input class="td-mid" type="checkbox" value="" style="margin-top: -3px">--%>
                            <%--<span class="td-mid">张伞</span>--%>
                        <%--</td>--%>
                        <%--<td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>--%>
                        <%--<td>--%>
                            <%--<span class="td-text">2017-03-21</span>--%>
                            <%--<span class="icon-star star0 inline"></span>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                </table>
                <ul id="receivePager" class="pagination pull-right"></ul>
            </div>
            <div id="list_3" class="none">
                <div class="mail-head">
                    <h4>发件箱<span class="sub-title">（共<span class="totalNum">0</span>封）</span></h4>
                    <a class="pull-right" href="javascript:" style="margin-left: 10px" onclick="deleteYj()">删除</a>
                    <a class="pull-right mgr-10" href="javascript:" onclick="zfYj()">转发</a>
                </div>
                <table class="table table-sm" id="send_table3">
                    <tr>
                        <th width="15%"> <input type="checkbox" value="" class="allCheck">发件人</th>
                        <th width="70%">主题</th>
                        <th width="15%">日期</th>
                        <%--<th width="10%">附件</th>--%>
                    </tr>
                    <%--<tr>--%>
                        <%--<td colspan="5" style="color: #1e5494;border-bottom: 2px solid #666;font-weight: 600">今天 <span style="font-weight: normal">(2封)</span></td>--%>
                    <%--</tr>--%>
                    <%--<tr class="cursor">--%>
                        <%--<td>--%>
                            <%--<input class="td-mid" type="checkbox" value="" style="margin-top: -3px">--%>
                            <%--<span class="td-mid">张伞</span>--%>
                        <%--</td>--%>
                        <%--<td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>--%>
                        <%--<td>--%>
                            <%--<span class="td-text">2017-03-21</span>--%>
                            <%--<span class="icon-star star0 inline"></span>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr class="cursor">--%>
                        <%--<td>--%>
                            <%--<input class="td-mid" type="checkbox" value="" style="margin-top: -3px">--%>
                            <%--<span class="td-mid">张伞</span>--%>
                        <%--</td>--%>
                        <%--<td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>--%>
                        <%--<td>--%>
                            <%--<span class="td-text">2017-03-21</span>--%>
                            <%--<span class="icon-star star0 inline"></span>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td colspan="5" style="color: #1e5494;border-bottom: 2px solid #666;font-weight: 600">昨天天 <span style="font-weight: normal">(2封)</span></td>--%>
                    <%--</tr>--%>
                    <%--<tr class="cursor">--%>
                        <%--<td>--%>
                            <%--<input class="td-mid" type="checkbox" value="" style="margin-top: -3px">--%>
                            <%--<span class="td-mid">张伞</span>--%>
                        <%--</td>--%>
                        <%--<td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>--%>
                        <%--<td>--%>
                            <%--<span class="td-text">2017-03-21</span>--%>
                            <%--<span class="icon-star star0 inline"></span>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr class="cursor">--%>
                        <%--<td>--%>
                            <%--<input class="td-mid" type="checkbox" value="" style="margin-top: -3px">--%>
                            <%--<span class="td-mid">张伞</span>--%>
                        <%--</td>--%>
                        <%--<td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>--%>
                        <%--<td>--%>
                            <%--<span class="td-text">2017-03-21</span>--%>
                            <%--<span class="icon-star star0 inline"></span>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                </table>
                <ul id="sendPager3" class="pagination pull-right"></ul>
            </div>
            <div id="list_4" class="none">
                <div class="mail-head">
                    <h4>草稿箱<span class="sub-title">（共<span class="totalNum">0</span>封）</span></h4>
                    <a class="pull-right" href="javascript:" style="margin-left: 10px" onclick="deleteYj()">删除</a>
                    <a class="pull-right mgr-10" href="javascript:" onclick="zfYj()">转发</a>
                </div>
                <table class="table table-sm" id="send_table4">
                    <tr>
                        <th width="15%"> <input type="checkbox" value="" class="allCheck">发件人</th>
                        <th width="70%">主题</th>
                        <th width="15%">日期</th>
                        <%--<th width="10%">附件</th>--%>
                    </tr>
                    <tr>
                        <td colspan="5" style="color: #1e5494;border-bottom: 2px solid #666;font-weight: 600">今天 <span style="font-weight: normal">(2封)</span></td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" style="color: #1e5494;border-bottom: 2px solid #666;font-weight: 600">昨天天 <span style="font-weight: normal">(2封)</span></td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                </table>
                <ul id="sendPager4" class="pagination pull-right"></ul>
            </div>
            <div id="list_5" class="none">
                <div class="mail-head">
                    <h4>已删除<span class="sub-title">（共<span class="totalNum">0</span>封）</span></h4>
                    <a class="pull-right" href="javascript:" style="margin-left: 10px" onclick="deleteYj()">删除</a>
                    <a class="pull-right mgr-10" href="javascript:" onclick="zfYj()">转发</a>
                </div>
                <table class="table table-sm" id="send_table5">
                    <tr>
                        <th width="15%"> <input type="checkbox" value="" class="allCheck">发件人</th>
                        <th width="70%">主题</th>
                        <th width="15%">日期</th>
                        <%--<th width="10%">附件</th>--%>
                    </tr>
                    <tr>
                        <td colspan="5" style="color: #1e5494;border-bottom: 2px solid #666;font-weight: 600">今天 <span style="font-weight: normal">(2封)</span></td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" style="color: #1e5494;border-bottom: 2px solid #666;font-weight: 600">昨天天 <span style="font-weight: normal">(2封)</span></td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                </table>
                <ul id="sendPager5" class="pagination pull-right"></ul>
            </div>
            <div id="list_6" class="none">
                <div class="mail-head">
                    <h4>顶置<span class="sub-title">（共<span class="totalNum">0</span>封）</span></h4>
                    <a class="pull-right" href="javascript:" style="margin-left: 10px" onclick="deleteYj()">删除</a>
                    <a class="pull-right mgr-10" href="javascript:" onclick="zfYj()">转发</a>
                </div>
                <table class="table table-sm" id="send_table6">
                    <tr>
                        <th width="15%"> <input type="checkbox" value="" class="allCheck">发件人</th>
                        <th width="70%">主题</th>
                        <th width="15%">日期</th>
                        <%--<th width="10%">附件</th>--%>
                    </tr>
                    <tr>
                        <td colspan="5" style="color: #1e5494;border-bottom: 2px solid #666;font-weight: 600">今天 <span style="font-weight: normal">(2封)</span></td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" style="color: #1e5494;border-bottom: 2px solid #666;font-weight: 600">昨天天 <span style="font-weight: normal">(2封)</span></td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                    <tr class="cursor">
                        <td>
                            <input class="td-mid" type="checkbox" value="" style="margin-top: -3px">
                            <span class="td-mid">张伞</span>
                        </td>
                        <td>2017年中央一号文件公布 提出深入推进农业供给侧结构性改革</td>
                        <td>
                            <span class="td-text">2017-03-21</span>
                            <span class="icon-star star0 inline"></span>
                        </td>
                    </tr>
                </table>
                <ul id="sendPager6" class="pagination pull-right"></ul>
            </div>
            <div id="list_detail" class="none">
                <div class="fgLine" style="width: 100%;border-bottom: 1px solid #c3c3c3; margin: 30px 0"></div>
                <div class="listContent"  style="padding: 0 20px">
                    <input type="text" class="listId none">
                    <h3 class="listChange listTitle">农业部办公厅关于印发《农村土地承包经营权确权登记成果制图规范（试行）》的通知（农办经（2015）23号）</h3>
                    <p class="listPeople">发件人：<span class="listChange listFjr">张三</span></p>
                    <p class="listTime">发件时间：<span class="listChange listJbsj">2017年10月20日（星期六）下午5:31</span></p>
                    <p class="listSjpeople">收件人：<span class="listChange listSjr">李四</span></p>
                    <%--<p class="detailFj">附件：<a href="javascript:void 0" class="detailChange" download></a></p>--%>
                    <textarea name="" id="listTextarea" cols="30" rows="10" style="width: 100%"></textarea>
                    <div class="listFj">附件（1个）</div>
                    <div class="listDown">
                        <img src="/images/downIcon.png" alt="">
                        <%--<a href="javascript:void (0)" class="listYl">预览</a>--%>
                        <a href="javascript:void (0)" class="listXz" download>下载</a>
                    </div>
                    <div style="margin-top: 20px">
                        <button class="btn btn-default" id="listDelete">删除</button>
                        <button class="btn btn-default" id="listDeleteCd">彻底删除</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" style="z-index: 10100;">
    <div class="modal-dialog" style="width: 45%">
        <div class="modal-content" style="background-color: #ffffff;">
            <div class="modal-body">
                <div style="padding:10px;">
                    <p class="zhdl">邮件回复</p>
                    <button type="button" class="btn delete" data-dismiss="modal">×</button>
                    <form class="form-horizontal">
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" placeholder="单位">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" placeholder="时间">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <textarea class="form-control" rows="3" placeholder="回复内容"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <a href="javascript:;" class="sjfile">
                                    <input type="file" name="attachment" id="autoupload"
                                           class="btn btn-sm btn-primary"/>
                                    <i class="icon-edit bigger-120"></i>上传附件
                                </a>
                                <span class="jobspan">&nbsp;&nbsp;请上传本地文件，大小不超过3M，格式为PDF、JPEG</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" placeholder="发件部门">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" placeholder="发件人">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6">
                                <button type="submit" class="jobbtn">发送</button>
                            </div>
                            <div class="col-sm-6">
                                <button type="submit" class="jobbtn">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal01" style="z-index: 10100;">
    <div class="modal-dialog" style="width: 45%">
        <div class="modal-content" style="background-color: #ffffff;">
            <div class="modal-body">
                <div style="padding:10px;">
                    <p class="zhdl">详情信息</p>
                    <button type="button" class="btn delete" data-dismiss="modal">×</button>
                    <div class="jobxq">
                        <p><span style=" color: #999999;">发件人：</span>xxx<12345678@qq.com> </p>
                        <p><span style=" color: #999999;">时  间：</span>2017年3月22日(星期三) 下午4:30</p>
                        <p><span style=" color: #999999;">收件人：</span>xxx<87654321@qq.com></p>
                        <div class="jobxqnr">
                            邮件内容：
                            <p>&nbsp;</p>
                            <p>&nbsp;</p>
                            <p>&nbsp;</p>
                            <p>&nbsp;</p>
                            <p>&nbsp;</p>
                            <p>&nbsp;</p>
                            <p>&nbsp;</p>
                            <p>&nbsp;</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="xiangq" style="z-index: 10101;">
    <div class="modal-dialog" style="width: 45%">
        <div class="modal-content" style="background-color: #ffffff;">
            <div class="modal-body">
                <div class="sendBox">
                    <div class="send-cont">
                        <form class="form-horizontal" id="mail_form1">
                            <div class="form-group">
                                <label for="mail_sjr" class="col-sm-2 control-label">收件单位</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="mail_sjr1" name="" placeholder="收件单位" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mail_zt" class="col-sm-2 control-label">主题</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="mail_zt1" name="zt" placeholder="主题">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mail_zw" class="col-sm-2 control-label">正文</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="8" name="zw" id="mail_zw1"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mail_sjr" class="col-sm-2 control-label">发件单位</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control defaultName" id="mail_fjr1" name="fjr">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="zfList" style="z-index: 10101;">
    <div class="modal-dialog" style="width: 30%">
        <div class="modal-content" style="background-color: #ffffff;">
            <div class="modal-header">
                <h3>联系人</h3>
            </div>
            <div class="modal-body">
                <ul class="contacts-list"></ul>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default btn-sm pull-right" style="margin-right: 20px" id="lxrCancel" data-dismiss="modal">取消</button>
                <button class="btn btn-primary btn-sm pull-right" style="margin-right: 20px" id="lxrSure" data-dismiss="modal">确定</button>
            </div>
        </div>

    </div>
</div>
<%--<div class="loader none">--%>
    <%--<div class="loader-inner line-scale-pulse-out-rapid">--%>
        <%--<div></div>--%>
        <%--<div></div>--%>
        <%--<div></div>--%>
        <%--<div></div>--%>
        <%--<div></div>--%>
    <%--</div>--%>
<%--</div>--%>
<script src="../../js/lib/jquery-3.2.1.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/lib/jquery.validate.min.js"></script>
<script src="../../js/lib/pagination.js"></script>
<script src="../../js/init.js"></script>
<script src="../../js/config.js"></script>
<script src="../../js/lib/bootbox.min.js"></script>

<!-- 皮肤切换 -->
<script type="text/javascript" src="/js/message/styleswitch.js"></script>
<!-- 导航二级菜单 -->
<script type="text/javascript" src="/js/message/leftnav.js"></script>
<!-- 滚动条 -->
<script src="/js/message/jquery.mCustomScrollbar.concat.min.js" type="text/javascript"></script>
<script src="/js/message/mCustomScrollbar.js" type="text/javascript"></script>
<!--  div可拖拽扩展-->
<script type="text/javascript" src="/js/message/jquery.divdrag.js"></script>

<script type="text/javascript" src="/js/message/createDataUtil.js"></script>
<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../js/lib/bootbox.min.js" type="text/javascript"></script>
<script src="../../js/lib/pagination.js" type="text/javascript"></script>
<!-- 右下角弹出提示窗 -->
<script type="text/javascript" src="/js/message/jquery.twbsPagination.js"></script>
<script type="text/javascript" src="/js/message/layer.js"></script>
<script type="text/javascript" src="/js/message/module.js"></script>
<script type="text/javascript" src="/js/message/uploader.js"></script>
<script type="text/javascript" src="/js/message/simditor.js"></script>
<%--<script src="loader/loaders.css.js"></script>--%>
<script type="text/javascript" src="/js/message/message.js"></script>
<script type="text/javascript">
    /*头部小图标事件 */
    var xzdw = "100000";
    $(function () {
        $(".btn-mail").on("click", function () {
            debugger;
            var options = {
                    currentPage: 1,
                    pageSize: 8,
                    recreatePager: true
                },
                id = $(this).attr("id");
            $("#mail_form")[0].reset();
            $(".btn-mail").removeClass("btn-primary").addClass("btn-default");
            $(this).toggleClass("btn-default btn-primary");
            $("div[id^='list_']").hide();
            $("#list_" + id).show();
            if (id === "1") {
                getContactData();
                $("#btn_mailInBag").show();
                $("#list_1").find("input[name=id]").remove();
            }
            else if (id === "2") {
                getMailData(options);
            }
            else if (id === "3") {
                options.xxlb = "1";
                getMailData(options);
            }
            else if (id === "4") {
                options.xxlb = "2";
                getMailData(options);
            }
            else if (id === "5") {
                options.xxlb = "3";
                getMailData(options);
            }
        });
        debugger;
        var scrollCon = $("#noteList");
        scrollCon.height($(window).height() * 0.4);
        scrollCon.mCustomScrollbar({
            theme: "dark"
        });
        scrollCon.find(".mCustomScrollBox").height(scrollCon.height());
        var editor = new Simditor({
            textarea: $('#note-content')
        });
        $('.nrimg01').click(function () {
            $('.divimg').not('.divimg01').hide();
            if ($('.divimg01').css('display') == 'block') {
                $('.divimg01').hide();
            } else {
                $('.divimg01').show();
            }
        });

        $('.nrimg02').click(function () {
            $('.divimg').not('.divimg02').hide();
            if ($('.divimg02').css('display') == 'block') {
                $('.divimg02').hide();
            } else {
                $('.divimg02').show();
            }
        });

        $('.nrimg03').click(function () {
            $('.divimg').not('.divimg03').hide();
            if ($('.divimg03').css('display') == 'block') {
                $('.divimg03').hide();
            } else {
                $('.divimg03').show();
            }
        });

        $('.nrimg04').click(function () {
            $('.divimg').not('.divimg04').hide();
            if ($('.divimg04').css('display') == 'block') {
                $('.divimg04').hide();
            } else {
                $('.divimg04').show();
            }

        });
    });
    function showTable(){
        debugger;
        $("#con_two_1").find(".btn-primary:visible").trigger("click");
    }
    /*导航效果 */
    $(function () {
        function animateEnd() {
            $(".narbody").hide();
            document.getElementsByClassName("narbody")[0].removeEventListener("animationend", animateEnd);
        }

        $('.narbtn').click(function () {
            var narbody = $(".narbody");
            if (narbody.is(":animated")) {
                narbody.stop(true, true);
            }
            var type = $(this).attr("type");
            if (type == undefined) {
                $(this).attr("type", "in");
                narbody.removeClass("allin").addClass("allout").show();
            }
            else {
                if (type == "out") {
                    $(this).attr("type", "in");
                    narbody.removeClass("allin").addClass("allout").show();
                }
                else if (type == "in") {
                    $(this).attr("type", "out");
                    narbody.removeClass("allout").addClass("allin");
                    document.getElementsByClassName("narbody")[0].addEventListener("animationend", animateEnd);
                }
            }
        });
    });
    function index_2(name, cursel, n) {
        debugger;
        getMailData({
            currentPage: 1,
            pageSize: 8,
            recreatePager: true
        });
        for (var i = 1; i <= n; i++) {
            var menu = document.getElementById(name + i);
            var con = document.getElementById("con_" + name + "_" + i);
            menu.className = i == cursel ? "hover" : "";
            con.style.display = i == cursel ? "block" : "none";
        }
    }
    $(function () {
        $("#quanxuan").change(function () {
            debugger;

            $("input[name=chk]").each(function () {

                debugger;

                if ($('#quanxuan').prop('checked')) {

                    $(this).prop('checked', true);

                } else {

                    $(this).prop('checked', false);

                }

            });
        });
        $("#fjx_quanxuan").change(function () {

            debugger;
            $("input[name=chk]").each(function () {

                debugger;

                if ($('#fjx_quanxuan').prop('checked')) {

                    $(this).prop('checked', true);

                } else {

                    $(this).prop('checked', false);

                }

            });
        });
    });
    var showPopup = function (pixel) {
        $('#myModal').modal('show');
        $('#myModal').on('shown.bs.modal', function (e) {


        });
    };

    var showPopup01 = function (pixel) {
        $('#myModal01').modal('show');
        $('#myModal01').on('shown.bs.modal', function (e) {


        });
    };
    $(function () {
        $('#jobbtn').click(function () {
            debugger;
            layer.ready(function () {
                layer.open({
                    type: 1,
                    offset: 'rb',
                    content: '<div class="text-primary" style="padding: 20px 80px; white-space: nowrap;"><span class="glyphicon glyphicon-send text-primary"></span> 邮件已发送成功</div>',
                    shade: 0,
                    skin: 'layui-layer-lan',
                    closeBtn: 1,
                    anim: 3,
                    cancel: function () {
                        layer.open({
                            type: 1,
                            offset: 'rb',
                            content: '<div class="text-primary" style="padding: 20px 80px; white-space: nowrap;"><span class="glyphicon glyphicon-send text-primary"></span> <a onclick="index_2(\'two\',2,3)">您有5封邮件未读！</a></div>',
                            shade: 0,
                            skin: 'layui-layer-lan',
                            closeBtn: 1,
                            anim: 3
                        });
                    }
                });
            });
        });

    })


</script>

</body>
</html>
