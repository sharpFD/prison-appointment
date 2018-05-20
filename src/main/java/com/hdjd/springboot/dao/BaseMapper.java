package com.hdjd.springboot.dao;

import com.hdjd.springboot.model.Appointment;
import com.hdjd.springboot.model.Pos;
import com.hdjd.springboot.model.Prison;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 0:34
 */
@Repository
public interface BaseMapper {
    List<Pos> getAllMeetingPos(int status);

    /**
     * 获取会见申请列表
     * @param map  status:申请状态  userId：查看人Id
     * @return
     */
    List<Appointment> getAllMeetingList(Map map);

}
