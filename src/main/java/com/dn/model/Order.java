package com.dn.model;

import java.io.Serializable;

import com.dn.annotation.NeedSetValue;
import com.dn.dao.UserDao;


public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8821751371277937944L;

	private String id;

	private String customerId;

	@NeedSetValue(beanClass=UserDao.class,param="customerId",method="find",targetField="name")
	private String customerName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


}
