package com.shop.mall.service;

import com.github.pagehelper.PageInfo;
import com.shop.mall.vo.ProductDetailVo;
import com.shop.mall.vo.ResponseVo;

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
