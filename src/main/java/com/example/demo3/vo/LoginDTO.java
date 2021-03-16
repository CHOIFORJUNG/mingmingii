package com.example.demo3.vo;

import lombok.Data;

@Data
public class LoginDTO {

    private String userId;
    private String userPw;
    private boolean userCookie;
}
