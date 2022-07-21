package com.dn.normalexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @date 2020/5/8 12:04
 * 定义了拦截器部分逻辑异常的处理类
 */
public class InterceptorException extends Exception
{
    //系统日志类
    private Logger logger = LoggerFactory.getLogger(InterceptorException.class);

    private String errorcode = "";

    //重载的构造函数
    public InterceptorException()
    {
        super();
    }

    //重载的构造函数
    public InterceptorException(String msg)
    {
        super(msg);
    }

    //重载的构造函数
    public InterceptorException(String errorcode,String msg)
    {
        super(msg);
        this.errorcode = errorcode;
    }

    //重载的构造函数
    public InterceptorException(String message, Throwable cause)
    {
        super(message, cause);
    }

    //重载的构造函数
    public InterceptorException(String errorcode,String message, Throwable cause)
    {
        super(message, cause);
        this.errorcode = errorcode;
    }

    //重载的构造函数
    public InterceptorException(Throwable cause)
    {
        super(cause);
    }

    @Override
    public void printStackTrace()
    {
        super.printStackTrace();

        //输出Log日志
        logger.error(getMessage() + "详细信息 :" + fillInStackTrace());
    }

    public String getErrorcode()
    {
        return errorcode;
    }

    public void setErrorcode(String errorcode)
    {
        this.errorcode = errorcode;
    }
}
