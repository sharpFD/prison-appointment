package com.hdjd.springboot.dao;

import com.hdjd.springboot.model.Appointment;
import com.hdjd.springboot.model.Pos;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 0:34
 */
@Repository
public interface PosMapper {
    /**
     * 获取所有会见申请列表
     * @param status
     * @return
     */
    List<Pos> getAllMeetingPos(int status);

    /**
     * 更新地点状态
     * @param map id：  status:
     */
    void editPosStatus(Map map);

}
