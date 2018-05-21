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
    /**
     * 普通用户获取会见申请列表
     * @param userId
     * @return
     */
    List<Appointment> getUserAppointmentList(Long userId);

    /**
     * 管理员获取会见申请列表
     * @return
     */
    List<Appointment> getAdminAppointmentList();

    /**
     * 狱警获取用户申请列表
     * @return
     */
    List<Appointment> getPoliceAppointmentList();

    /**
     * 修改会见申请信息
     * @param appointment
     * @return
     */
    void updateAppointmentInfo(Appointment appointment);

    /**
     * 新增会见申请
     * @param appointment
     * @return
     */
    void addNewAppointment(Appointment appointment);
}
