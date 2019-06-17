package com.shopping.dao;

import com.shopping.pojo.FinishedOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FinishedOrderMapper {
    int insert(FinishedOrder record);

    int insertSelective(FinishedOrder record);

    FinishedOrder selectByUserId(Integer usserId);
}