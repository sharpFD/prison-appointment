package com.hdjd.springboot.dao;

import com.hdjd.springboot.model.Prison;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 0:34
 */
@Repository
public interface PrisonMapper {
    Prison queryPrisonInfoById(Long prisonId);
    List<Prison> queryAllPrisons();
    List<Prison> queryPrisonByName(String prisonName);
}
