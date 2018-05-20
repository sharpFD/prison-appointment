package com.hdjd.springboot.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 2:01
 */
@Getter
@Setter
public class Admin {
    private Long id;
    private String mail;
    private String name;
    private String pwd;
}
