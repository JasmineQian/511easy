<template>
  <div class="app-container">
    <h1>tinymce 富文本编辑器</h1>
    <br />
    <button type="primary" @click="to_data" class="btn btn-success">确定</button>
    <br />
    <div v-html="tinymceHtml"></div>
    <Editor id="tinymce" v-model="tinymceHtml" :init="init"></Editor>
    <br />
    <br />
  </div>
</template>

<script>
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
  name: "tinymce",
  data() {
    return {
      tinymceHtml: `请输入文本信息`,
      init: {
        language_url: "/static/tinymce/zh_CN.js",
        language: "zh_CN",
        skin_url: "/static/tinymce/skins/ui/oxide-dark",
        height: 800,
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
  mounted() {
    tinymce.init({});
  },
  methods: {
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
    },
    // 用于上传图片的，后端需要提供好上传接口
    handleImgUpload(blobInfo, success, failure) {
      let formdata = new FormData();
      formdata.set("upload_file", blobInfo.blob());
      let new_headers = { headers: this.headers };
      let upload_url = process.env.BASE_API + "/uploadfile";
       this.$http
        .post(upload_url, formdata, new_headers)
        .then(res => {
          console.log(res.data.data)
          success(res.data.data[0]);
        })
        .catch(res => {
          failure("error");
        });
    }
  },
  components: { Editor }
};
</script>
