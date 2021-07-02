package com.test.mall.service;

import com.test.mall.MallApplicationTests;
import com.test.mall.enums.ResponseEnum;
import com.test.mall.vo.CategoryVo;
import com.test.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Slf4j
public class CatogoryServiceTest extends MallApplicationTests {

    @Autowired
    private ICategoryService catogoryService;
    @Test
    public void selectAll() {

        ResponseVo<List<CategoryVo>> responseVo = catogoryService.selectAll();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void findSubCategoryId(){

        Set<Integer> set = new HashSet<>();
        catogoryService.findSubCategoryId(100001, set);
        log.info("set={}", set);
    }
}