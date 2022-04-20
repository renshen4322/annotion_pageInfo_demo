package com.dn.controller;

import com.dn.model.Category;
import com.dn.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:CategoryController
 * Package:com.dn.controller
 * Description:
 *
 * @Date:2021/11/29 20:13
 * @Author: mark
 */
@RestController
@RequestMapping("/category")
@Api(tags = {"分类Api文档"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;



    @RequestMapping(value = "/list/tree", method = RequestMethod.GET)
    public List<Category> list() {
        return categoryService.listWithTree();
    }

}
