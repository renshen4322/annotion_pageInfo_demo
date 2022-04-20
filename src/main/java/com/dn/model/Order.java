package com.dn.model;

import com.dn.annotation.NeedSetValue;
import com.dn.dao.UserDao;
import lombok.Data;

import java.io.Serializable;


@Data
public class Order implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8821751371277937944L;

    private String id;

    private String customerId;

    @NeedSetValue(beanClass = UserDao.class, param = "customerId", method = "find", targetField = "userName")
    private String customerName;

}
