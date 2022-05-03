package com.dn.dto;

import com.dn.model.Demo;
import lombok.Data;

import java.util.List;

/**
 * ClassName:DemoSearchResult
 * Package:com.dn.dto
 * Description:
 *
 * @Date:2022/5/1 14:47
 * @Author: mark
 */
@Data
public class DemoSearchResult {
    List<Demo> demos;
    Long totalSize;
}
