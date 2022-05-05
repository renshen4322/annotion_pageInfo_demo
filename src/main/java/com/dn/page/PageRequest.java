package com.dn.page;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 请求分页信息
 */
@Setter
@Getter
public class PageRequest {
    /**
     * 当前页码
     */
    @NotNull(message = "当前页不能为空")
    @Min(value = 0, message = "请求页必须大于等于0")
    @ApiModelProperty(value = "当前页码", example = "1", required = true)
    private Integer current;

    /**
     * 每页条数
     */
    @NotNull(message = "每页显示条数不能为空")
    @Max(value = 200, message = "每页最大条数不能超过200")
    @ApiModelProperty(value = "每页条数", example = "20", required = true)
    private Integer size;
}
