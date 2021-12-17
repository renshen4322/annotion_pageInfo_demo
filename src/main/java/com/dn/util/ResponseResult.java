package com.dn.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Description: 统一返回实体
 * @date 2019/2/18 9:44
 */
@Data
@Slf4j
@ApiModel(value = "响应值", description = "接口响应值")
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 7304418799266286625L;
    @ApiModelProperty(value = "接口响应描述", example = "操作成功")
    private String msg;
    @ApiModelProperty(value = "接口响应码", example = "1")
    private int code;
    @ApiModelProperty(value = "接口响应值")
    private T data;


    public static <T> ResponseResult<T> error(String msg) {
        log.error(msg);
        return response(ResponseCode.ERROR, msg);
    }

    public static <T> ResponseResult<T> error() {
        return response(ResponseCode.ERROR, "返回失败");
    }


    public static <T> ResponseResult<T> error(String msg, T data) {
        log.error(msg);
        return response(ResponseCode.ERROR, msg, data);
    }

    public static <T> ResponseResult<T> success(String msg) {
        return response(ResponseCode.SUCCESS, msg);
    }

    public static <T> ResponseResult<T> success(T data) {
        return response(ResponseCode.SUCCESS, "返回成功", data);
    }

    public static <T> ResponseResult<T> success() {
        return response(ResponseCode.SUCCESS, "返回成功");
    }

    public static <T> ResponseResult<T> success(String msg, T data) {
        return response(ResponseCode.SUCCESS, msg, data);
    }

    public static <T> ResponseResult<T> status(boolean flag) {
        return flag ? success("返回成功") : error("返回失败");
    }

    public static <T> ResponseResult<T> status(boolean flag, T data) {
        return flag ? success("返回成功", data) : error("返回失败", data);
    }

    public static <T> ResponseResult<T> response(int code, String msg) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        return responseResult;
    }

    public static <T> ResponseResult<T> response(int code, String msg, T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        responseResult.setData(data);
        return responseResult;
    }

}
