package com.dn.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @ProjectName: xinan-cloud
 * @Description: 通用的结果集实体
 * @Author: liuhao
 * @CreateDate: 2021/8/20 21:22
 * @Version: 1.0
 */
@Slf4j
@Data
@ApiModel(value = "响应值", description = "接口响应值")
public class ResultInfo<T> implements Serializable {
    private static int SUCCESS = 1;
    private static int ERROR = 0;


    private static final long serialVersionUID = -7395394703003443612L;
    @ApiModelProperty(value = "接口响应描述", example = "操作成功")
    private String msg;
    @ApiModelProperty(value = "接口响应码", example = "200")
    private int code;
    @ApiModelProperty(value = "接口响应值")
    private T data;


    public static <T> ResultInfo<T> error() {
        return response(ERROR, "返回失败");
    }

    public static <T> ResultInfo<T> error(String msg) {
        return response(ERROR, msg);
    }

    public static <T> ResultInfo<T> error(int code, String msg) {
        return response(code, msg);
    }



    public static <T> ResultInfo<T> error(String msg, T data) {
        return response(ERROR, msg, data);
    }

    public static <T> ResultInfo<T> success(String msg) {
        return response(SUCCESS, msg);
    }

    public static <T> ResultInfo<T> success(T data) {
        return response(SUCCESS, "返回成功", data);
    }

    public static <T> ResultInfo<T> success() {
        return response(SUCCESS, "返回成功");
    }

    public static <T> ResultInfo<T> success(String msg, T data) {
        return response(SUCCESS, msg, data);
    }

    public static <T> ResultInfo<T> status(boolean flag) {
        return flag ? success("返回成功") : error("返回失败");
    }

    public static <T> ResultInfo<T> status(boolean flag, T data) {
        return flag ? success("返回成功", data) : error("返回失败", data);
    }

    public static <T> ResultInfo<T> response(int code, String msg) {
        ResultInfo<T> Result = new ResultInfo<>();
        Result.setCode(code);
        Result.setMsg(msg);
        return Result;
    }

    public static <T> ResultInfo<T> response(int code, String msg, T data) {
        ResultInfo<T> Result = new ResultInfo<>();
        Result.setCode(code);
        Result.setMsg(msg);
        Result.setData(data);
        return Result;
    }


}
