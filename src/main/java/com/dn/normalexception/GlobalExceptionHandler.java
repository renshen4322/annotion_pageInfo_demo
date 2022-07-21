package com.dn.normalexception;

import com.dn.util.PubRespJsonObj;
import com.dn.util.SysPubCommons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @date 2020/5/8 11:59
 * 定义了全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
    //定义了日志类
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 用于处理前置拦截器的异常处理类
     * @param request
     * @param error
     * @return
     */
    @ExceptionHandler(InterceptorException.class)
    @ResponseBody
    public PubRespJsonObj InterceptorHandlerExcetion(HttpServletRequest request, InterceptorException error)
    {
        PubRespJsonObj retObj = null;

        try
        {
            retObj = SysPubCommons.GetJsonObj(error.getErrorcode(),error.getMessage());
        }
        catch (Exception e)
        {
            logger.info("GlobalExceptionHandler class InterceptorHandlerExcetion function error:" + e);
        }

        return retObj;
    }
}
