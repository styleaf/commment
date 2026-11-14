package com.example.comment.exception;

import com.example.comment.entity.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 情况1：@Valid 校验失败（比如用户名没填）
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidation(MethodArgumentNotValidException e) {
        int len = e.getBindingResult().getFieldErrors().size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            String msg = e.getBindingResult().getFieldErrors().get(i).getDefaultMessage();
            stringBuffer.append(msg);
        }
        return Result.error(stringBuffer.toString());
    }

    // 情况2：业务异常（比如用户名已存在）
    @ExceptionHandler(BusinessException.class)
    public Result handleBusiness(BusinessException e) {
        return Result.error(e.getMessage());
    }

    // 情况3：兜底，其他所有异常
   @ExceptionHandler(Exception.class)
    public Result handleAll(Exception e){
        e.printStackTrace();
        return Result.error("系统繁忙，请稍后尝试");
   }
   
}
