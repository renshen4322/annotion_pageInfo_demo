package com.dn.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dn.service.OrderService;



@RestController
@RequestMapping("/order")
@Api(tags = {"订单操作类Api文档"})
public class OrderController {

	@Autowired
	private OrderService orderService;


	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ApiOperation(value = "订单查询和分页")
	public Object query(String customerId, int pageNum, int pageSize) {
		return this.orderService.pageQuery(customerId, pageNum, pageSize);

	}
}
