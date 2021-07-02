package com.test.mall.controller;

import com.github.pagehelper.PageInfo;
import com.test.mall.service.IProductService;
import com.test.mall.vo.ProductDetailVo;
import com.test.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@RestController
@CrossOrigin(origins = "*")public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ResponseVo<PageInfo> list(@RequestParam(required = false) Integer categoryId,
                                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize){

    return productService.list(categoryId, pageNum, pageSize);
    }

    @GetMapping("products/{productId}")
    public ResponseVo<ProductDetailVo> detail(@PathVariable Integer productId) {

        return productService.detail(productId);
    }

}
