package com.shopping.service;

import com.shopping.common.ServerResponse;
import com.shopping.pojo.Category;

/**
 *@Author teacher.wei
 * */
public interface ICategoryService {
    public ServerResponse<Category> getChilds(Integer parentId);
    public ServerResponse<Category> add(String name, Integer parentId);
    public ServerResponse<Category> updateName(String name, Integer categoryId);
    public ServerResponse<Category> getAllChilds(Integer parentId);
    public ServerResponse getDeepCategory(Integer parentId);
}
