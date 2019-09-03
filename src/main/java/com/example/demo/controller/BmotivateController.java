package com.example.demo.controller;

import com.example.demo.bean.Bmotivate;
import com.example.demo.bean.Servert.ResponseBean;
import com.example.demo.service.BmotivateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/motivate")
@Api(value = "对自律活动的增删查改", description = "对自律活动的增删查改", position = 0)
public class BmotivateController {

        // 记录器
        Logger logger = LoggerFactory.getLogger(getClass());

        @Autowired
        BmotivateService bmotivateService;

        @ApiOperation(value = "展示列表请求接口", notes = "展示列表请求接口")
        @ApiImplicitParam(dataType = "", name = "", value = "展示列表请求接口")
        @GetMapping(value = "/showall/{uid}")
        public ResponseBean<Bmotivate> findAll(@PathVariable("uid") int uid) {
            ResponseBean responseBean = new ResponseBean();
            List<Bmotivate> lists= bmotivateService.getBmotivates(uid);
            responseBean.setData(lists);
            return responseBean;
        }
}
