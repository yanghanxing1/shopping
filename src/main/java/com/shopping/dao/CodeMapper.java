package com.shopping.dao;

import com.shopping.pojo.Code;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CodeMapper {
    int insert(Code record);

    int insertSelective(Code record);

    Code selectByPrimaryKey(Integer codeId);
}