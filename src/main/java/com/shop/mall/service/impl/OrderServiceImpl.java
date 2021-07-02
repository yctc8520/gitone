package com.shop.mall.service.impl;

import com.shop.mall.dao.ShippingMapper;
import com.shop.mall.enums.ResponseEnum;
import com.shop.mall.pojo.Shipping;
import com.shop.mall.service.ICartService;
import com.shop.mall.service.IOrderService;
import com.shop.mall.vo.OrderVo;
import com.shop.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private ShippingMapper shippingMapper;
    @Autowired
    private ICartService cartService;
    @Override
    public ResponseVo<OrderVo> create(Integer uid, Integer shippingId) {
        //收货地址校验
        Shipping shipping = shippingMapper.selectByUidAndShippingId(uid,shippingId );
        if (shipping==null){
            return ResponseVo.error(ResponseEnum.SHIPPING_NOT_EXIST);
        }
        //获取购物车信息 校验是否有商品和库存是否充足

        //计算总价，只计算选中的商品

        //生成订单 入库 写入 order , order_item

        //更新库存

        //更新购物车

        //构造orderVo对象
        return null;
    }
}
