package com.example.demo.service.impl;

import com.example.demo.bean.Hmotivate;
import com.example.demo.mapper.HmotivateMapper;
import com.example.demo.service.HmotivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HmotivateImpl implements HmotivateService {

    @Autowired
    HmotivateMapper hmotivateMapper;


    @Override
    public List<Hmotivate> getBmotivates(int uid) {
        List<Hmotivate> lists = hmotivateMapper.getHmotivates(uid);
        return lists;
    }

    @Override
    public Hmotivate getByid(int id) {
        return null;
    }

    @Override
    public int insert(Hmotivate record) {
        return 0;
    }

    @Override
    public int updateById(Hmotivate record) {
        return 0;
    }
}
