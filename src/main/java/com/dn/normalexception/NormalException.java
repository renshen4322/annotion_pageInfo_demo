package com.dn.normalexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @date 2020/5/8 11:52
 * 定义了自定义的异常处理类
 */
public class NormalException extends Exception
{
    //系统日志类
    private Logger logger = LoggerFactory.getLogger(NormalException.class);

    //重载的构造函数
    public NormalException()
    {
        super();
    }

    //重载的构造函数
    public NormalException(String msg)
    {
        super(msg);
    }

    //重载的构造函数
    public NormalException(String message, Throwable cause)
    {
        super(message, cause);
    }

    //重载的构造函数
    public NormalException(Throwable cause)
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
}
