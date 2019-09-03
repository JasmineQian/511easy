package com.example.demo.mapper;

import com.example.demo.bean.BactivityList;

import java.util.List;

public interface BactivityListMapper {

    List<BactivityList> getBactivityList(int uid);

    BactivityList getByid(int id);

    int insert(BactivityList record);

    int updateById(BactivityList record);
}
