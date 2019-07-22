<template>
  <div id="learn container">
    <Alert v-if="alert" v-bind:message="alert"></Alert>
    <h1 class="page-header">
      Kids'学习记录
      <span class="pull-right">
        <router-link to="/learnInsert" class="btn btn-success">增加学习记录</router-link>
      </span>
    </h1>

    <input type="text" class="form-control" placeholder="搜索" v-model="filterInput" />
    <br />
    <table class="table table-bordered table-hover table-striped">
      <thead>
        <tr>
          <th>记录时间</th>
          <th>分类</th>
          <th>描述</th>
          <th>点评</th>
          <th>操作按钮</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="content in filterBy(contents,filterInput)" :key="content.id">
          <td>{{content.datetime}}</td>
          <td>{{type2name(content.tid)}}</td>
          <td>{{content.desc}}</td>
          <!--<td><div v-html="content.details.substring(0,14)" /></td> -->
          <td>{{content.remark}}</td>
          <td>
            <router-link :to="'/learnDetails/'+ content.id" class="btn btn-success">详情</router-link>
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
      contents: [],
      types: [],
      alert: "",
      name: "",
      filterInput: ""
    };
  },
  components: { Alert },
  created() {
    if (this.$route.query.alert) {
      this.alert = this.$route.query.alert;
    }

    this.fetchContents();
    this.fecthTypes();
  },

  methods: {
    fetchContents() {
      this.$http.get("api/content/showall").then(function(response) {
        console.log(response);
        console.log(response.data);
        console.log(response.data.data);
        this.contents = response.data.data;
      });
    },
    fecthTypes() {
      this.$http.get("api/type/showall", true).then(function(response) {
        this.types = response.data.data;
      });
    },
    filterBy(contents, value) {
      return contents.filter(function(content) {
        return content.desc.match(value);
      });
    },
    type2name(id) {
      return this.types.filter(v => {
        return v.id === id;
      })[0].name;
    }
  }
};
</script>


<style scoped>
#learn * {
  box-sizing: border-box;
}
</style>