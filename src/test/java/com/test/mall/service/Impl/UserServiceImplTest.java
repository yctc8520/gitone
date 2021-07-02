package com.test.mall.service.Impl;

import com.test.mall.MallApplicationTests;
import com.test.mall.enums.ResponseEnum;
import com.test.mall.enums.RoleEnum;
import com.test.mall.pojo.User;
import com.test.mall.service.IUserService;
import com.test.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    public static final String USERNAME = "jack";

    public static final String PASSWORD = "jack";

    @Autowired
    private IUserService userService;

    @Before
    public void register() {
        User user = new User(USERNAME, PASSWORD, "jack@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    public void login(){
        register();
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}