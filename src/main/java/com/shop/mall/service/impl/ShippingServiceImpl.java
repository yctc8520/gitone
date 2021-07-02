package com.shop.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.mall.dao.ShippingMapper;
import com.shop.mall.enums.ResponseEnum;
import com.shop.mall.form.ShippingForm;
import com.shop.mall.pojo.Shipping;
import com.shop.mall.service.IShippingService;
import com.shop.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShippingServiceImpl implements IShippingService {
    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public ResponseVo<Map<String,Integer>> add(Integer uid, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form,shipping);
        shipping.setUserId(uid);
        int row = shippingMapper.insertSelective(shipping);
        if (row == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        Map<String,Integer> map = new HashMap<>();
        map.put("shipping",shipping.getId());
        return ResponseVo.success(map);
    }

    @Override
    public ResponseVo delete(Integer uid, Integer shippingId) {
        int row = shippingMapper.deleteByIdAndUid(uid, shippingId);
        if (row == 0){
            return ResponseVo.error(ResponseEnum.DELETE_SHIPPING_FAIL);
        }
        return ResponseVo.success(ResponseEnum.SUCCESS);
    }

    @Override
    public ResponseVo update(Integer uid, Integer shippingId, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form,shipping);
        shipping.setUserId(uid);
        shipping.setId(shippingId);
        int row = shippingMapper.updateByPrimaryKeySelective(shipping);
        if (row == 0){
            return ResponseVo.error(ResponseEnum.DELETE_SHIPPING_FAIL);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pagSize) {
        PageHelper.startPage(pageNum,pagSize);
        List<Shipping> list = shippingMapper.selectByUid(uid);
        PageInfo pageInfo = new PageInfo(list);
        return ResponseVo.success(pageInfo);
    }
}
