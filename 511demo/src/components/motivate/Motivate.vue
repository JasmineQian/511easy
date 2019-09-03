<template>
  <div id="learn container">
    <Alert v-if="alert" v-bind:message="alert"></Alert>
    <h1 class="page-header">
      查看登录者的自律表
      <span class="pull-right">
        <router-link to="/workInsert" class="btn btn-success">增加自律条目</router-link>
      </span>
    </h1>

    <input type="text" class="form-control" placeholder="搜索" v-model="filterInput">
    <br>
    <table class="table table-bordered table-hover table-striped">
      <thead>
        <tr>
          <th>所属ID</th>
          <th>详细描述</th>
          <th>开始时间</th>
          <th>结束时间</th>
          <th>操作按钮</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="motivate in (motivates)" :key="motivate.id">
          <td>{{motivate.code}}</td> 
          <td>{{motivate.description}}</td> 
          <td>{{motivate.begindate}}</td>
          <td>{{motivate.enddate}}</td>
          <td>
            <router-link :to="'/motivate/'+ motivate.id" class="btn btn-success">详情</router-link>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import Alert from "@/components/Alert";
export default {
  data() {
    return {
      motivates: [],
      types: [],
      alert: "",
      filterInput: ""
    };
  },
  components: { Alert },
  created() {
    if (this.$route.query.alert) {
      this.alert = this.$route.query.alert;
    }
    this.fetchMotivates();
  },

  methods: {
    fetchMotivates() {
      this.$http.get("api/motivate/showall/1").then(function(response) {
        this.motivates = response.data.data;
      });
    }
  }
};
</script>


<style scoped>
#learn * {
  box-sizing: border-box;
}
</style>