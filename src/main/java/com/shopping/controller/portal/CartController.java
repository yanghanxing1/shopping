package com.shopping.controller.portal;

import com.shopping.common.Const;
import com.shopping.common.ServerResponse;
import com.shopping.pojo.UserInfo;
import com.shopping.service.ICartService;
import com.shopping.service.ICategoryService;
import com.shopping.util.OpinionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author teacher.zhang
 * */
@RestController
@RequestMapping(value = "/portal/cart/")
public class CartController {
    @Autowired
    private ICartService cartService;

    /*购物车List列表*/
    @RequestMapping("list.do")
    public ServerResponse getDetail(HttpSession session){
        ServerResponse sr = OpinionUtils.isSession(session);
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.getDetail(session);
            return sr;
        }else{
            return sr;
        }
    }

    /*购物车添加商品*/
    @RequestMapping("add.do")
    public ServerResponse addCart(HttpSession session, Integer productId, Integer count){
        ServerResponse sr = OpinionUtils.isSession(session);
        Map map = new HashMap();
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.addNew(session,productId,1);
            return sr;


            /*map.put("sr",sr);
            return new ModelAndView("one/home/introduction",map);*/
        }else{
            /*map.put("sr",sr);
            return new ModelAndView("one/home/introduction",map);*/
            return sr;
        }
    }

    /*更新购物车某个产品数量*/
    @RequestMapping("update.do")
    public ServerResponse updateCart(HttpSession session,Integer productId,Integer count){
        ServerResponse sr = OpinionUtils.isSession(session);
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.updateCart(session,productId,count);
            return sr;
        }else{
            return sr;
        }
    }

    /*移除购物车某个产品数量*/
    @RequestMapping("delete_product.do")
    public ServerResponse deleteProduct(HttpSession session, String productIds){
        ServerResponse sr = OpinionUtils.isSession(session);
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.deleteProduct(session,productIds);
            return sr;
        }else{
            return sr;
        }
    }

    /*购物车选中某个商品*/
    @RequestMapping("select.do")
    public ServerResponse selectProduct(HttpSession session, Integer productId){
        ServerResponse sr = OpinionUtils.isSession(session);
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.selectProduct(session,productId);
            return sr;
        }else{
            return sr;
        }
    }

    /*购物车取消选中某个商品*/
    @RequestMapping("un_select.do")
    public ServerResponse unSelectProduct(HttpSession session, Integer productId){
        ServerResponse sr = OpinionUtils.isSession(session);
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.unSelectProduct(session,productId);
            return sr;
        }else{
            return sr;
        }
    }
    /*查询在购物车里的产品数量*/
    @RequestMapping("get_cart_product_count.do")
    public ServerResponse getCartProductCount(HttpSession session){
        ServerResponse sr = OpinionUtils.isSession(session);
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.getCartProductCount(session);
            return sr;
        }else{
            return sr;
        }
    }
    /*购物车全选*/
    @RequestMapping("select_all.do")
    public ServerResponse selectAll(HttpSession session){
        ServerResponse sr = OpinionUtils.isSession(session);
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.selectAllProduct(session);
            return sr;
        }else{
            return sr;
        }
    }
    /*购物车取消全选*/
    @RequestMapping("un_select_all.do")
    public ServerResponse unSelectAll(HttpSession session){
        ServerResponse sr = OpinionUtils.isSession(session);
        //判断登录状态
        if(sr.isSuccess()){
            sr = cartService.unSelectAll(session);
            return sr;
        }else{
            return sr;
        }
    }
}
