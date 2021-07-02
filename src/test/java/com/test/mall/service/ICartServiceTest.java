package com.test.mall.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.mall.MallApplicationTests;
import com.test.mall.enums.ResponseEnum;
import com.test.mall.form.CartAddForm;
import com.test.mall.form.CartUpdateForm;
import com.test.mall.vo.CartVo;
import com.test.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 测试方法： 添加购物车cartAdd()、购物车列表cartList()、更新购物车update()
 */
@Slf4j
public class ICartServiceTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Integer uid = 1;

    private Integer productID = 26;

    @Before
    public void cartAdd() {

        log.info("【新增购物车...】");
        CartAddForm form = new CartAddForm();
        form.setProductId(productID);
        form.setSelected(true);
        ResponseVo<CartVo> responseVo = cartService.add(uid, form);

        log.info("list={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void cartList() {
        ResponseVo<CartVo> responseVo = cartService.list(uid);
        log.info("list={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void update() {
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(5);
        form.setSelected(false);
        ResponseVo<CartVo> responseVo = cartService.update(uid, productID, form);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @After
    public void delete() {
        log.info("【删除购物车...】");
        ResponseVo<CartVo> responseVo = cartService.delete(uid, productID);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void selectAll() {
        ResponseVo<CartVo> responseVo = cartService.selectAll(uid);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void unSelectAll() {
        ResponseVo<CartVo> responseVo = cartService.unSelectAll(uid);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void sum() {
        ResponseVo<Integer> responseVo = cartService.sum(uid);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}