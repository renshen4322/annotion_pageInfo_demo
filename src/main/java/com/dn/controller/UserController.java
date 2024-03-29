package com.dn.controller;

import com.dn.dto.RequestUserDto;
import com.dn.model.TestUser;
import com.dn.model.User;
import com.dn.service.UserService;
import com.dn.util.ExtBeansUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.javaboy.encrypt.starter.anno.Decrypt;
import org.javaboy.encrypt.starter.anno.Encrypt;
import org.javaboy.encrypt.starter.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
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
    public String add(@RequestBody RequestUserDto dto) {
        User user = ExtBeansUtils.map(dto, User.class);
        this.userService.insertUser(user);
        return user.getUsername() + " " + user.getMobile();
    }

    @RequestMapping(value = "/queryByMobile", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "通过用户id查询")
    public User findByMobile(@RequestParam("mobile") String mobile) {
        User u = this.userService.findByMobile(mobile);
        return u;
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
        return u == null ? "找不到对象" : (u.getId() + "    " + u.getUsername()+" "+u.getMobile());
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
        u.setId(Long.parseLong(id));
        u.setUsername(userName);
        this.userService.updateUser(u);
        return u.getId() + "    " + u.getUsername();
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

    @GetMapping("/setUser")
    @Encrypt
    public RespBean getUser() {
        TestUser user = new TestUser();
        user.setId((long) 99);
        user.setUsername("javaboy");
        return RespBean.ok("ok", user);
    }

    @PostMapping("/decrUser")
    public RespBean getUser(@RequestBody @Decrypt TestUser user) {
        System.out.println("user = " + user);
        return RespBean.ok("ok", user);
    }
}
