package com.test.mall.service;

import com.test.mall.vo.CategoryVo;
import com.test.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 分类业务接口
 */
public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
