package com.dn.model;

import lombok.Builder;
import lombok.Data;

/**
 * ClassName:TestReq
 * Package:com.dn.model
 * Description:
 *
 * @Date:2021/10/29 10:39
 * @Author: mark
 */
@Data
@Builder
public class TestReq {
    private String mobile;
    private String server_hospital;

    public TestReq(){

    }

    public TestReq(String mobile, String server_hospital) {
        this.mobile = mobile;
        this.server_hospital = server_hospital;
    }
}
