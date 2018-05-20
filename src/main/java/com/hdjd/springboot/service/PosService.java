package com.hdjd.springboot.service;

import com.hdjd.springboot.model.Pos;

import java.util.List;
import java.util.Map;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 0:32
 */
public interface PosService {
    List<Pos> getAllMeetingPos(int status);
    List<Pos> getMeetingPosByKeyWord(String keyword);

    void editPosStatus(Long id,Integer status);
}