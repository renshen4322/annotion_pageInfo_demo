package com.dn.dto;

import com.dn.page.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:CategoryDto
 * Package:com.dn.dto
 * Description:
 *
 * @Date:2022/5/5 13:54
 * @Author: mark
 */
@Data
public class CategoryDto extends PageRequest implements Serializable {
    private static final long serialVersionUID = -2513002453171126586L;
}
