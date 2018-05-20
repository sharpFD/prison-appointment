package com.hdjd.springboot.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 2:05
 */
@Getter
@Setter
public class LoginBean {
    private String mail;
    private String pwd;
    private String userType;
    public LoginBean(){}

    public LoginBean(String mail, String pwd, String userType) {
        this.mail = mail;
        this.pwd = pwd;
        this.userType = userType;
    }
}
