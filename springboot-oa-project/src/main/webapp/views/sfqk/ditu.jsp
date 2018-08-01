<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title>确权登记系统</title>
    <!-- jq -->
    <script src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script src="${ctx}/js/echarts.js"></script>
    <script src="http://echarts.baidu.com/asset/map/js/china.js"></script>

    <!-- bootstrap -->
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/js/bootstrap.min.js"></script>

    <!-- 分页插件 -->
    <link href="${ctx}/css/bootstrap-table.min.css" rel="stylesheet">
    <script src="${ctx}/js/bootstrap-table.js"></script>
    <script src="${ctx}/js/bootstrap-table-locale-all.min.js"></script>

    <!--layer -->
    <link href="${ctx}/js/layer/theme/default/layer.css" rel="stylesheet">
    <style type="text/css">
        .panel {
            margin-left: -48px;
            width: 1145px;
        }

        .col-sm-12 {
            margin-left: -60px;
        }
        #main{
            width: 100%;
            height: 500px;
        }
        thead {
            background: #428bca;
            color: white;
        }
    </style>
</head>
<body>
<div id="main" style="margin-top:5px"></div>
  <script type="text/javascript">
      $(document).ready(function () {
          // 基于准备好的dom，初始化echarts实例
          var myChart3 = echarts.init(document.getElementById('main'));


          option = {
              title: {
                  text: '各省实测承包地面积情况',
                  subtext: '纯属虚构',
                  left: 'center'
              },
              tooltip: {
                  trigger: 'item'
              },
              legend: {
                  orient: 'vertical',
                  left: 'left',
                  data: ['sccbdmj']
              },
              visualMap: {
                  min: 0,
                  max: 10000,
                  left: 'left',
                  top: 'bottom',
                  text: ['高', '低'], // 文本，默认为数值文本
                  calculable: true
              },
              toolbox: {
                  show: true,
                  orient: 'vertical',
                  left: 'right',
                  top: 'center',
                  feature: {
                      dataView: {
                          readOnly: false
                      },
                      restore: {},
                      saveAsImage: {}
                  }
              },
              series: [{
                  name: 'sccbdmj',
                  type: 'map',
                  mapType: 'china',
                  roam: false,
                  label: {
                      normal: {
                          show: true
                      },
                      emphasis: {
                          show: true
                      }
                  },
                  data: [{
                      name: '北京',
                      value: 3245
                  },
                      {
                          name: '天津',
                          value: 3478
                      },
                      {
                          name: '上海',
                          value:6700
                      },
                      {
                          name: '重庆',
                          value: 4567
                      },
                      {
                          name: '河北',
                          value: 2456
                      },
                      {
                          name: '河南',
                          value: 4373
                      },
                      {
                          name: '云南',
                          value: 1478
                      },
                      {
                          name: '辽宁',
                          value: 3456
                      },
                      {
                          name: '黑龙江',
                          value: 9087
                      },
                      {
                          name: '湖南',
                          value: 3456
                      },
                      {
                          name: '安徽',
                          value: 5890
                      },
                      {
                          name: '山东',
                          value: 9765
                      },
                      {
                          name: '新疆',
                          value: 5789
                      },
                      {
                          name: '江苏',
                          value: 4567
                      },
                      {
                          name: '浙江',
                          value: 2790
                      },
                      {
                          name: '江西',
                          value: 8322
                      },
                      {
                          name: '湖北',
                          value: 6789
                      },
                      {
                          name: '广西',
                          value: 2457
                      },
                      {
                          name: '甘肃',
                          value: 7435
                      },
                      {
                          name: '山西',
                          value:3456
                      },
                      {
                          name: '内蒙古',
                          value: 6600
                      },
                      {
                          name: '陕西',
                          value: 8967},
                      {
                          name: '吉林',
                          value: 5678
                      },
                      {
                          name: '福建',
                          value:2678
                      },
                      {
                          name: '贵州',
                          value:9878
                      },
                      {
                          name: '广东',
                          value: 2098
                      },
                      {
                          name: '青海',
                          value: 2890
                      },
                      {
                          name: '西藏',
                          value: 7643
                      },
                      {
                          name: '四川',
                          value: 6655
                      },
                      {
                          name: '宁夏',
                          value: 4567
                      },
                      {
                          name: '海南',
                          value: 8966
                      },
                      {
                          name: '台湾',
                          value: 0
                      },
                      {
                          name: '香港',
                          value: 0
                      },
                      {
                          name: '澳门',
                          value: 0
                      }
                  ]
              },
              ]
          };

          myChart3.setOption(option);
      });
  </script>
 </body>
</html>