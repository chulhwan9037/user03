package com.ict.user03.vo;

import lombok.Data;

@Data
public class TradeVO {
    private Integer idx;
    private String id, pw, title, content, image_format, created_at, updated_at;
    private byte[] image;
    private long image_size;

}
