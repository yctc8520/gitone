package com.test.mall.service;

import com.test.mall.pojo.User;
import com.test.mall.vo.ResponseVo;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 用户业务层接口
 */
public interface IUserService {
    /**
    *注册
     *
     */
    ResponseVo<User> register(User user);
    /**
     * 登录
     *
     */
    ResponseVo<User> login(String username, String password);
}
