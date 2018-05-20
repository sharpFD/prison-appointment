package com.hdjd.springboot.serviceImp;

import com.hdjd.springboot.dao.PrisonMapper;
import com.hdjd.springboot.model.Pos;
import com.hdjd.springboot.model.Prison;
import com.hdjd.springboot.service.PrisonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 0:33
 */
@Service(value = "prisonService")
public class PrisonServiceImpl implements PrisonService {
    @Resource
    private PrisonMapper prisonMapper;

    @Override
    public Prison getPrisonInfo(Long prisonId) {
        return prisonMapper.queryPrisonInfoById(prisonId);
    }

    @Override
    public List<Prison> getAllPrison() {
        return prisonMapper.queryAllPrisons();
    }

    @Override
    public List<Prison> getPrisonsByName(String prisonName) {
        return null;
    }

}
