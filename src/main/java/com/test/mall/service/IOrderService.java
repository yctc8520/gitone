package com.test.mall.service;

import com.github.pagehelper.PageInfo;
import com.test.mall.vo.OrderVo;
import com.test.mall.vo.ResponseVo;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);

    ResponseVo cancel(Integer uid, Long orderNo);

    void paid(Long orderNo);
}
