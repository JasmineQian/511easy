package com.example.demo.service;

import com.example.demo.bean.BactivityList;

import java.util.List;

public interface BactivityListService {

    List<BactivityList> getBactivityList(int uid);

    BactivityList getByid(int id);

    int insert(BactivityList record);

    int updateById(BactivityList record);
}
