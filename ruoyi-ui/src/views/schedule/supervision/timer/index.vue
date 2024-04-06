<template>
  <div>
    <el-steps :active="nowActive" align-center finish-status="success">
      <el-step title="开始打卡" description="点击下一步开始"></el-step>
      <el-step title="日程进行中。。。" description="加油！頑張って！"></el-step>
      <el-step title="打卡完成" description="太棒啦！！！"></el-step>
    </el-steps>

    <div align="center">
      <div v-if="timerVisible" class="timeBox">
        <div>
          <clock :time="nowTimeFormat" bg="#a9c6f0" color="#be56ad"></clock>
          <el-tag effect="dark" color="#8a5eab" class="timeTag">
            {{ nowTimeFormat }}
          </el-tag>
        </div>

        <div>
          <el-button @click="timer" :disabled="counting == 0? false: true">
            开始计时
          </el-button>
          <el-button @click="endTimer">
            结束计时
          </el-button>
        </div>
      </div>

      <div slot="footer" class="dialog-footer footer" align="center"
        v-show="!footerVisible">
        <el-button type="primary" @click="finish">完成</el-button>
      </div>
    </div>

    <div slot="footer" class="dialog-footer footer" align="center"
      v-show="footerVisible">
      <el-button type="primary" @click="nextActive">下一步</el-button>
      <el-button @click="backActive">
        返 回
      </el-button>
    </div>
  </div>
</template>



<script>
import { eventBus } from "@/utils/schedule/supervision/eventBus.js";
import Clock from 'vue-clock2';

export default {
  name: "timer",
  components: { Clock },
  props:['getRow'],
  data () {
    return {
      nowActive: 2,
      footerVisible: true,
      timerVisible: false,
      countTime: null,
      startTime: null,
      nowTime: 0,
      nowTimeFormat: "00:00:00",
      counting: 0,
      row: null,
    };
  },
  mounted () {
    this.timerReset();
  },
  created () {
    eventBus.$on('receiveData', this.receiveData);
  },
  methods: {
    nextActive () {
      if (this.nowActive < 3) this.nowActive++;
      if (this.nowActive == 1) {
        this.timerVisible = true;
      } else {
        this.timerVisible = false;
      }
      if (this.nowActive == 2) {
        this.footerVisible = false;
      } else {
        this.footerVisible = true;
      }
      this.endTimer();
    },
    backActive () {
      if (this.nowActive > 0) this.nowActive--;
      else this.finish();
      if (this.nowActive != 1) {
        this.timerVisible = false;
      }
      this.endTimer();
    },
    receiveData (row) {
      console.log(row);
      this.row = row;
      this.timerReset();
    },
    timerReset () {
      this.nowActive = 0;
      this.footerVisible = true;
      this.timerVisible = false;
      this.timerStartDisabled = false;
      this.nowTime = 0;
      this.nowTimeFormat = "00:00:00";
    },
    timer () {
      console.log("计时模块，启动！");
      const dayjs = require("dayjs");
      require('dayjs/locale/zh-cn');

      this.startTime = dayjs();

      if (this.counting == 0) {
        this.countTime = setInterval(() => {
          this.counting = 1;
          this.nowTime = dayjs().diff(this.startTime);
          this.nowTimeFormat = this.timeFormat(this.nowTime);
        }, 1000);
      }
    },
    endTimer () {
      window.clearInterval(this.countTime);
      this.counting = 0;
    },
    finish () {
      this.$emit('closeChange', false, this.nowTimeFormat, this.row);
    },
    timeFormat (nowTime) {
      const time = parseInt(nowTime / 1000);
      const hh = parseInt(time / 60 / 60).toString().padStart(2, '0');
      const mm = parseInt(time / 60 % 60).toString().padStart(2, '0');
      const ss = parseInt(time % 60).toString().padStart(2, '0');
      return `${hh}:${mm}:${ss}`;
    }
  },
};
</script>

<style scoped>
.footer {
  margin-top: 5%;
  min-width: 700px;
}

.timeBox {
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.timeTag {
  margin-left: 20px;
}
</style>

