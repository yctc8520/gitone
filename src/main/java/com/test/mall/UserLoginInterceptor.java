package com.test.mall;

import com.test.mall.exception.UserLoginException;
import com.test.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.test.mall.consts.MallConsts.CURRENT_USER;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    //true表示继续流程，false表示中断
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("preHandler...");
        User user = (User) request.getSession().getAttribute(CURRENT_USER);
        if (user == null){
            log.info("user == null");
            throw new UserLoginException();
//            response.getWriter().print("error");
//            return false;
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }
        return true;
    }
}
