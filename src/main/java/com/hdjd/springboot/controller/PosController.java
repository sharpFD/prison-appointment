package com.hdjd.springboot.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hdjd.springboot.model.Pos;
import com.hdjd.springboot.service.PosService;
import com.hdjd.springboot.utils.ResultUtil;
import com.hdjd.springboot.view.ResultMsg;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/api/pos")
public class PosController {

    @Resource(name = "posService")
    private PosService posService;

    @ApiOperation(value = "获取所有空闲会见地点", notes = "获取所有空闲会见地点")
    @ResponseBody
    @RequestMapping(value = "/getAllMeetingPos", method = RequestMethod.GET)
    public String getAllMeetingPos() {
        ResultMsg resultMsg;
        try {
            List<Pos> posList = posService.getAllMeetingPos(0);
            resultMsg = ResultUtil.success("获取成功", posList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg,SerializerFeature.WriteMapNullValue);
    }
}
