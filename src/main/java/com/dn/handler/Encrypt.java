package com.dn.handler;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:Encrypt
 * Package:com.dn.handler
 * Description:
 *
 * @Date:2022/4/10 12:36
 * @Author: mark
 */
@Data
public class Encrypt implements Serializable {
    private static final long serialVersionUID = 5528003902154044414L;

    private String value;

    public Encrypt() {
    }

    public Encrypt(String value) {
        this.value = value;
    }

}
