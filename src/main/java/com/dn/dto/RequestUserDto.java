package com.dn.dto;

import com.dn.handler.Encrypt;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:RequestUserDto
 * Package:com.dn.dto
 * Description:
 *
 * @Date:2022/4/20 13:15
 * @Author: mark
 */
@Data
public class RequestUserDto implements Serializable {
    private static final long serialVersionUID = -3066248540372283921L;


    private String username;

    private String password;

    /**
     * 手机号
     */
    private Encrypt mobile;


}
