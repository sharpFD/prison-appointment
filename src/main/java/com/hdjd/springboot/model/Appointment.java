package com.hdjd.springboot.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Appointment {
    private Long id;
    private String name;
    private Long prison_id;
    private String description;
    private Timestamp meet_time;
    private String meet_record;
    private Integer status;
    private Pos pos;
    private Prison prison;
}
