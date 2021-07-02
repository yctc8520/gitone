package com.shop.mall.controller;

import com.shop.mall.consts.MallConst;
import com.shop.mall.enums.ResponseEnum;
import com.shop.mall.form.UserLoginForm;
import com.shop.mall.form.UserRegisterForm;
import com.shop.mall.pojo.User;
import com.shop.mall.service.IUserService;
import com.shop.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")

    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userRegisterForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("注册提交的信息有误, {} {}",
                    bindingResult.getFieldError().getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(ResponseEnum.PARAM_ERROR,bindingResult);
        }
        User user=new User();
        BeanUtils.copyProperties(userRegisterForm,user);
        return userService.register(user);
    }

    @PostMapping("/user/login")

    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm, BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()){
            return ResponseVo.error(ResponseEnum.PARAM_ERROR,bindingResult);
        }
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        //设置session
        session.setAttribute(MallConst.CURRENT_USER,userResponseVo.getData());
        log.info("/login sessionId={}",session.getId());

        return userResponseVo;
    }

    //session保存在内存里
    @GetMapping("/user")
    public ResponseVo<User> userinfo(HttpSession session){
        log.info("/user sessionId={}",session.getId());
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    /**
     * session过期
     * getSessionTimeoutInMinutes 默认最短在线时间为 60s
     * {@link org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory}
     */
    public ResponseVo logout(HttpSession session){
        log.info("/user sessionId={}",session.getId());
        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }
}
