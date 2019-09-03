package com.example.demo.mapper;

import com.example.demo.bean.Hmotivate;
import java.util.List;

public interface HmotivateMapper {

    List<Hmotivate> getHmotivates(int uid);

    Hmotivate getByid(int id);

    int insert(Hmotivate record);

    int updateById(Hmotivate record);
}
