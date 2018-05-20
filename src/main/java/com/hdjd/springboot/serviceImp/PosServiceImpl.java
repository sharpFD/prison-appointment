package com.hdjd.springboot.serviceImp;

import com.hdjd.springboot.dao.BaseMapper;
import com.hdjd.springboot.dao.PosMapper;
import com.hdjd.springboot.model.Pos;
import com.hdjd.springboot.service.BaseService;
import com.hdjd.springboot.service.PosService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 0:33
 */
@Service(value = "posService")
public class PosServiceImpl implements PosService {
    @Resource
    private PosMapper posMapper;

    @Override
    public List<Pos> getAllMeetingPos(int status) {
        return posMapper.getAllMeetingPos(status);
    }

    @Override
    public List<Pos> getMeetingPosByKeyWord(String keyword) {
        return null;
    }
}
