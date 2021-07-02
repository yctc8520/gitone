package com.shop.mall.service;

import com.github.pagehelper.PageInfo;
import com.shop.mall.MallApplicationTests;
import com.shop.mall.enums.ResponseEnum;
import com.shop.mall.vo.ProductDetailVo;
import com.shop.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IProductServiceTest extends MallApplicationTests {

    @Autowired
    private IProductService productService;

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = productService.list(null, 1, 2);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void detail(){
        ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}