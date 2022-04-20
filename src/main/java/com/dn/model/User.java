package com.dn.model;

import java.io.Serializable;
import java.util.Date;

import com.dn.handler.Encrypt;
import lombok.Data;

/**
 * t_user
 * @author 
 */
@Data
public class User implements Serializable {
    private Long id;

    private String username;

    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 0 默认 1删除
     */
    private Boolean deleteStatus;

    private String createby;

    private Date createtime;

    private Date updatetime;

    private String updateby;

    private static final long serialVersionUID = 1L;
}