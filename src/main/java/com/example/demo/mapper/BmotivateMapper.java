package com.example.demo.mapper;

import com.example.demo.bean.Bmotivate;
import com.example.demo.bean.Content;
import com.example.demo.bean.Servert.ContentUpdateRequest;

import java.util.List;


public interface BmotivateMapper {

    List<Bmotivate> getBmotivates(int uid);

    Bmotivate getByid(int id);

    int insert(Bmotivate record);

    int updateById(Bmotivate record);
}
