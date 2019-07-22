<template>
  <div>
    <h1 class="page-header">
      管理员页面  |目前学习分类
      <span class="pull-right">
        <router-link to="/typeAdd" class="btn btn-success">逐个增加</router-link>
        <router-link to="/typeBatchAdd" class="btn btn-success">批量增加</router-link>
      </span>
    </h1>
    <input type="text" class="form-control" placeholder="搜索" v-model="filterInput">
    <br>
    <table class="table table-bordered table-hover table-striped">
      <thead>
        <tr>
          <th>所属ID</th>
          <th>详细描述</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="type in filterBy(types,filterInput)" :key="type.id">
          <td>{{type.id}}</td>
          <td>{{type.name}}</td>
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
    this.fetchTypes();
  },

  methods: {
    fetchTypes() {
      this.$http.get("api/type/showall").then(function(response) {
        this.types = response.data.data;
      });
    },
    filterBy(types, value) {
      return types.filter(function(type) {
        return type.name.match(value);
      });
    }
  }
};
</script>