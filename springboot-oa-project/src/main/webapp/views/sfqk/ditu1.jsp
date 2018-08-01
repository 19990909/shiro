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
        #main1{
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
<div id="main1" style="margin-top:5px"></div>
  <script type="text/javascript">
      $(document).ready(function () {
          // 基于准备好的dom，初始化echarts实例
          var myChart3 = echarts.init(document.getElementById('main1'));
          // 秋雁南飞：
// 此版本通过设置geoindex && seriesIndex: [1] 属性来实现geo和map共存，来达到hover散点和区域显示tooltip的效果
// 默认情况下，map series 会自己生成内部专用的 geo 组件。但是也可以用这个 geoIndex 指定一个 geo 组件。这样的话，map 和 其他 series（例如散点图）就可以共享一个 geo 组件了。并且，geo 组件的颜色也可以被这个 map series 控制，从而用 visualMap 来更改。
// 当设定了 geoIndex 后，series-map.map 属性，以及 series-map.itemStyle 等样式配置不再起作用，而是采用 geo 中的相应属性。
// http://echarts.baidu.com/option.html#series-map.geoIndex
// 并且加了pin气泡图标以示数值大小
// // 全局变量区:参考江西绿色金融（谢谢：本来想用闭包实现接口数据调用，没时间了）

// 本图作者：参考秋雁南飞的《投票统计》一图，网址：http://gallery.echartsjs.com/editor.html?c=xrJU-aE-LG
          var name_title = "各省承包地确权完成情况"
          var subname = '此数据会根据每次月报数据进行更新'
          var nameColor = " rgb(55, 75, 113)"
          var name_fontFamily = '等线'
          var subname_fontSize = 15
          var name_fontSize = 18
          var mapName = 'china'
          var data = [
              {name:"北京",value:0.99},
              {name:"天津",value:0.7},
              {name:"河北",value:0.6},
              {name:"山西",value:0.7},
              {name:"内蒙古",value:0.87},
              {name:"辽宁",value:0.23},
              {name:"吉林",value:0.65},
              {name:"黑龙江",value:0.54},
              {name:"上海",value:0.63},
              {name:"江苏",value:0.56},
              {name:"浙江",value:0.46},
              {name:"安徽",value:0.75},
              {name:"福建",value:0.45},
              {name:"江西",value:0.98},
              {name:"山东",value:0.95},
              {name:"河南",value:0.34},
              {name:"湖北",value:0.24},
              {name:"湖南",value:0.92},
              {name:"重庆",value:0.98},
              {name:"四川",value:0.12},
              {name:"贵州",value:0.67},
              {name:"云南",value:0.33},
              {name:"西藏",value:0.42},
              {name:"陕西",value:0.80},
              {name:"甘肃",value:0.16},
              {name:"青海",value:0.67},
              {name:"宁夏",value:0.89},
              {name:"新疆",value:0.99},
              {name:"广东",value:0.46},
              {name:"广西",value:0.59},
              {name:"海南",value:0.14},
          ];

          var geoCoordMap = {};
          var toolTipData = [
              {name:"北京",value:[{name:"确权承包地面积",value:2300},{name:"颁发承包经营权证书数",value:89}]},
              {name:"天津",value:[{name:"确权承包地面积",value:3000},{name:"颁发承包经营权证书数",value:56}]},
              {name:"河北",value:[{name:"确权承包地面积",value:1500},{name:"颁发承包经营权证书数",value:78}]},
              {name:"山西",value:[{name:"确权承包地面积",value:3200},{name:"颁发承包经营权证书数",value:78}]},
              {name:"内蒙古",value:[{name:"确权承包地面积",value:4510},{name:"颁发承包经营权证书数",value:67}]},
              {name:"辽宁",value:[{name:"确权承包地面积",value:789},{name:"颁发承包经营权证书数",value:89}]},
              {name:"吉林",value:[{name:"确权承包地面积",value:345},{name:"颁发承包经营权证书数",value:41}]},
              {name:"黑龙江",value:[{name:"确权承包地面积",value:8900},{name:"颁发承包经营权证书数",value:31}]},
              {name:"上海",value:[{name:"确权承包地面积",value:6432},{name:"颁发承包经营权证书数",value:76}]},
              {name:"江苏",value:[{name:"确权承包地面积",value:2364},{name:"颁发承包经营权证书数",value:35}]},
              {name:"浙江",value:[{name:"确权承包地面积",value:5600},{name:"颁发承包经营权证书数",value:234}]},
              {name:"安徽",value:[{name:"确权承包地面积",value:5120},{name:"颁发承包经营权证书数",value:35}]},
              {name:"福建",value:[{name:"确权承包地面积",value:645},{name:"颁发承包经营权证书数",value:23}]},
              {name:"江西",value:[{name:"确权承包地面积",value:6543},{name:"颁发承包经营权证书数",value:56}]},
              {name:"山东",value:[{name:"确权承包地面积",value:4567},{name:"颁发承包经营权证书数",value:89}]},
              {name:"河南",value:[{name:"确权承包地面积",value:3456},{name:"颁发承包经营权证书数",value:546}]},
              {name:"湖北",value:[{name:"确权承包地面积",value:245},{name:"颁发承包经营权证书数",value:57}]},
              {name:"湖南",value:[{name:"确权承包地面积",value:3400},{name:"颁发承包经营权证书数",value:670}]},
              {name:"重庆",value:[{name:"确权承包地面积",value:207},{name:"颁发承包经营权证书数",value:67}]},
              {name:"四川",value:[{name:"确权承包地面积",value:2300},{name:"颁发承包经营权证书数",value:789}]},
              {name:"贵州",value:[{name:"确权承包地面积",value:6700},{name:"颁发承包经营权证书数",value:30}]},
              {name:"云南",value:[{name:"确权承包地面积",value:123},{name:"颁发承包经营权证书数",value:41}]},
              {name:"西藏",value:[{name:"确权承包地面积",value:7890},{name:"颁发承包经营权证书数",value:56}]},
              {name:"陕西",value:[{name:"确权承包地面积",value:5467},{name:"颁发承包经营权证书数",value:45}]},
              {name:"甘肃",value:[{name:"确权承包地面积",value:3456},{name:"颁发承包经营权证书数",value:90}]},
              {name:"青海",value:[{name:"确权承包地面积",value:8906},{name:"颁发承包经营权证书数",value:65}]},
              {name:"宁夏",value:[{name:"确权承包地面积",value:6578},{name:"颁发承包经营权证书数",value:55}]},
              {name:"新疆",value:[{name:"确权承包地面积",value:997},{name:"颁发承包经营权证书数",value:90}]},
              {name:"广东",value:[{name:"确权承包地面积",value:4467},{name:"颁发承包经营权证书数",value:36}]},
              {name:"广西",value:[{name:"确权承包地面积",value:998},{name:"颁发承包经营权证书数",value:99}]},
              {name:"海南",value:[{name:"确权承包地面积",value:789},{name:"颁发承包经营权证书数",value:76}]},
          ];

          /*获取地图数据*/
          myChart3.showLoading();
          var mapFeatures = echarts.getMap(mapName).geoJson.features;
          myChart3.hideLoading();
          mapFeatures.forEach(function(v) {
              // 地区名称
              var name = v.properties.name;
              // 地区经纬度
              geoCoordMap[name] = v.properties.cp;

          });

// console.log("============geoCoordMap===================")
// console.log(geoCoordMap)
// console.log("================data======================")
          console.log(data)
          console.log(toolTipData)
          var max = 480,
              min = 9; // todo
          var maxSize4Pin = 100,
              minSize4Pin = 20;

          var convertData = function(data) {
              var res = [];
              for (var i = 0; i < data.length; i++) {
                  var geoCoord = geoCoordMap[data[i].name];
                  if (geoCoord) {
                      res.push({
                          name: data[i].name,
                          value: geoCoord.concat(data[i].value),
                      });
                  }
              }
              return res;
          };
          option = {
              title: {
                  text: name_title,
                  subtext: subname,
                  x: 'center',
                  textStyle: {
                      color: nameColor,
                      fontFamily: name_fontFamily,
                      fontSize: name_fontSize
                  },
                  subtextStyle:{
                      fontSize:subname_fontSize,
                      fontFamily:name_fontFamily
                  }
              },
              tooltip: {
                  trigger: 'item',
                  formatter: function(params) {
                      if (typeof(params.value)[2] == "undefined") {
                          var toolTiphtml = ''
                          for(var i = 0;i<toolTipData.length;i++){
                              if(params.name==toolTipData[i].name){
                                  toolTiphtml += toolTipData[i].name+':<br>'
                                  for(var j = 0;j<toolTipData[i].value.length;j++){
                                      toolTiphtml+=toolTipData[i].value[j].name+':'+toolTipData[i].value[j].value+"<br>"
                                  }
                              }
                          }
                          console.log(toolTiphtml)
                          // console.log(convertData(data))
                          return toolTiphtml;
                      } else {
                          var toolTiphtml = ''
                          for(var i = 0;i<toolTipData.length;i++){
                              if(params.name==toolTipData[i].name){
                                  toolTiphtml += toolTipData[i].name+':<br>'
                                  for(var j = 0;j<toolTipData[i].value.length;j++){
                                      toolTiphtml+=toolTipData[i].value[j].name+':'+toolTipData[i].value[j].value+"<br>"
                                  }
                              }
                          }
                          console.log(toolTiphtml)
                          // console.log(convertData(data))
                          return toolTiphtml;
                      }
                  }
              },
              // legend: {
              //     orient: 'vertical',
              //     y: 'bottom',
              //     x: 'right',
              //     data: ['credit_pm2.5'],
              //     textStyle: {
              //         color: '#fff'
              //     }
              // },
              visualMap: {
                  show: true,
                  min: 0,
                  max: 1,
                  left: 'left',
                  top: 'bottom',
                  text: ['高', '低'], // 文本，默认为数值文本
                  calculable: true,
                  seriesIndex: [1],
                  inRange: {
                      // color: ['#3B5077', '#031525'] // 蓝黑
                      // color: ['#ffc0cb', '#800080'] // 红紫
                      // color: ['#3C3B3F', '#605C3C'] // 黑绿
                      // color: ['#0f0c29', '#302b63', '#24243e'] // 黑紫黑
                      // color: ['#23074d', '#cc5333'] // 紫红
                      color: ['#00467F', '#A5CC82'] // 蓝绿
                      // color: ['#1488CC', '#2B32B2'] // 浅蓝
                      // color: ['#00467F', '#A5CC82'] // 蓝绿
                      // color: ['#00467F', '#A5CC82'] // 蓝绿
                      // color: ['#00467F', '#A5CC82'] // 蓝绿
                      // color: ['#00467F', '#A5CC82'] // 蓝绿

                  }
              },
              /*工具按钮组*/
              // toolbox: {
              //     show: true,
              //     orient: 'vertical',
              //     left: 'right',
              //     top: 'center',
              //     feature: {
              //         dataView: {
              //             readOnly: false
              //         },
              //         restore: {},
              //         saveAsImage: {}
              //     }
              // },
              geo: {
                  show: true,
                  map: mapName,
                  label: {
                      normal: {
                          show: false
                      },
                      emphasis: {
                          show: false,
                      }
                  },
                  roam: true,
                  itemStyle: {
                      normal: {
                          areaColor: '#031525',
                          borderColor: '#3B5077',
                      },
                      emphasis: {
                          areaColor: '#2B91B7',
                      }
                  }
              },
              series: [{
                  name: '散点',
                  type: 'scatter',
                  coordinateSystem: 'geo',
                  data: convertData(data),
                  symbolSize: function(val) {
                      return val[2] / 10;
                  },
                  label: {
                      normal: {
                          formatter: '{b}',
                          position: 'right',
                          show: true
                      },
                      emphasis: {
                          show: true
                      }
                  },
                  itemStyle: {
                      normal: {
                          color: '#05C3F9'
                      }
                  }
              },
                  {
                      type: 'map',
                      map: mapName,
                      geoIndex: 0,
                      aspectScale: 0.75, //长宽比
                      showLegendSymbol: false, // 存在legend时显示
                      label: {
                          normal: {
                              show: true
                          },
                          emphasis: {
                              show: false,
                              textStyle: {
                                  color: '#fff'
                              }
                          }
                      },
                      roam: true,
                      itemStyle: {
                          normal: {
                              areaColor: '#031525',
                              borderColor: '#3B5077',
                          },
                          emphasis: {
                              areaColor: '#2B91B7'
                          }
                      },
                      animation: false,
                      data: data
                  },
                  {
                      name: '点',
                      type: 'scatter',
                      coordinateSystem: 'geo',
                      symbol: 'pin', //气泡
                      symbolSize: function(val) {
                          var a = (maxSize4Pin - minSize4Pin) / (max - min);
                          var b = minSize4Pin - a * min;
                          b = maxSize4Pin - a * max;
                          return a * val[2] + b;
                      },
                      label: {
                          normal: {
                              show: true,
                              textStyle: {
                                  color: '#fff',
                                  fontSize: 9,
                              }
                          }
                      },
                      itemStyle: {
                          normal: {
                              color: '#F62157', //标志颜色
                          }
                      },
                      zlevel: 6,
                      data: convertData(data),
                  },
                  {
                      name: 'Top 5',
                      type: 'effectScatter',
                      coordinateSystem: 'geo',
                      data: convertData(data.sort(function(a, b) {
                          return b.value - a.value;
                      }).slice(0, 5)),
                      symbolSize: function(val) {
                          return val[2] / 10;
                      },
                      showEffectOn: 'render',
                      rippleEffect: {
                          brushType: 'stroke'
                      },
                      hoverAnimation: true,
                      label: {
                          normal: {
                              formatter: '{b}',
                              position: 'right',
                              show: true
                          }
                      },
                      itemStyle: {
                          normal: {
                              color: 'yellow',
                              shadowBlur: 10,
                              shadowColor: 'yellow'
                          }
                      },
                      zlevel: 1
                  },

              ]
          };

          myChart3.setOption(option);
      });
  </script>
 </body>
</html>