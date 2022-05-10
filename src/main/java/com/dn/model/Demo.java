package com.dn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.frameworkset.orm.annotation.Column;
import com.frameworkset.orm.annotation.ESId;
import lombok.Data;
import org.frameworkset.elasticsearch.entity.ESBaseData;

import java.util.Date;

/**
 * ClassName:Demo
 * Package:com.dn.model
 * Description:
 *
 * @Date:2022/5/1 14:39
 * @Author: mark
 */
@Data
public class Demo extends ESBaseData {
    //@PrimaryKey
    //设定文档标识字段
    @ESId(readSet = true,persistent = false)
    private Long demoId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(dataformat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date agentStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(dataformat = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date agentStartTimeZh;
    private String applicationName;
    private String contentBody;
    private String name;
    private String orderId;
    private Integer contrastStatus;

    private Object dynamicPriceTemplate;
}
