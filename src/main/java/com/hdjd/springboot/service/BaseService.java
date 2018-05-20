package com.hdjd.springboot.service;

import com.hdjd.springboot.model.Pos;
import com.hdjd.springboot.model.Prison;

import java.util.List;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 0:32
 */
public interface BaseService {
    List<Pos> getAllMeetingPos(int status);
}
