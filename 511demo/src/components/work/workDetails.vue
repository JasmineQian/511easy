<template>
  <div id="learn-detail container">
    <h1 class="page-header">
      查看学习记录
      <span class="pull-right">
        <router-link to="/work" class="btn btn-success">返回</router-link>
        <router-link v-bind:to="'/workUpdate/'+ work.id" class="btn btn-success">更新</router-link>
      </span>
    </h1>

    <br />
    <div class="well">


          <div class="form-group">
            <label>学习日期</label>
            <input type="text" v-model="work.id" required />
          </div>

          <div class="form-group">
            <label>学习点评</label>
            <input type="text" v-model="work.record" required />
          </div>

          <div class="form-group">
            <label>创建时间</label>
            <input type="text" v-model="work.creationdt" required />
          </div>

          <div class="form-group">
            <label>更新时间</label>
            <input type="text" v-model="work.updatedt" required />
          </div>

      <br />
      <br />
    </div>
  </div>
</template>

<script>
export default {
  name: "WorkDetail",
  data() {
    return {
      work: "",
      submmited: false,
      types: [],
      id: ""
    };
  },
  methods: {
    goToLearn() {
      //通过push进行跳转
      this.$router.push("/work");
    },

    fetchContent(id) {
      console.log(id);
      this.$http.get("api/work/show/" + id).then(response => {
        console.log(response);
        this.work = response.data.data;
      });
    }
  },

  created() {
    this.fetchContent(this.$route.params.id);
  }
};
</script>


<style scoped>
input[type="text"],
textarea,
select {
  display: block;
  width: 100%;
  padding: 8px;
}

textarea {
  height: 400px;
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
</style>