<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="100px"
    >
      <el-form-item
        label="日程项目名"
        prop="itemName"
      >
        <el-input
          v-model="queryParams.itemName"
          placeholder="请输入日程项目名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
        >搜索</el-button>
        <el-button
          icon="el-icon-refresh"
          size="mini"
          @click="resetQuery"
        >重置</el-button>
      </el-form-item>
    </el-form>

    <el-row
      :gutter="10"
      class="mb8"
    >
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['schedule:supervision:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['schedule:supervision:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['schedule:supervision:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['schedule:supervision:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="supervisionList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column
        type="selection"
        width="55"
        align="center"
      />
      <!-- <el-table-column label="日程项目编号" align="center" prop="itemId" /> -->
      <el-table-column
        label="日程项目名"
        align="center"
        prop="itemName"
        sortable
      />
      <el-table-column
        label="预计开始时间"
        align="center"
        prop="predictStartTime"
        width="180"
        sortable
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.predictStartTime, '{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="预计执行时长(h)"
        align="center"
        prop="predictDurationTime"
        sortable
      />
      <el-table-column label="已持续时长" align="center" prop="lastingTime">
        <template slot-scope="scope">
          <!-- <span>{{ parseTime(scope.row.lastingTime, '{h}:{i}') }}</span> -->
          <span>{{ scope.row.lastingTime }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="备注"
        align="center"
        prop="remark"
      />
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-video-play"
            @click="handleClockIn(scope.row)"
            v-hasPermi="['schedule:supervision:edit']"
          >打卡</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['schedule:supervision:remove']"
          >结束</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改日程查看对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      width="500px"
      append-to-body
    >
      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="100px"
      >
      <el-form-item label="日程项目名" prop="itemName">
        <!-- <el-input v-model="form.itemName" placeholder="请输入日程项目名" /> -->
        <el-select v-model="form.itemName" placeholder="请选择日程项目名" filterable>
          <el-option
            v-for="item in itemList"
            :key="item.itemId"
            :label="item.itemName"
            :value="item.itemName"
            :disabled="item.status"
          ></el-option>
        </el-select>
      </el-form-item>
        <el-form-item
          label="预计开始时间"
          prop="predictStartTime"
        >
          <el-date-picker
            clearable
            v-model="form.predictStartTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm"
            placeholder="请选择预计开始时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item
          label="预计执行时长"
          prop="predictDurationTime"
        >
          <el-input
            v-model="form.predictDurationTime"
            placeholder="请输入预计执行时长"
          />
        </el-form-item>
        <el-form-item
          label="备注"
          prop="remark"
        >
          <el-input
            v-model="form.remark"
            type="textarea"
            placeholder="请输入内容"
          />
        </el-form-item>
      </el-form>
      <div
        slot="footer"
        class="dialog-footer"
      >
        <el-button
          type="primary"
          @click="submitForm"
        >确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSupervision, getSupervision, delSupervision, addSupervision, updateSupervision, getItemInfor, getItemName } from "@/api/schedule/supervision";

export default {
  name: "Supervision",
  dicts: ['item_finished_type'],
  data () {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedSchItemInfor: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 日程查看表格数据
      supervisionList: [],
      // 日程管理表格数据
      schItemInforList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        itemName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        itemName: [
          { required: true, message: "日程项目名不能为空", trigger: "blur" }
        ],
        predictStartTime: [
          { required: true, message: "预计开始时间不能为空", trigger: "blur" }
        ],
      },
      itemList: [], // 存储item_name选项的数组
    };
  },
  created () {
    this.getList();
  },
  methods: {
    /** 查询日程查看列表 */
    getList () {
      this.loading = true;
      listSupervision(this.queryParams).then(response => {
        this.supervisionList = response.rows;
        this.total = response.total;
        this.loading = false;
        this.getItemNames();
        console.log(this.supervisionList)
      });
    },
    // 取消按钮
    cancel () {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset () {
      this.form = {
        itemId: null,
        itemName: null,
        predictStartTime: null,
        predictDurationTime: null,
        lastingTime: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.schItemInforList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery () {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery () {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange (selection) {
      this.ids = selection.map(item => item.itemId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd () {
      this.reset();
      this.open = true;
      this.title = "添加日程查看";
    },
    /** 修改按钮操作 */
    handleUpdate (row) {
      this.reset();
      const itemId = row.itemId || this.ids
      getSupervision(itemId).then(response => {
        this.form = response.data;
        this.schItemInforList = response.data.schItemInforList;
        this.open = true;
        this.title = "修改日程查看";
      });
    },
    /** 提交按钮 */
    submitForm () {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.schItemInforList = this.schItemInforList;
          if (this.form.itemId != null) {
            updateSupervision(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSupervision(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete (row) {
      const itemIds = row.itemId || this.ids;
      this.$modal.confirm('是否确认删除日程查看编号为"' + itemIds + '"的数据项？').then(function () {
        return delSupervision(itemIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 日程管理序号 */
    rowSchItemInforIndex ({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 日程管理添加按钮操作 */
    handleAddSchItemInfor () {
      let obj = {};
      obj.itemName = "";
      obj.startTime = "";
      obj.durationTime = "";
      obj.ifFinished = "";
      obj.previousItemId = "";
      obj.remark = "";
      this.schItemInforList.push(obj);
    },
    /** 日程管理删除按钮操作 */
    handleDeleteSchItemInfor () {
      if (this.checkedSchItemInfor.length == 0) {
        this.$modal.msgError("请先选择要删除的日程管理数据");
      } else {
        const schItemInforList = this.schItemInforList;
        const checkedSchItemInfor = this.checkedSchItemInfor;
        this.schItemInforList = schItemInforList.filter(function (item) {
          return checkedSchItemInfor.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleSchItemInforSelectionChange (selection) {
      this.checkedSchItemInfor = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport () {
      this.download('schedule/supervision/export', {
        ...this.queryParams
      }, `supervision_${new Date().getTime()}.xlsx`)
    },
    /** 获得项目名 */
    getItemNames() {
      getItemName().then(response => {
        this.itemList = response.data;
        // this.$set(this.form, "name", response.name);
        this.itemList.forEach(element => {
          element.status = false;
          var temp = element;
          this.supervisionList.forEach(element =>{
            if(temp.itemId === element.itemId){
              temp.status = true;
              return;
            }
          });
        });
      });
    },
    /** 打卡按钮 */
    handleClockIn (row) {
      // 这里可以添加打卡的其他逻辑
      const itemName = row.itemName;
      this.$modal.confirm('开始打卡日程项目名为"' + itemName + '"?').then(function () {
        return;
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("打卡成功");
      }).catch(() => { });
    },
  }
};
</script>
