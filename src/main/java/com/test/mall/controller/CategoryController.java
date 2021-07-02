package com.test.mall.controller;

import com.test.mall.service.ICategoryService;
import com.test.mall.vo.CategoryVo;
import com.test.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> selectAll() {
        return categoryService.selectAll();
    }
}
