package com.example.demo.service.impl;

import com.example.demo.bean.Bmotivate;
import com.example.demo.mapper.BmotivateMapper;
import com.example.demo.service.BmotivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BmotivateImpl implements BmotivateService {

    @Autowired
    BmotivateMapper bmotivateMapper;


    @Override
    public List<Bmotivate> getBmotivates(int uid) {
        List<Bmotivate> lists = bmotivateMapper.getBmotivates(uid);
        return lists;
    }

    @Override
    public Bmotivate getByid(int id) {
        Bmotivate details = bmotivateMapper.getByid(id);
        return details;
    }

    @Override
    public int insert(Bmotivate record) {
        return 0;
    }

    @Override
    public int updateById(Bmotivate record) {
        return 0;
    }
}
