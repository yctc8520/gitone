package com.shop.mall.service;

import com.shop.mall.vo.CategoryVo;
import com.shop.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface ICategoryService {
    ResponseVo<List<CategoryVo>> selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
