<template>
  <!-- <div class="app-container" style="background-color: #a8acc9"> -->
  <div class="app-container background" style="background-repeat: no-repeat;background-attachment: fixed;background-size: cover;">
    <!-- <div ref="myChart"
      style="width: 400px; height: 400px; background-color: #ffffff; padding: 20px; border-radius: 20px;">
    </div> -->
    
    <div style="display: flex; text-align: center;">
      <dv-border-box-8 style="width: 100%; height: 250px;">
        <div style="display: flex; align-items: center; justify-content: space-evenly; padding-left: 15px; color: azure;">
          <dv-loading style="width: fit-content;">日程进度</dv-loading>
          <!-- <div ref="circleChart1" style="height: 250px; width: 250px;"></div>
          <div ref="circleChart2" style="height: 250px; width: 250px;"></div>
          <div ref="circleChart3" style="height: 250px; width: 250px;"></div>
          <div ref="circleChart4" style="height: 250px; width: 250px;"></div>
          <div ref="circleChart5" style="height: 250px; width: 250px;"></div> -->
          <!-- <div v-for="(item, index) in circleChartData" :key="'index'" :id="`circleChart${index}`" style="height: 250px; width: 250px;">
          </div> -->
          <div :id="`circleChart0`" style="height: 250px; width: 250px;"></div>
          <div :id="`circleChart1`" style="height: 250px; width: 250px;"></div>
          <div :id="`circleChart2`" style="height: 250px; width: 250px;"></div>
          <div :id="`circleChart3`" style="height: 250px; width: 250px;"></div>
          <div :id="`circleChart4`" style="height: 250px; width: 250px;"></div>
        </div>
      </dv-border-box-8>
    </div>
    <dv-decoration-10 style="width:100%;height:5px;" />

    <div style="display: flex; text-align: center; height: max-content; justify-content: space-between;">
      <dv-border-box-10 style="width: 30%; height: 100%;" class="border-box">
        <div style="padding: 10px 10px 10px 10px;">
          <h2 style="color: #3de7c9;">日程及时率</h2>
          <dv-scroll-ranking-board :config="config" style="width: 100%; height:500px;"/>
        </div>
      </dv-border-box-10>
      <div style="width: 66%; display: flex; flex-direction: column;">
        <div style="display: flex; justify-content: space-between;">
          <div style="height: 300px; width:300px;">
            <div ref="pieChart" style="height: 250px; width: 250px;" :id="'pieChart'"></div>
          </div>
          <div style="height: 300px; width: 70%; ">
            <dv-scroll-board :config="commitData" style="" />
          </div>
        </div>

        <dv-decoration-2 style="height:5px;" />
        <div>
          <dv-border-box-12 class="border-box">
            <div style="display: flex; justify-content: space-around;">

              <div style="display:flex; flex-direction: column;">
                <h2 style="color: #3de7c9; width: 250px">日程均分</h2>
                <dv-capsule-chart :config="scoreData" style="width:250px;height:215px"/>
              </div>

              <div style="display:flex; flex-direction: column;">
                <h2 style="color: #3de7c9; width: 250px">每月时长</h2>
                <!-- <dv-capsule-chart :config="scoreData" style="width:300px;height:215px"/> -->
                <div ref="eachMonthTimeChart" style="width:250px;height:230px"></div>
              </div>

              <div style="display:flex; flex-direction: column;">
                <h2 style="color: #3de7c9; width: 250px">日程总时长</h2>
                <div ref="totalTimeChart" style="width:250px;height:230px"></div>
              </div>

            </div>
          </dv-border-box-12>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import * as echarts from 'echarts';
import { getProgress, getTotalLasting, getComment, getTimely, getScore, getMonthTime } from "@/api/data/view";

export default {
  name: "View",
  components:
  {
  },
  setup () {
  },
  data () {
    return {
      activeName: '1',
      // 日程进度数据
      circleChartData: [
        // { value: 0, name: "1123" },
        // { value: 0, name: "2263" },
        // { value: 20, name: "日程1" },
        // { value: 5, name: "1" },
      ],
      // 日程及时率数据
      config: {
        data: [
          // {
          //   name: "2263",
          //   value: 0,
          // },
          // {
          //   name: "1123",
          //   value: 0,
          // },
          // {
          //   name: "日程1",
          //   value: 100,
          // },
          // {
          //   name: "1",
          //   value: 66.7,
          // },
        ],
        rowNum: 10,
        waitTime: 10000,
      },
      // 评论数据
      commitData: {
        header: ['项目名', '日期', '评论'],
        data: [
          // ['日程1', '2024-03-06 03:00', '非常不错'],
          // ['1', '2024-04-07 00:48', ''],
          // ['1', '2024-04-18 01:51', '完成的很好'],
        ],
        columnWidth: [50, 100, 200],
        index: true,
      },
      // 日程均分数据
      scoreData: {
        data: [
          // {
          //   name: '1',
          //   value: 3.75
          // },
          // {
          //   name: '日程1',
          //   value: 3.0
          // },
          // {
          //   name: '1123',
          //   value: 0
          // },
          // {
          //   name: '2263',
          //   value: 0
          // },
        ],

        showValue: true,
      },
      // 日程完成时长数据
      pieChartData: [
        // { name: "1", value: 4.3 },
        // { name: "日程1", value: 2},
      ],
      // 日程总时长数据
      TotalTimeChartData: [
        // { value: 0, name: "2263" },
        // { value: 0, name: "1123" },
        // { value: 47, name: "日程1" },
        // { value: 15, name: "1" },
      ],
      // 每月时长
      eachMonthTimeData: [
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
      ],
    };
  },
  created () {
    // this.initData();
  },
  methods: {
    initData(){
      getProgress().then(response => {
        response.rows.forEach(element => {
          var progress =
          {
            name:element.itemName,
            value:parseInt(element.totalTime * 100 / element.durationTime),
          };
          if(progress.value > 100) progress.value = 100;
          if(progress.value < 0) progress.value = 0;

          this.circleChartData.push(progress);
        });
        this.setCircleChart();
      });

      getTotalLasting().then(response => {
        console.log(response.rows);
        response.rows.forEach(element => {
          var lasting =
          {
            name:element.itemName,
            value:element.totalLasting,
          };
          this.pieChartData.push(lasting);

          var totalTime = 
          {
            name: element.itemName,
            value: parseInt(element.totalLasting / 3600),
          }
          this.TotalTimeChartData.push(totalTime);
        });
        this.setPieChart();
        this.setTotalTimeChart();
      });

      getComment().then(response => {
        response.rows.forEach(element => {
          var comment =
          [element.itemName, element.date.slice(0,10) + " " + element.date.slice(11,16), element.comment];
          this.commitData.data.push(comment);
        });
        this.commitData = {...this.commitData};
      });

      getTimely().then(response => {
        response.rows.forEach(element => {
          var timely = {
            name: element.itemName, 
            value: parseInt(element.timelySum * 100 / element.itemCount)};
          this.config.data.push(timely);
        });
        this.config = {...this.config};
      });

      getScore().then(response => {
        response.rows.forEach(element => {
          var score = {
            name: element.itemName,
            value: Math.round(element.avgScore * 100) / 100
          };
          this.scoreData.data.push(score);
        });
        this.scoreData = {...this.scoreData};
      });

      getMonthTime().then(response => {
        response.rows.forEach(element => {
          this.eachMonthTimeData[parseInt(element.month)] = element.totalTime;
        });
        this.eachMonthTimeChart();
      });
    },
    setCircleChart() {
      this.circleChartData.map((item, i) =>{
        const myChart = echarts.init(document.getElementById(`circleChart${i}`));
        let config = {
          series: [
            {
              name: '进度',
              type: 'gauge',
              center: ['50%', '55%'],
              radius: '75%',
              min: 0,
              max: 100,
              itemStyle: {
                color: {
                  colorStops:
                  [{
                    offset: 0,
                    color: '#02d6fc' // 0% 处的颜色
                  }, {
                    offset: 1,
                    color: '#367bec' // 100% 处的颜色
                  }],
                },
                shadowColor: 'rgba(0,138,255,0.45)'
              },
              // 进度条
              progress: {
                show: true,
                width: 20,
                roundCap: true
              },
              // 坐标轴线
              axisLine: {
                show: true,
                roundCap: true,
                lineStyle: {
                  width: 20
                }
              },
              // 仪表盘指针
              pointer: {
                show: false
              },
              // 刻度标签
              axisLabel: {
                show: false
              },
              // 刻度
              axisTick: {
                show: false
              },
              // 分隔线
              splitLine: {
                show: false
              },
              title: {
                offsetCenter: [0, '20%'],
                // fontSize: 20,
                textStyle: 
                {
                  color: '#1ed3e5',
                  fontSize: 20
                },
              },
              detail: {
                offsetCenter: [0, '-10%'],
                valueAnimation: true,
                textStyle: 
                {
                  color: '#1ed3e5',
                  fontSize: 30
                },
                formatter: '{value}'
              },
              data: [
                { value: item.value, name: item.name }
              ]
            },
          ],
        };
        myChart.setOption(config);
      });
    },
    setPieChart() {
      // 基于准备好的dom，初始化echarts实例
      this.pieChart = echarts.init(this.$refs.pieChart)
      // let EChart = this.$echarts.init(document.getElementById("circleChart1"));
      // 配置参数
      let config = {
        title: {
          text: '日程完成时长占比',
          left: 'center',
          top: 'top',
          textStyle: {
            fontWeight: 'bolder',
            color: '#96bfff'
          },
        },
        series: [
          {
            text: '日程进行时长比例',
            type: 'pie',
            center: ['50%', '55%'],
            radius: '75%',
            // 设置值域的标签
            label: {
              normal: {
                position: 'inner',  // 设置标签位置，默认在饼状图外 可选值：'outer' ¦ 'inner（饼状图上）'
                // formatter: '{a} {b} : {c}个 ({d}%)'   设置标签显示内容 ，默认显示{b}
                // {a}指series.name  {b}指series.data的name
                // {c}指series.data的value  {d}%指这一部分占总数的百分比
                formatter: '{b} :{d}%'
              }
            },
            itemStyle: {
              // emphasis：英文意思是 强调;着重;（轮廓、图形等的）鲜明;突出，重读
              // emphasis：设置鼠标放到哪一块扇形上面的时候，扇形样式、阴影
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(30, 144, 255, 0.5)'
              }
            },
            // data: [
            //     { name: "1", value: 4.3 },
            //     { name: "日程1", value: 2},
            // ],
            data: this.pieChartData,
            selectedMode: 'multiple',
            selectedOffset: 10,
            stillShowZeroSum: false, // 数据和为0时不显示
            labelLine: {
              show: true
            },
          },
        ],
        color: ['#37a2da', '#FF9F7F', '#32c5e9', '#67e0e3', '#9fe6b8', '#ffdb5c', '#fb7293', '#e062ae', '#e690d1', '#e7bcf3', '#9d96f5', '#8378ea'],
      };
      // 设置参数
      this.pieChart.setOption(config);
    },
    setTotalTimeChart() {
      // 基于准备好的dom，初始化echarts实例
      this.chart = echarts.init(this.$refs.totalTimeChart);

      // 配置参数
      let config = {
        xAxis: {
          // data: ['1123','2263','日程1','1'],
          data: this.totalTimeChartDataToName(this.TotalTimeChartData),
        },
        yAxis: {
          name: '总时长',
        },
        series: [
          {
            // data: [2, 5, 47, 1],
            data: this.totalTimeChartDataToValue(this.TotalTimeChartData),
            type: 'bar',
            itemStyle: {
              color:  new echarts.graphic.LinearGradient(
                0,1,0,0,
                [
                  {
                    offset: 0,
                    color: 'rgba(251, 114, 147, .6)' // 0% 处的颜色
                  }, {
                    offset: 1,
                    color: 'rgba(251, 114, 147, .3)' // 100% 处的颜色
                  },
                ]
              ),
              borderColor: '#fb7293',
            },
          }
        ]
      }

      // 设置参数
      this.chart.setOption(config);
    },
    eachMonthTimeChart() {
      // 基于准备好的dom，初始化echarts实例
      this.chart = echarts.init(this.$refs.eachMonthTimeChart);

      // 配置参数
      let config = {
        xAxis: {
          data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
          boundaryGap: false
        },
        yAxis: {
          name: '时长',
        },
        series: [
          {
            data: this.eachMonthTimeData,
            type: 'line',
            label: {
              show: true,
              formatter: '{value} (h)'
            },
            linePoint: {
              radius: 4
            },
            label: {
              show: true,
              position: 'top',
              textStyle: {
                fontSize: 14,
                color: '#3de7c9',
              }
            }
          }
        ]
      }

      // 设置参数
      this.chart.setOption(config);
    },
    totalTimeChartDataToName(data) {
      var ans = [];
      data.forEach(element => {
        ans.push(element.name);
      });
      return ans;
    },
    totalTimeChartDataToValue(data) {
      var ans = [];
      data.forEach(element => {
        ans.push(element.value);
      });
      return ans;
    }
  },
  mounted () {
    this.initData();
    // this.setCircleChart1();
    // this.setCircleChart2();
    // this.setCircleChart3();
    // this.setCircleChart4();
    // this.setCircleChart5();
    // this.setCircleChart();
    // this.setPieChart();
    // this.setTotalTimeChart();
    // this.eachMonthTimeChart();
  }
};
</script>

<style>
.top {
  display: flex;
  width: 100%;
  min-height: 30%;
}

.background {
  background-image: url("~@/assets/images/bg-img.png");
}
</style>