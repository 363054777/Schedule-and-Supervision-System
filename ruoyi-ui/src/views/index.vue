<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <blockquote class="text-warning" style="font-size: 14px">
          <b class="text-success">已经完成</b><br />
          <s>外文翻译</s><br />
          <s>文献综述</s><br />
          <s>开题报告</s><br />
          <b class="text-success">正在进行</b><br />
          <a class="text-danger">系统开发</a><br />
          <a class="text-danger">论文正文</a><br />
        </blockquote>

        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>日程安排与监督系统</h2>
        <p>
          希望能够通过本系统实现自主的日程安排与监督，能够更好的为学生群体服务，服务于对时间的管理。除此之外，也可以对她进行深度定制，以做出更强系统。所有前端后台代码封装过后十分精简易上手，出错概率低。同时支持移动客户端访问。在之后会更新一些实用功能。
        </p>
        <p>
          <b>当前版本:</b> <span>v{{ version }}</span>
        </p>
        <p>
          <el-button type="primary" size="mini" icon="el-icon-cloudy" plain
            @click="goTarget('https://github.com/363054777/Schedule-and-Supervision-System')">访问码云</el-button>
          <el-button size="mini" icon="el-icon-s-home" plain
            @click="goTarget('https://github.com/363054777/Schedule-and-Supervision-System')">访问主页</el-button>
        </p>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术选型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>后端技术</h4>
            <ul>
              <li>SpringBoot</li>
              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
              <li>Druid</li>
              <li>Fastjson</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技术</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Sass</li>
              <li>Quill</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20" v-loading="loading">
      <div style="text-align: left;">
            <H2>日程预览</H2>
        </div>
      <el-calendar>
        <template slot="dateCell" slot-scope="{date, data}">
          {{ data.day.split('-').slice(1).join('-') }}
          <div style="width:100%;" v-for="item in scheduleData" :key="item">
            <el-tag type="danger"
              v-if="(item.workingDay).indexOf(data.day.split('-').slice(1).join('-'))!=-1">
              {{item.content}}
            </el-tag>
          </div>
        </template>
      </el-calendar>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-service"></i> 作者：王梓仰
            </p>
            <p>
              <i class="el-icon-s-promotion"></i> 官网：<el-link
                href="https://github.com/363054777/Schedule-and-Supervision-System"
                target="_blank">https://github.com/363054777/Schedule-and-Supervision-System</el-link>
            </p>
            <p>
              <i class="el-icon-user-solid"></i> QQ：
              <a href="tencent://message/?uin=363054777&Site=&Menu=yes"
                target="_blank">363054777</a>
            </p>
            <p>
              <i class="el-icon-chat-dot-round"></i> 微信：<a href="javascript:;">
                On_tyan/ *-_-</a>
            </p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>更新日志</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="v1.0.0 - 2024-03-01">
              <ol>
                <li>日程安排与监督系统正式开始</li>
                <li>新增Swagger全局Token配置</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>项目介绍</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="研究背景">
              <ol>
                <li>
                  随着时代的向前，生活节奏越来越快，人们更加趋向于碎片化时间，相比传统工作和学习时间的固定性和时段性，碎片化时间具有随机、零碎、随意、个体化和差异性等特征。因而如何做到更好的对时间进行管理始终是我们非常重视的问题。经统计数据，在部分学生中，自控能力弱、突发事件较多、时间太分散不想去花费精力管理等自身主观方面的因素逐渐成为学生群体不愿去对时间进行管理的最主要的原因。不仅如此，根据中国互联网络信息中心第50次《中国互联网络发展状况统计报告》显示，截至2022年6月，我国即时通信用户规模达10.27亿，其中短视频的用户规模增长最为明显，达9.62亿，较2021年12月增长2805万，占网民整体的91.5%。所以，以微博、微信、抖音短视频为代表，具有简约灵动、多元多样、裂变交互等传播特征的新兴“微媒体”通过智能手机、平板电脑等移动传播渠道影响着大多数人们的生活方式。而这个年轻的群体，因传播方式变化而导致生活学习习惯的变化也是最为明显,所受到的冲击也是最大的。因此，我们更应该不断强化大学生对时间的觉察能力、提高时间管理能力，这样才能高效、充分地利用时间，才能更好地提高驾驭时间的能力，才能进一步提升大学生的竞争力。
                </li>
                <li>
                  伴随着党的二十大提出的“推进教育数字化”，当代的学生群体不可避免地越来越多地接触并通过网络来促进学习的推进，但是同样不可避免的是在上网的途中接触其他事物带来的诱惑。对于网络带来的影响中，在经过系列调查与建模后，能够发现对于大学生群体，互联网学习能够显著的正向影响成绩。理念上,基于“构成”“带动”“引领”关系、财政主导投入、战略规划驱动,以数字化推动教育现代化，正是提倡通过数字化的手段，运用技术来提高学生群体的学习效率。对于更好的做到时间管理，符合国务院对深化教育教学改革的意见中，坚持立德树人，着力培养担当民族复兴大任的时代新人的基本要求，能够增强综合素质，坚持全面发展，为学生终身发展奠基。
                </li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="国内外研究现状">
              <ol>
                <li>
                  对于日程监督系统相关的研究目前已经比较完善，想要实现简单的监督功能已经见怪不怪了，常规的日程监督系统在附加上日程安排功能后的基本功能大致为：任务发布者发布任务，可对任务进行修改、删除及跟踪；任务执行者负责接收相对应，可以对任务进行日程安排，根据任务执行情况将其进度定期发送给任务发布者进行持续性的反馈；任务发布者根据任务执行者的进度报告对其进行工作评价，实现任务发布者和执行者之间的联系。[在系统实现的时候，可以实现低成本管理的日程管理系统，通过结合垃圾回收机制和内在并发支持等功能，在采用了相关方法之后，轻松实现了在短时间内开发系统，而且不需要服务器或数据库管理。
                </li>
                <li>
                  在日程安排的推荐功能方面，对于如何安排一个优秀的、科学的日程，一千个读者心里有一千个哈姆雷特，因而不同的创作者会给出属于他们的设计。比如说，依据所需要的不同日程之间的关系可以抽象出网状结构来表示不同日程之间的制约关系和其内在的信息，在对其进行有效地统筹规划。除此之外，还有创作者提出了一种基于协同过滤的推荐方法，该方法考虑了用户和其他用户的课程偏好类似于用户在课程方面的偏好，这种基于协同过滤的日程推荐是一种基于相似性的推荐方法，相较于其他方法，协同过滤能够使使用者对于所需要进行的日程和日程进行时间进行评分并得到一个更加符合使用者倾向的高分优化日程计划。
                </li>
                <li>
                  而想要更好的监督学习者的学习过程，反映出学习者的学习结果，大致上能够总结出以下几个角度：首先是学习时间监控，通过学习时长可以直接、明显但不一定精准的反映出学习进度；其次是学习内容监督，通过对已经学习的内容与未学习的学内容相结合，测算总体学习进度与规律；然后是学习效果监控，从不同方面对学习的内容进行测验来真实、精准的体现学习的效果；最后是在线互动监督，使得学生与老师在线上面对面直接交流促进学生解惑与直接给予评价。或者也可以从学生的角度出发，通过对学习效果、时长等的方面来对使用者进行疲劳评估，来为学生的休息日程进行安排而不是对学习日程进行安排。这种方法能够更好的提高使用者的效率，也是从相反的方面对日程进行监督。因此该系统目前主要关注的是如何更好的提供科学、高效的日程安排和实现对所安排的日程进行有效、合理的监督。
                </li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { getItemByDate } from "@/api/main";

export default {
  name: "Index",
  data () {
    return {
      // 版本号
      version: "1.0.0",
      value: new Date(),
      loading:true,
      scheduleData: [
        // {
        //   workingDay: "04-01",
        //   content: "有1个日程",
        // },
        // {
        //   workingDay: "04-03",
        //   content: "有2个日程",
        // },
      ],
    };
  },
  methods: {
    goTarget (href) {
      window.open(href, "_blank");
    },
    getItemCountData(){
      this.loading=true;
      getItemByDate().then(response => {
        // console.log(response.rows);
        response.rows.forEach(element => {
          var item = {
            workingDay: element.workingDay,
            content: "有"+element.itemCount+"个日程",
          };
          console.log(item);
          this.scheduleData.push(item);
        });
        this.loading=false;
      });
    }
  },
  mounted() {
    this.getItemCountData();
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

