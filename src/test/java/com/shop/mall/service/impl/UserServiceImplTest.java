package com.shop.mall.service.impl;

import com.shop.mall.MallApplicationTests;
import com.shop.mall.enums.ResponseEnum;
import com.shop.mall.enums.RoleEnum;
import com.shop.mall.pojo.User;
import com.shop.mall.service.IUserService;
import com.shop.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

//不写入数据库的注解
@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    public static final String USERNAME="TomcatOne";
    public static final String PASSWORD="123456";

    @Autowired
    private IUserService userService;

    @Before //每个单测前首先执行
    public void register() {
        User user =new User(USERNAME,PASSWORD,"123456@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    public void login() {
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}