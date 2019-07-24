<template>
  <div id="learn-detail container">
    <Alert v-if="alert" v-bind:message="alert"></Alert>
    <h1 class="page-header">更新学习记录</h1>
    <form v-if="!submmited" v-on:submit="updateContent">
      <div class="well">
        <div class="form-group">
          <label>学习的ID</label>
          <input type="text" v-model="content.id" required />
        </div>

        <div class="form-group">
          <label>学习分类</label>
          <select v-model="content.tid">
            <option v-for="type in types" :value="type.id" :key="type.id">{{type.name}}</option>
          </select>
        </div>

        <div class="form-group">
          <label>学习啥时间</label>
          <input type="text" v-model="content.datetime" required />
        </div>

        <div class="form-group">
          <label>学习内容标题</label>
          <input type="text" v-model="content.desc" required />
        </div>

        <div class="form-group">
          <label>学习详细内容</label>
          <!--textarea type="text" v-model="content.details" required></textarea -->
          <Editor id="tinymce" v-model="content.details" :init="editorInit"></Editor>
        </div>

        <div class="form-group">
          <label>请对学习进行点评</label>
          <input type="text" v-model="content.remark" required />
        </div>

        <button type="submit">更新</button>
        <button @click="goToLearnPage" class="btn btn-success">返回</button>
      </div>
    </form>

    <div v-if="submmited">
      <h3>已经成功更新</h3>
    </div>
  </div>
</template>

<script>
import Alert from "@/components/Alert";
import tinymce from "tinymce/tinymce";
import "tinymce/themes/silver/theme";
import Editor from "@tinymce/tinymce-vue";
import "tinymce/plugins/image";
import "tinymce/plugins/link";
import "tinymce/plugins/code";
import "tinymce/plugins/table";
import "tinymce/plugins/lists";
import "tinymce/plugins/contextmenu";
import "tinymce/plugins/wordcount";
import "tinymce/plugins/colorpicker";
import "tinymce/plugins/textcolor";

export default {
  name: "LearnUpdate",
  data() {
    return {
      id: "",
      content: {},
      tids: [1, 2, 3, 4, 5],
      submmited: false,
      types: [],
      alert: "",
      editorInit: {
        language_url: "/static/tinymce/zh_CN.js",
        language: "zh_CN",
        skin_url: "/static/tinymce/skins/ui/oxide",
        height: 300,
        plugins:"link lists image code table colorpicker textcolor wordcount contextmenu",
        toolbar:
          "bold italic underline strikethrough | fontsizeselect | forecolor backcolor | alignleft aligncenter alignright alignjustify | bullist numlist | outdent indent blockquote | undo redo | link unlink image code | removeformat",
        branding: false,
        paste_word_valid_elements: "*[*]", // word需要它
        paste_data_images: true, // 粘贴的同时能把内容里的图片自动上传，非常强力的功能
        paste_convert_word_fake_lists: false, // 插入word文档需要该属性
        // 配置图片上传的功能
        images_upload_handler: (blobInfo, success, failure) => {
          this.handleImgUpload(blobInfo, success, failure);
        }
      }
    };
  },
  methods: {
    goToLearnPage() {
      this.$router.push("/learn");
    },
    fetchContent(id) {
      this.$http.get("api/content/show/" + id).then(response => {
        console.log(response);
        this.content = response.data.data;
      });
    },
    updateContent(e) {
      console.log("我要更新内容啦");
      if (!this.content.desc || !this.content.details) {
        console.log("请添加对应的信息");
        this.alert = "请添加对应的信息";
      } else {
        let updateContent = {
          tid: this.content.tid,
          desc: this.content.desc,
          details: this.content.details,
          remark: this.content.remark
        };
        this.$http
          .post("api/content/update/" + this.$route.params.id, updateContent)
          .then(response => {
            console.log(updateContent);
            console.log("这个时候的值是" + this.submmited);
            this.submmited = true;
            console.log(this.submmited);
            this.$router.push({
              path: "/learn",
              query: { alert: "学习内容更新成功" }
            });
          });
        e.preventDefault();
      }
      e.preventDefault();
    },
       // 用于上传图片的，后端需要提供好上传接口
    handleImgUpload(blobInfo, success, failure) {
      let formdata = new FormData();
      formdata.set("image", blobInfo.blob());
      let new_headers = { headers:"Content-Type: multipart/form-data" };
      let upload_url = "api/upload/image";
       this.$http
        .post(upload_url, formdata, new_headers)
        .then(res => {
          console.log(res.data.data)
          success(res.data.data);
        })
        .catch(res => {
          failure("error");
        });
    },
        to_data() {
      console.log(this.tinymceHtml);
      let Base64 = {
        encode(str) {
          return btoa(
            encodeURIComponent(str).replace(
              /%([0-9A-F]{2})/g,
              function toSolidBytes(match, p1) {
                return String.fromCharCode("0x" + p1);
              }
            )
          );
        },
        decode(str) {
          return decodeURIComponent(
            atob(str)
              .split("")
              .map(function(c) {
                return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
              })
              .join("")
          );
        }
      };
      // 将富文本内容专程base64编码，这个用于上传到服务存储到数据库中
      let encoded = Base64.encode(this.tinymceHtml);
      // 将富文本的base64编码 转换成原来的格式，这个用于将数据库中的富文本展示在界面上
      let decoded = Base64.decode(encoded);
      console.log(encoded);
      console.log(decoded);
    }
  },
  components: { Alert,Editor },
  created() {
    this.fetchContent(this.$route.params.id);
    this.$http.get("api/type/showall", true).then(function(response) {
      this.types = response.data.data;
      //console.log(this.types);
    });
  },
  mounted() {
    tinymce.init({});
  }
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

button {
  margin: 10px 0;
  background: crimson;
  color: #fff;
  border: 0;
  padding: 14px;
  border-radius: 4px;
  font-size: 12px;
  cursor: pointer;
}

h3 {
  margin-top: 10px;
}
</style>