package com.dn.util;

/**
 *
 * @date 2020/5/8 12:16
 * 定义了公共的枚举响应状态类
 */
public enum PubResponseEnum
{
    SUCCESS("10000",LocaleTextUtil.get("sys.request.success")),
    REQUEST_PARAMERROR("20001",LocaleTextUtil.get("sys.request.param.not.found")),
    REQSEST_CLENTIPERROR("20002",LocaleTextUtil.get("sys.request.not.found.cleanip")),
    REQUEST_CHONGFUERROR("20003",LocaleTextUtil.get("sys.request.duplicate")),
    REQUEST_SIGNERROR("20004",LocaleTextUtil.get("sys.request.signerror")),
    REQUEST_CHECKERROR("20005",LocaleTextUtil.get("sys.request.checkerror")),
    REQUEST_REQFCUNTIONPINFAN("30001",LocaleTextUtil.get("sys.request.reqfcuntionpinfan")),
    REQUEST_REQIPURLPINFAN("30002",LocaleTextUtil.get("sys.request.reqfcuntionpinfan")),
    REQUEST_LOGINTIMEOUT("70001",LocaleTextUtil.get("sys.request.logintimeout")),
    REQUEST_ERROR("80001",LocaleTextUtil.get("sys.request.error")),
    RESPONSE_ERROR("90001",LocaleTextUtil.get("sys.request.resp.error"));


    private String code;
    private String value;

    PubResponseEnum(String code, String value)
    {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "响应状态[" + this.code + "]响应内容[" + this.value + "]";
    }
}
