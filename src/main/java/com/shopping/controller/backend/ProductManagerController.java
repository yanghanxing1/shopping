package com.shopping.controller.backend;

import com.shopping.service.ICategoryService;
import com.shopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *@Author teacher.zhang
 * */
@RestController
@RequestMapping(value = "/manage/product/")
public class ProductManagerController {
    @Autowired
    private IProductService productService;
}
