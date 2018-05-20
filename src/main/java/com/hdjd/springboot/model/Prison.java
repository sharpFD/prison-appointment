package com.hdjd.springboot.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 0:27
 */
@Getter
@Setter
public class Prison {
    private Long id;
    private String name;
    private String crimeReason;
    private Date crimeTime;
    private String crimeRoom;
    private String crimeSpend;
}
