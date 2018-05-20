package com.hdjd.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hdjd.springboot.model.Prison;
import com.hdjd.springboot.model.User;
import com.hdjd.springboot.service.PrisonService;
import com.hdjd.springboot.service.UserService;
import com.hdjd.springboot.utils.ResultUtil;
import com.hdjd.springboot.view.ResultMsg;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wuyungen
 * @Date: 2018/5/19 23:35
 */
@Controller
@RequestMapping(value = "/api/prison")
public class PrisonController {
    @Resource(name = "prisonService")
    private PrisonService prisonService;

    /**
     * 获取所有罪犯信息
     * @return
     */
    @ApiOperation(value = "获取所有罪犯信息", notes = "获取所有罪犯信息")
    @ResponseBody
    @RequestMapping(value = "/getAllPrisonInfo", method = RequestMethod.GET)
    public String getAllPrisonInfo() {
        ResultMsg resultMsg;
        try {
            List<Prison> allPrison =prisonService.getAllPrison();
            resultMsg = ResultUtil.success("获取成功", allPrison);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg,SerializerFeature.WriteMapNullValue);
    }

    /**
     * 获取所有罪犯信息
     * @return
     */
    @ApiOperation(value = "根据罪犯id获取罪犯信息", notes = "根据罪犯id获取罪犯信息")
    @ResponseBody
    @RequestMapping(value = "/getPrisonInfo/{prisonId}", method = RequestMethod.GET)
    public String register(@PathVariable Long prisonId) {
        ResultMsg resultMsg;
        try {
            Prison prison = prisonService.getPrisonInfo(prisonId);
            resultMsg = ResultUtil.success("获取成功", prison);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg,SerializerFeature.WriteMapNullValue);
    }
}
