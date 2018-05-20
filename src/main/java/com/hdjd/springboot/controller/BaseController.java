package com.hdjd.springboot.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hdjd.springboot.model.Pos;
import com.hdjd.springboot.model.Prison;
import com.hdjd.springboot.service.BaseService;
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
@RequestMapping(value = "/api/admin")
public class BaseController {

    @Resource(name = "baseService")
    private BaseService baseService;

    @ApiOperation(value = "根据用户获取会见申请列表", notes = "根据用户获取会见申请列表")
    @ResponseBody
    @RequestMapping(value = "/getPrisonInfo/{userId}", method = RequestMethod.GET)
    public String register(@PathVariable Long userId) {
        ResultMsg resultMsg;
        try {
            //Prison prison = prisonService.getPrisonInfo(prisonId);
            resultMsg = ResultUtil.success("获取成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg, SerializerFeature.WriteMapNullValue);
    }

}
