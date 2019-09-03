package com.example.demo.service;

import com.example.demo.bean.Bmotivate;
import com.example.demo.bean.Hmotivate;

import java.util.List;

public interface HmotivateService {

    List<Hmotivate> getBmotivates(int uid);

    Hmotivate getByid(int id);

    int insert(Hmotivate record);

    int updateById(Hmotivate record);
}
