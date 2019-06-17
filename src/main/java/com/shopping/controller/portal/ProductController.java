package com.shopping.controller.portal;

import com.shopping.common.ServerResponse;
import com.shopping.pojo.vo.ProductVO;
import com.shopping.service.ICategoryService;
import com.shopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author teacher.guo
 * */
@RestController
@RequestMapping(value = "/portal/product/")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;
    /*产品搜索及动态排序List*/
    @RequestMapping("list.do")
    public ModelAndView  getList(@RequestParam(required = false) Integer categoryId,
                                  @RequestParam(required = false) String keyword,
                                  @RequestParam(required = false,defaultValue ="1") Integer pageNum,
                                  @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                  @RequestParam(required = false,defaultValue = "") String orderBy
                                  ){
        ServerResponse sr = productService.getList(categoryId,keyword,pageNum,pageSize,orderBy);

        List<ProductVO> productVOS = null;
        if(sr.isSuccess()){
            productVOS = (List<ProductVO>) sr.getData ();
        }
        Map map = new HashMap();
        map.put("productVOS",productVOS);

      /*  ServerResponse s = ServerResponse.createServerResponseByError();
        map.put("sr",s);*/
        return new ModelAndView("one/home/productlist",map);
    }

    /*获取产品detail*/
    @RequestMapping("detail.do")
    public ModelAndView getDetail(Integer productId,
                                  @RequestParam(required = false,defaultValue="0") Integer is_new,
                                  @RequestParam(required = false,defaultValue="0") Integer is_hot,
                                  @RequestParam(required = false,defaultValue="0") Integer is_banner){
        //ServerResponse
        ServerResponse sr = productService.getDetail(productId,is_new,is_hot,is_banner);
        ProductVO productVO = null;
        if(sr.isSuccess()){
            productVO = (ProductVO) sr.getData ();
        }
        Map map = new HashMap();
        map.put("productVO",productVO);
        return new ModelAndView("one/home/introduction",map);
    }

    /*获取产品分类,仅下一级孩子*/
    @CrossOrigin
    @RequestMapping("topcategory.do")
    public ServerResponse topcategory(@RequestParam(required = false,defaultValue="0") Integer sid){
        ServerResponse sr = productService.topcategory(sid);

        return sr;
    }
    /*获取产品分类,下面所有级孩子*/
    @RequestMapping("allcategory.do")
    public ServerResponse allcategory(@RequestParam(required = false,defaultValue="0") Integer sid){
        ServerResponse sr = categoryService.getDeepCategory(sid);

        return sr;
    }
    /*日志空接口*//*
    @RequestMapping("logempty.do")
    public ServerResponse logempty(){
        ServerResponse sr = ServerResponse.createServerResponseBySuccess("调用成功！");

        return sr;
    }
    @RequestMapping("listall.do")
    public  ServerResponse listAll(){
        ServerResponse sr = productService.findAll();
        return  sr;

    }*/
}
