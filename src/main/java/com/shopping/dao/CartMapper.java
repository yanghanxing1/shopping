package com.shopping.dao;

import com.shopping.pojo.Cart;
import com.shopping.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface CartMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    Cart selectByPrimaryKey(Integer id);

    List<Cart> selectAll();

    int updateByPrimaryKey(Cart record);

    /*查询用户对应购物信息*/
    List<Cart> selectByUID(Integer uid);

    /*根据商品ID查询单条信息*/
    Cart selectByUidAndProductId(@Param("uid") Integer uid, @Param("productId") Integer productId);

    /*移除选中的商品*/
    int deleteByUidAndproductId(@Param("uid") Integer uid, @Param("productId") Integer productId);

    /*查询用户对应购物信息以选中的*/
    List<Cart> selectByUidAndCheckIn(Integer uid);
}