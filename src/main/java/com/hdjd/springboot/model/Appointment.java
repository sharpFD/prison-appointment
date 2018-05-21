package com.hdjd.springboot.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class Appointment {
    private Long id;
    private String userId;
    private String userName;
    private String mail;
    private Long prisonId;
    private String prisonName;
    private String posStatus;
    private Long posId;
    private String posName;
    private String meetTime;
    private String crimeRoom;
    private Integer state;
    private String meetRecord;
    private String description;
    private String memo;
}