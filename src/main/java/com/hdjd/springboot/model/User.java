package com.hdjd.springboot.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: wuyungen
 * @Date: 2018/5/19 23:45
 */
@Getter
@Setter
public class User implements Serializable {
    private Long id;
    private String mail;
    private String name;
    private String idCard;
    private String pwd;
}