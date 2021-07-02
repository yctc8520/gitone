package com.shop.mall.service;

import com.shop.mall.pojo.User;
import com.shop.mall.vo.ResponseVo;

public interface IUserService {
//   注册
    ResponseVo<User> register(User user);

//   登录

    ResponseVo<User> login(String username,String password);
}
