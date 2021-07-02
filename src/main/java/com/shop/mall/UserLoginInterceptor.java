package com.shop.mall;

import com.shop.mall.consts.MallConst;
import com.shop.mall.exception.UserLoginException;
import com.shop.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    /**
     * true 表示继续流程 ,false 表示中断
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle...");
        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
        if (user==null){
            log.info("user=null");
           throw new UserLoginException();
            /**
             * 返回json的方法
             *  response.getWriter().print("error");直接往response里面写入内容,
             *  推荐上面的方法
             */
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }
        return true;
    }
}
