<template>
  <div id="learn-detail container">
    <h1 class="page-header">
      查看学习记录
      <span class="pull-right">
        <router-link to="/learn" class="btn btn-success">返回</router-link>
        <router-link v-bind:to="'/learnUpdate/' + content.id" class="btn btn-success">更新</router-link>
      </span>
    </h1>

    <br />
    <div class="well">
      <div class="form-group">
        <label>学习的ID</label>
        <input type="text" v-model="content.id" readonly />
      </div>

      <div class="form-group">
        <label>学习分类</label>
        <select v-model="content.tid">
          <option v-for="type in types" :value="type.id" :key="type.id">{{type.name}}</option>
        </select>
      </div>

      <div class="form-group">
        <label>学习啥时间</label>
        <input type="text" v-model="content.datetime" readonly />
      </div>

      <div class="form-group">
        <label>学习内容标题</label>
        <input type="text" v-model="content.desc" readonly />
      </div>

      <div class="form-group">
        <label>学习详细内容</label>
        <div class ="html1" v-html="content.details"></div>
      </div>

      <div class="form-group">
        <label>请对学习进行点评</label>
        <input type="text" v-model="content.remark" readonly />
      </div>

      <div class="form-group">
        <label>创建时间</label>
        <input type="text" v-model="content.creationdt" readonly />
      </div>

      <div class="form-group">
        <label>更新时间</label>
        <input type="text" v-model="content.updatedt" readonly />
      </div>
      <br />
      <br />
    </div>
  </div>
</template>

<script>
export default {
  name: "LearnDetail",
  data() {
    return {
      content: "",
      submmited: false,
      types: [],
      id: ""
    };
  },
  methods: {
    goToLearn() {
      //通过push进行跳转
      this.$router.push("/learn");
    },

    fetchContent(id) {
      console.log(id);
      this.$http.get("api/content/show/" + id).then(response => {
        console.log(response);
        this.content = response.data.data;
      });
    }
  },

  created() {
    this.fetchContent(this.$route.params.id),
      this.$http.get("api/type/showall", true).then(function(response) {
        this.types = response.data.data;
        //console.log(this.types);
      });
  }
};
</script>


<style scoped>
input[type="text"],

select {
  display: block;
  width: 100%;
  padding: 8px;
  border: 1;
  user-select: none;
  resize: none;
}

.html1{
  display: block;
  margin: 2px 0;
  width: 100%;
  padding: 8px;
  border: 1px solid #c5c3c3;
  user-select: none;
  resize: none;
  background:#fff;
  letter-spacing: normal;
    word-spacing: normal;
    text-transform: none;
    text-indent: 0px;
    text-shadow: none;
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