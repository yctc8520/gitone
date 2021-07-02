package com.test.mall.service;

import com.test.mall.MallApplicationTests;
import com.test.mall.enums.ResponseEnum;
import com.test.mall.form.ShippingForm;
import com.test.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@Slf4j
public class IShippingServiceTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private final Integer uid = 1;

    private ShippingForm form;

    private Integer shippingId;

	@Before
	public void before() {
		ShippingForm form = new ShippingForm();
		form.setReceiverName("LiuSir");
		form.setReceiverAddress("ECUT");
		form.setReceiverCity("南昌");
		form.setReceiverPhone("0797-1111111");
		form.setReceiverProvince("江西省");
		form.setReceiverDistrict("青山湖区");
		form.setReceiverZip("330000");
		this.form = form;
		add();
	}

    public void add() {
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        log.info("result={}", responseVo);
        this.shippingId = responseVo.getData().get("shippingId");
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @After
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void update() {
        form.setReceiverCity("杭州");
        ResponseVo responseVo = shippingService.update(uid, shippingId, form);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo responseVo = shippingService.list(uid, 1, 10);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}