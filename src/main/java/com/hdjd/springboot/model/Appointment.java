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
    private String describtion;
    private Timestamp meet_time;
    private String meet_record;
    private String state;
    private Pos pos;
    private Prison prison;
}
