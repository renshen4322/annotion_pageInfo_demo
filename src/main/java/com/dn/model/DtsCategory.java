package com.dn.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 类目表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-30 00:32:42
 */
@Data

public class DtsCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	private Integer id;
	/**
	 * 类目名称
	 */
	private String name;
	/**
	 * 类目关键字，以JSON数组格式
	 */
	private String keywords;
	/**
	 * 类目广告语介绍
	 */
	private String desc;
	/**
	 * 父类目ID
	 */
	private Integer pid;
	/**
	 * 类目图标
	 */
	private String iconUrl;
	/**
	 * 类目图片
	 */
	private String picUrl;
	/**
	 * 
	 */
	private String level;
	/**
	 * 排序
	 */
	private Integer sortOrder;
	/**
	 * 创建时间
	 */
	private Date addTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 逻辑删除
	 */
	private Integer deleted;

	private List<DtsCategory> children;

}
