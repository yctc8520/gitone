package com.test.mall.exception;

import com.test.mall.enums.ResponseEnum;
import com.test.mall.vo.ResponseVo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

import static com.test.mall.enums.ResponseEnum.ERROR;

@ControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseVo handler(RuntimeException e){
        return ResponseVo.error(ERROR, e.getMessage());
    }

    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public ResponseVo userLoginHandler(){
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVo notValidExceptionHandler(MethodArgumentNotValidException e) {

        BindingResult bindingResult = e.getBindingResult();
        Objects.requireNonNull(bindingResult.getFieldError()).getField();
        return ResponseVo.error(ResponseEnum.PARAM_ERROR, bindingResult.getFieldError().getField() + " " +
                bindingResult.getFieldError().getDefaultMessage());
    }
}
