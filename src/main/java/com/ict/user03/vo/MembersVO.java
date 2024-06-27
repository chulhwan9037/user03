package com.ict.user03.vo;

import lombok.Data;

@Data
public class MembersVO {
    private Integer idx;
    private String id, name, password, email, created_at, updated_at, last_login, is_activated, kakao, naver, google, provider, phone;
}
