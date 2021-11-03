package com.dn.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dn.model.User;
import com.dn.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/user")
@Api(tags = {"用户Api文档"})
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "hello 测试")
	public String hello() {
		return "hello";
	}

	/**
	 * 测试插入
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户添加")
	public String add(String id, String userName) {
		User u = new User();
		u.setId(id);
		u.setName(userName);
		this.userService.insertUser(u);
		return u.getId() + "    " + u.getName();
	}

	/**
	 * 测试根据id查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "通过用户id查询")
	public String findById(@PathVariable("id") String id) {
		User u = this.userService.findById(id);
		return u == null ? "找不到对象" : (u.getId() + "    " + u.getName());
	}

	/**
	 * 测试修改
	 * 
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String update(String id, String userName) {
		User u = new User();
		u.setId(id);
		u.setName(userName);
		this.userService.updateUser(u);
		return u.getId() + "    " + u.getName();
	}

	/**
	 * 测试删除
	 * 
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") String id) {
		this.userService.deleteById(id);
		return "success";
	}

	/**
	 * 测试分页插件
	 * 
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	public Object queryPage(String userName) {
		PageInfo<User> page = this.userService.queryPage(userName, 1, 10);
		return page;
	}
}
