package com.example.demo.service.impl;

import com.example.demo.bean.BactivityList;
import com.example.demo.mapper.BactivityListMapper;
import com.example.demo.service.BactivityListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BactivityListImpl implements BactivityListService {

    @Autowired
    BactivityListMapper bactivityListMapper;

    @Override
    public List<BactivityList> getBactivityList(int uid) {
        List<BactivityList> lists=bactivityListMapper.getBactivityList(uid);
        return lists;
    }

    @Override
    public BactivityList getByid(int id) {
        BactivityList details = bactivityListMapper.getByid(id);
        return null;
    }

    @Override
    public int insert(BactivityList record) {
        return 0;
    }

    @Override
    public int updateById(BactivityList record) {
        return 0;
    }
}
