package com.shopping.dao;

import com.shopping.pojo.PayInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface PayInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_payinfo
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_payinfo
     *
     * @mbggenerated
     */
    int insert(PayInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_payinfo
     *
     * @mbggenerated
     */
    PayInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_payinfo
     *
     * @mbggenerated
     */
    List<PayInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_payinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PayInfo record);
}