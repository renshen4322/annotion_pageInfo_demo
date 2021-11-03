//package com.dn.aspect;
//
//import com.dn.annotation.WebLog;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import sun.net.util.IPAddressUtil;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//import java.text.DateFormat;
//import java.util.Date;
///**
// * <p>Title: WebLogAspect</p>
// * <p>Description: 日志切面类</p>
// * <p>Company: Ongoing蜗牛</p>
// *
// * @author liyf
// * @date 2020年3月28日
// */
//@Component
//@Aspect
//public class WebLogAspect {
//
//    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
//
////    private final SysUserLogService sysUserLogService;
////
////    public WebLogAspect(SysUserLogService sysUserLogService) {
////        this.sysUserLogService = sysUserLogService;
////    }
//
//    /**
//     * 连接点（切入点）
//     * 切入点表达式：匹配 web包及子包 Controller类的任何公共方法
//     */
//    @Pointcut("execution(public * com.dn.controller.*(..))")
//    public void webLog() {
//    }
//
//    /**
//     * 通知：前置通知（Before advice），在连接点之前运行但不能阻止执行流继续到连接点的通知(除非它抛出异常)。
//     * 在日志文件或控制台输出请求信息
//     *
//     * @param joinPoint
//     */
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) {
//
//        // 利用RequestContextHolder获取HttpServletRequest对象
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
//
//        // 重组请求信息
//        StringBuffer sb = new StringBuffer();
//        sb.append("收到请求：");
//        sb.append("\r\n访问URI   ：" + httpServletRequest.getRequestURI());
//        sb.append("\r\nSession ：" + httpServletRequest.getSession().getId());
//        //sb.append("\r\n访问IP    ：" + IPAddressUtil.isIPv4LiteralAddress(httpServletRequest.getRemoteAddr()));
//        sb.append("\r\n响应类 ：" + joinPoint.getSignature().getDeclaringTypeName());
//        sb.append("\r\n方法     ：" + joinPoint.getSignature().getName());
//
//        Object[] objects = joinPoint.getArgs();
//        for (Object arg : objects) {
//            if (arg != null) {
//                sb.append("\r\n参数     ：" + arg.toString());
//            }
//        }
//
//        // 打印请求信息
//        logger.info(sb.toString());
//
//    }
//
//    /**
//     * 通知：后置通知（After returning advice），通知在连接点正常完成后运行
//     * 处理请求日志信息
//     *
//     * @param joinPoint
//     */
//    @AfterReturning(pointcut = "webLog()", returning = "rvt")
//    public void doAfterReturning(JoinPoint joinPoint, Object rvt) {
//        // 处理日志信息
//        handleLog(joinPoint, null);
//    }
//
//    /**
//     * 通知：异常通知（After throwing advice），方法通过抛出异常退出，则要执行的通知
//     * 处理请求异常日志信息
//     *
//     * @param joinPoint
//     * @param e
//     */
//    @AfterThrowing(pointcut = "webLog()", throwing = "e")
//    public void afterThrowing(JoinPoint joinPoint, Exception e) {
//        // 处理日志信息
//        handleLog(joinPoint, e);
//    }
//
//    /**
//     * 日志处理
//     *
//     * @param joinPoint
//     * @param e
//     */
//    private void handleLog(JoinPoint joinPoint, Exception e) {
//        // 利用RequestContextHolder获取HttpServletRequest对象
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
//
//        // 获取执行的方法
//        Signature signature = joinPoint.getSignature();
//        if(!(signature instanceof MethodSignature)) {
//            throw new IllegalArgumentException("暂不支持非方法注解");
//        }
//        MethodSignature methodSignature = (MethodSignature) signature;
//        Method method = methodSignature.getMethod();
//
//        if (method != null) {
//            // 获取注解
//            WebLog controllerLog = method.getAnnotation(WebLog.class);
//
//            if (controllerLog != null) {
//
//                // 保存日志到数据库
//                if (controllerLog.saveFlag()) {
////                    SysUserLog sysUserLog = new SysUserLog();
////                    // SessionId
////                    sysUserLog.setAccount(httpServletRequest.getRequestedSessionId());
////                    // 渠道
////                    sysUserLog.setChannel(controllerLog.channel());
////                    // 功能名称
////                    sysUserLog.setName(controllerLog.name());
////                    // 响应类.方法
////                    sysUserLog.setAction(signature.getDeclaringTypeName() + "." + method.getName());
////                    // URI
////                    sysUserLog.setUrl(httpServletRequest.getRequestURI());
////                    // 参数
////                    sysUserLog.setParams(JSONObject.toJSONString(httpServletRequest.getParameterMap()).replace("\"", ""));
////                    // 请求IP
////                    sysUserLog.setIp(RequestUtil.getIP(httpServletRequest));
////                    // 操作时间
////                    sysUserLog.setLogTime(new Date());
////
////                    // 异常信息
////                    if (e != null) {
////                        sysUserLog.setErrMsg(e.getMessage());
////                    }
////
////                    sysUserLogService.insert(sysUserLog);
//
//                }
//            }
//        }
//
//        // 发生异常时打印错误信息
//        if (e != null) {
//            StringBuffer sb = new StringBuffer();
//            sb.append("时间：");
//            sb.append(DateFormat.getDateTimeInstance().format(new Date()));
//            sb.append("方法：");
//            sb.append(joinPoint.getSignature() + "\n");
//            sb.append("异常信息：" + e.getMessage());
//
//            logger.error(sb.toString());
//        }
//
//    }
//}
