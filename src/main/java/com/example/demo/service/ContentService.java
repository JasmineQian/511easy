package com.example.demo.service;

import com.example.demo.bean.Content;
import com.example.demo.bean.Servert.ContentUpdateRequest;

import java.util.List;

public interface ContentService {

    List<Content> getAll();

    Content getByid(int id);

    int insert(ContentUpdateRequest content);

    int update(ContentUpdateRequest content);
}
