package com.dn.client;

import lombok.Data;

/**
 * ClassName:OcrRequest
 * Package:com.dn.client
 * Description:
 *
 * @Date:2021/10/20 18:17
 * @Author: mark
 */
@Data
public class OcrRequest {
    private String image_data;

    private String action = "auto";
    private int image_info = 0;
}
