package com.hdjd.springboot.serviceImp;

import com.hdjd.springboot.dao.BaseMapper;
import com.hdjd.springboot.dao.PrisonMapper;
import com.hdjd.springboot.model.Appointment;
import com.hdjd.springboot.model.Pos;
import com.hdjd.springboot.model.Prison;
import com.hdjd.springboot.service.BaseService;
import com.hdjd.springboot.service.PrisonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 0:33
 */
@Service(value = "baseService")
public class BaseServiceImpl implements BaseService {
    @Resource
    private BaseMapper baseMapper;

    @Override
    public List<Appointment> getUserAppointmentList(Long userId) {
        return baseMapper.getUserAppointmentList(userId);
    }

    @Override
    public List<Appointment> getAdminAppointmentList() {
        return baseMapper.getAdminAppointmentList();
    }

    @Override
    public List<Appointment> getPoliceAppointmentList() {
        return baseMapper.getPoliceAppointmentList();
    }

    @Override
    public Appointment updateAppointmentInfo(Appointment appointment) {
        return baseMapper.updateAppointmentInfo(appointment);
    }

    @Override
    public int addNewAppointment(Appointment appointment) {
        return baseMapper.addNewAppointment(appointment);
    }
}
