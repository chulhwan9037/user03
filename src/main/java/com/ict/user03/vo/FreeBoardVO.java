package com.ict.user03.vo;

import lombok.Data;

@Data
public class FreeBoardVO {
    private Integer idx;
    private String id, pw, title, content, created_at, update_at;
}
