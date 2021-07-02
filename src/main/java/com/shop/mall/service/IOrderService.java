package com.shop.mall.service;

import com.shop.mall.vo.OrderVo;
import com.shop.mall.vo.ResponseVo;

public interface IOrderService {
    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);
}
