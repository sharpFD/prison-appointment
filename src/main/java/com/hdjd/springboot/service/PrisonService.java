package com.hdjd.springboot.service;

import com.hdjd.springboot.model.Prison;

import java.util.List;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 0:32
 */
public interface PrisonService {
    Prison getPrisonInfo(Long prisonId);
    List<Prison> getAllPrison();
    List<Prison> getPrisonsByName(String prisonName);
}
