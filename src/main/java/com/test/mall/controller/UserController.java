package com.test.mall.controller;

import com.test.mall.form.UserLoginForm;
import com.test.mall.form.UserRegisterForm;
import com.test.mall.pojo.User;
import com.test.mall.service.IUserService;
import com.test.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.test.mall.consts.MallConsts.CURRENT_USER;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userRegisterForm) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody  UserLoginForm userLoginForm, HttpSession session){

        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        //设置Session
        session.setAttribute(CURRENT_USER, userResponseVo.getData());
        //打印登录sessionId
        log.info("/login sessionId={}", session.getId());
        return userResponseVo;
    }

    //session保存在内存里
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){

        log.info("/user sessionId={}", session.getId());
        User user = (User) session.getAttribute(CURRENT_USER);
        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session){
        log.info("/user/logout sessionId={}", session.getId());
        session.removeAttribute(CURRENT_USER);
        return ResponseVo.success();
    }

}
