package com.example.demo.service;

import com.example.demo.bean.Bmotivate;

import java.util.List;

public interface BmotivateService {

    List<Bmotivate> getBmotivates(int uid);

    Bmotivate getByid(int id);

    int insert(Bmotivate record);

    int updateById(Bmotivate record);
}
