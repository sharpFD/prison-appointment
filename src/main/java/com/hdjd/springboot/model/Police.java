package com.hdjd.springboot.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 2:00
 */
@Getter
@Setter
public class Police {
    private Long id;
    private String name;
    private String mail;
    private String policeRank;
    private Date policeStartDt;
    private String pwd;
}
