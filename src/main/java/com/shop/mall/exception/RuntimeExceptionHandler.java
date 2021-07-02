package com.shop.mall.exception;

import com.shop.mall.enums.ResponseEnum;
import com.shop.mall.vo.ResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseVo handle(RuntimeException e){
        return ResponseVo.error(ResponseEnum.ERROR, e.getMessage());
    }

    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public ResponseVo userLoginException(){
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVo notValidExceptionHandle(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        //判断getFieldError是否为空
        Objects.requireNonNull(bindingResult.getFieldError());
        return ResponseVo.error(ResponseEnum.PARAM_ERROR,
                bindingResult.getFieldError().getField() + " " + bindingResult.getFieldError().getDefaultMessage());
    }
}
