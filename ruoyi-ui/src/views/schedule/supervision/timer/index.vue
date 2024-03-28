<template>
  <div>
    <!-- <span>需要注意的是内容是默认不居中的</span> -->
    <el-steps
      :active="nowActive"
      align-center
      finish-status="success"
    >
      <el-step
        title="开始打卡"
        description="点击下一步开始"
      ></el-step>
      <el-step
        title="日程进行中。。。"
        description="加油！頑張って！"
      ></el-step>
      <el-step
        title="打卡完成"
        description="太棒啦！！！"
      ></el-step>
    </el-steps>
    <div
      slot="footer"
      class="dialog-footer footer"
      align="center"
      v-show="footerVisible"
    >
      <el-button
        type="primary"
        @click="nextActive"
      >下一步</el-button>
      <el-button 
        @click="backActive"
      >
        返  回
      </el-button>
    </div>

    <div
      slot="footer"
      class="dialog-footer footer"
      align="center"
      v-show="!footerVisible"
    >
      <el-button
        type="primary"
        @click="finish"
      >完成</el-button>
    </div>
  </div>
</template>



<script>
import { eventBus } from "@/utils/schedule/supervision/eventBus.js";

export default {
  name: "timer",
  data () {
    return {
      nowActive: 2,
      footerVisible: true,
    };
  },
  mounted(){
    this.timerReset();
    eventBus.$on('receiveData', this.receiveData);
  },
  methods: {
    nextActive() {
      if(this.nowActive < 3) this.nowActive++;
      if(this.nowActive == 1) {
        this.timer();
      }
      if(this.nowActive == 2) {
        this.footerVisible = false;
      } else {
        this.footerVisible = true;
      }
    },
    backActive() {
      if(this.nowActive > 0) this.nowActive--;
      else this.finish();
    },
    receiveData(row) {
      this.timerReset();
    },
    timerReset() {
      this.nowActive = 0;
      this.footerVisible = true;
    },
    timer() {
      console.log("计时模块，启动！");
    },
    finish() {
      this.$emit('closeChange',false);
    }
  },
};
</script>

<style scoped>
.footer {
  margin-top: 5%;
  min-width: 700px;
}
</style>

