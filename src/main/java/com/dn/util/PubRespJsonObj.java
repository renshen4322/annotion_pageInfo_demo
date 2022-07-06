package com.dn.util;

import java.util.List;

/**
 *
 * @date 2020/5/7 18:28
 * 用于处理公共的返回类
 */
public class PubRespJsonObj
{
    /**
     * 功能自定义状态标示
     */
    private String result = "";

    /**
     * 错误信息,用于封装各种错误信息
     */
    private String msg = "";

    /**
     * 承载单个对象
     */
    private Object data = null;

    /**
     * 功能自定义文本字段
     */
    private String normalinfo = "";



    /**
     * 功能自定义任意数据类型
     */
    private List<?> normaldata;



    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNormalinfo() {
        return normalinfo;
    }

    public void setNormalinfo(String normalinfo) {
        this.normalinfo = normalinfo;
    }

    public List<?> getNormaldata() {
        return normaldata;
    }

    public void setNormaldata(List<?> normaldata) {
        this.normaldata = normaldata;
    }
}
