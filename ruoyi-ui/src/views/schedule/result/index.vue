<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="日程项编号" prop="itemId">
        <el-input
          v-model="queryParams.itemId"
          placeholder="请输入日程项编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['schedule:result:add']"
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
          v-hasPermi="['schedule:result:edit']"
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
          v-hasPermi="['schedule:result:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['schedule:result:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="resultList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="结果编号" align="center" prop="resultId" />
      <el-table-column label="日程项编号" align="center" prop="itemId" />
      <el-table-column label="预计开始时间" align="center" prop="predictStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.predictStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否及时打卡" align="center" prop="ifTimely">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sch_if_timely" :value="scope.row.ifTimely"/>
        </template>
      </el-table-column>
      <el-table-column label="持续时长" align="center" prop="lastingTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastingTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="设定总时长" align="center" prop="totalSetTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['schedule:result:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['schedule:result:remove']"
          >删除</el-button>
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

    <!-- 添加或修改日程结果对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="日程项编号" prop="itemId">
          <el-input v-model="form.itemId" placeholder="请输入日程项编号" />
        </el-form-item>
        <el-form-item label="预计开始时间" prop="predictStartTime">
          <el-date-picker clearable
            v-model="form.predictStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择预计开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间" prop="finishTime">
          <el-date-picker clearable
            v-model="form.finishTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否及时打卡" prop="ifTimely">
          <el-input v-model="form.ifTimely" placeholder="请输入是否及时打卡" />
        </el-form-item>
        <el-form-item label="持续时长" prop="lastingTime">
          <el-date-picker clearable
            v-model="form.lastingTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择持续时长">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="设定总时长" prop="totalSetTime">
          <el-input v-model="form.totalSetTime" placeholder="请输入设定总时长" />
        </el-form-item>
        <el-form-item label="日程项评分" prop="score">
          <el-input v-model="form.score" placeholder="请输入日程项评分" />
        </el-form-item>
        <el-form-item label="日程项评价" prop="comment">
          <el-input v-model="form.comment" placeholder="请输入日程项评价" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listResult, getResult, delResult, addResult, updateResult } from "@/api/schedule/result";

export default {
  name: "Result",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 日程结果表格数据
      resultList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        itemId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        itemId: [
          { required: true, message: "日程项编号不能为空", trigger: "blur" }
        ],
        predictStartTime: [
          { required: true, message: "预计开始时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询日程结果列表 */
    getList() {
      this.loading = true;
      listResult(this.queryParams).then(response => {
        this.resultList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        resultId: null,
        itemId: null,
        predictStartTime: null,
        finishTime: null,
        ifTimely: null,
        lastingTime: null,
        totalSetTime: null,
        score: null,
        comment: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.resultId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加日程结果";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const resultId = row.resultId || this.ids
      getResult(resultId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改日程结果";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.resultId != null) {
            updateResult(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addResult(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const resultIds = row.resultId || this.ids;
      this.$modal.confirm('是否确认删除日程结果编号为"' + resultIds + '"的数据项？').then(function() {
        return delResult(resultIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('schedule/result/export', {
        ...this.queryParams
      }, `result_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
