package com.shop.mall.service.impl;

import com.shop.mall.dao.UserMapper;
import com.shop.mall.enums.ResponseEnum;
import com.shop.mall.enums.RoleEnum;
import com.shop.mall.pojo.User;
import com.shop.mall.service.IUserService;
import com.shop.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    //注册
    @Override
    public ResponseVo<User> register(User user) {

        //username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername>0){
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }

        //email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail>0){
            return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
        }

        //设置用户类型,默认普通用户
        user.setRole(RoleEnum.CUSTOMER.getCode());

        //MD5摘要算法(spring自带)
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        //写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount==0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user==null){
            //用户不存在
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        if (!user.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))){
            //密码错误
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        user.setPassword("");
        return ResponseVo.success(user);
    }
}
