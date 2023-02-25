package com.bingda.blog.handler;

import com.bingda.blog.exception.BizException;
import com.bingda.blog.vo.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

import static com.bingda.blog.enums.StatusCodeEnum.SYSTEM_ERROR;
import static com.bingda.blog.enums.StatusCodeEnum.VALID_ERROR;


/**
 * 全局异常处理
 *
 * @author yezhqiu
 * @date 2021/06/11
 **/
@Log4j2

public class ControllerAdviceHandler {

    /**
     * 处理服务异常
     * / （3）全局异常处理
     *     //应用到所有@RequestMapping注解的方法，在其抛出Exception异常时执行
     *     //定义全局异常处理，value属性可以过滤拦截指定异常，此处拦截所有的Exception
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(value = BizException.class)
    public Result<?> errorHandler(BizException e) {
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 处理参数校验异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> errorHandler(MethodArgumentNotValidException e) {
        return Result.fail(VALID_ERROR.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /**
     * 处理系统异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> errorHandler(Exception e) {
        e.printStackTrace();
        return Result.fail(SYSTEM_ERROR.getCode(), SYSTEM_ERROR.getDesc());
    }

}
