package com.dn.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName:
 * @Description: 分页信息
 * @Author: mark
 * @CreateDate: 2021/3/30 18:05
 * @Version: 1.0
 */
@Data
public class PageInf<T> {
    /**
     * 数据集
     */
    @ApiModelProperty(value = "数据集" , position = 4)
    public List<T> list;

    /**
     * 总条数
     */
    @ApiModelProperty(value = "总条数" , position = 3, example = "45")
    public Long total;

    /**
     * 每页大小
     */
    @ApiModelProperty(value = "每页大小" , position = 1, example = "10")
    public Integer size;

    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码" , position = 0)
    public Integer current;


    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数" , position = 2, example = "5")
    public Integer pages;
}
