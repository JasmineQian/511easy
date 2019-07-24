package com.example.demo.controller;

import com.example.demo.bean.Servert.ResponseBean;
import com.example.demo.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Validated
@RestController
@RequestMapping("api/upload")
@Api(value = "对学习进行增删查改", description = "查询信息并对学习的信息进行增删查改", position = 0)
public class UploadController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ImageService imageService;

    @ApiOperation(value = "上传图片到指定目录")
    @RequestMapping(path = "/image", method = {RequestMethod.POST})
    public ResponseBean upload(@RequestParam("image") MultipartFile file, HttpServletResponse response) throws Exception {
        String url = imageService.uploadImg(file);
        System.out.println(url);
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(url);
        return responseBean;
    }

}
