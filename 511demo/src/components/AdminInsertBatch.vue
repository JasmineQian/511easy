<template>
  <div id="learn-insert container">
    <Alert v-if="alert" v-bind:message="alert"></Alert>
    <h1 class="page-header">
      管理员新增学习分类
      <span class="pull-right">
        <router-link to="/admin" class="btn btn-success">返回上一页</router-link>
      </span>
    </h1>

    <button @click="newColumn" class="btn btn-success">新增一列</button>
    <form v-if="!submmited" v-on:submit="addType">
      <p>学习分类新增</p>
      <div class="well" v-for="item of types" :key="item.name">
        <input type="text" placeholder="请输入需要增加的分类名称" v-model="item.id">
        <input type="text" placeholder="请输入需要增加的分类名称" v-model="item.name">
      </div>
      <button type="submit" class="btn btn-success">添加成功</button>
    </form>
  </div>
</template>

<script>
import Alert from "@/components/Alert";
export default {
  data() {
    return {
      types: [{ id: 1, name: "" }],
      submmited: false,
      alert: ""
    };
  },
  methods: {
    newColumn: function() {
      this.types.push({ name: "" });
    },
    addType(e) {
      console.log("=======adding types=======");
      if (!this.types) {
      } else {
        this.$http.post("api/type/addBatch", this.types).then(data => {
          console.log(data);
          console.log(this.submmited);
          this.submmited = true;
          this.$router.push({
            path: "/admin",
            query: { alert: "增加工作记录成功！" }
          });
        });
        e.preventDefault();
      }
      e.preventDefault();
    }
  },
  components: { Alert }
};
</script>


<style scoped>
label {
  display: block;
  margin: 20px 0 10px;
}

input[type="text"],
textarea,
select {
  display: block;
  width: 100%;
  padding: 8px;
}

textarea {
  height: 200px;
}

#checkboxes label {
  display: inline-block;
  margin-top: 0;
}

#checkboxes input {
  display: inline-block;
  margin-right: 10px;
}

button {
  display: block;
  margin: 20px 0;
  background: crimson;
  color: #fff;
  border: 0;
  padding: 14px;
  border-radius: 4px;
  font-size: 18px;
  cursor: pointer;
}

#preview {
  padding: 10px 20px;
  border: 1px dotted #ccc;
  margin: 30px 0;
}

h3 {
  margin-top: 10px;
}
</style>