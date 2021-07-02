package com.test.mall.service;

import com.github.pagehelper.PageInfo;
import com.test.mall.form.ShippingForm;
import com.test.mall.vo.ResponseVo;

import java.util.Map;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:  收货地址接口，提供增、删、改、查方法
 */
public interface IShippingService {

    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form);

    ResponseVo delete(Integer uid, Integer shippingId);

    ResponseVo update(Integer uid, Integer shippingId, ShippingForm form);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
}
