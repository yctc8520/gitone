package com.shop.mall.service;

import com.shop.mall.MallApplicationTests;
import com.shop.mall.enums.ResponseEnum;
import com.shop.mall.form.ShippingForm;
import com.shop.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
@Slf4j
public class IShippingServiceTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 1;

    @Test
    public void add() {
        ShippingForm form = new ShippingForm();

        form.setReceiverName("大帅哥");
        form.setReceiverMobile("15915915912");
        form.setReceiverPhone("0793552");
        form.setReceiverAddress("枫林道");
        form.setReceiverCity("北京市");
        form.setReceiverDistrict("昭阳区");
        form.setReceiverProvince("河北省");
        form.setReceiverZip("334400");

        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void delete() {
        Integer shippingId = 5;
        ResponseVo<Map<String, Integer>> responseVo = shippingService.delete(uid, shippingId);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void update() {

    }

    @Test
    public void list() {
    }
}