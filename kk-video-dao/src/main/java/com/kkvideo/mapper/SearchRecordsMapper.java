package com.kkvideo.mapper;

import com.kkvideo.pojo.SearchRecords;
import com.kkvideo.utils.MyMapper;

import java.util.List;

public interface SearchRecordsMapper extends MyMapper<SearchRecords> {

    public List<String> getHotwords();

}