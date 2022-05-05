package com.dn.controller;

import com.dn.dao.CategoryDao;
import com.dn.dto.CategoryDto;
import com.dn.model.Category;
import com.dn.page.PageInf;
import com.dn.page.PageUtils;
import com.dn.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
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
@RefreshScope
@RequestMapping("/category")
@Api(tags = {"分类Api文档"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "/list/tree", method = RequestMethod.GET)
    public List<Category> list() {
        return categoryService.listWithTree();
    }

    @RequestMapping(value = "/page/category", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInf<Category> queryCategoryList(@RequestBody CategoryDto dto) {
        List<Category> entities = categoryDao.selectList();
        List<Category> finalEntities = entities;
        PageInf<Category> pageInf = PageUtils.executePage(dto, () -> finalEntities);

        return pageInf;
    }
}
