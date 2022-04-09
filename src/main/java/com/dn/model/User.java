package com.dn.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5575893900970589345L;

	private String id;

	private String userName;

	/**
	 * 用户密码
	 */
	private String password;


	/**
	 * 删除状态
	 */

	private int deleteStatus;

	private String createBy;


	private LocalDateTime createTime;

	private String updateBy;


	private LocalDateTime updateTime;




}
