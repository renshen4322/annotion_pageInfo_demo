package com.dn.controller;

import com.dn.dao.CategoryDao;
import com.dn.dto.CategoryDto;
import com.dn.model.Category;
import com.dn.model.PlatformPingTuanDayStatistics;
import com.dn.page.ListQueryResult;
import com.dn.page.PageInf;
import com.dn.page.PageUtils;
import com.dn.request.PingTuanDayStatQuery;
import com.dn.service.CategoryService;
import com.dn.util.PubRespJsonObj;
import com.dn.util.PubResponseEnum;
import com.dn.util.SysPubCommons;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

/*    @Autowired
    private PayQueryInfoService queryInfoService;*/

    @RequestMapping(value = "/list/tree", method = RequestMethod.GET)
    public List<Category> list() {
        return categoryService.listWithTree();
    }

    @RequestMapping(value = "/page/listInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageInf<Category> queryCategoryList(@RequestBody CategoryDto dto) {
        PageInf<Category> pageInf = PageUtils.executePage(dto, Category.class, () -> categoryDao.selectList());
        return pageInf;
    }

/*    @RequestMapping("/day-list")
    @ResponseBody
    public PubRespJsonObj getPingTuanDayStatList(@RequestBody PingTuanDayStatQuery query) {
        try {
            ListQueryResult<PlatformPingTuanDayStatistics> dayStatListList = queryInfoService.getPingTuanDayStatList(query);
            return SysPubCommons.GetJsonObj(PubResponseEnum.SUCCESS.getCode(), PubResponseEnum.SUCCESS.getValue(), dayStatListList);
        } catch (Exception e) {
            return SysPubCommons.GetJsonObj(PubResponseEnum.RESPONSE_ERROR.getCode(), e.getMessage());
        }
    }*/
}
