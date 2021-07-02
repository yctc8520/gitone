package com.test.mall.service;

import com.github.pagehelper.PageInfo;
import com.test.mall.vo.ProductDetailVo;
import com.test.mall.vo.ResponseVo;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 商品业务接口
 */
public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);

}
