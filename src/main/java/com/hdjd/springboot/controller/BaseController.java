package com.hdjd.springboot.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hdjd.springboot.model.Appointment;
import com.hdjd.springboot.service.BaseService;
import com.hdjd.springboot.utils.ResultUtil;
import com.hdjd.springboot.view.ResultMsg;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/api/appointment")
public class BaseController {

    @Resource(name = "baseService")
    private BaseService baseService;

    @ApiOperation(value = "根据用户ID获取会见申请列表", notes = "普通用户根据用户id获取申请列表")
    @ResponseBody
    @RequestMapping(value = "/getUserList/{userId}", method = RequestMethod.GET)
    public String getUserList(@PathVariable Long userId) {
        ResultMsg resultMsg;
        try {
            List<Appointment> appointments = baseService.getUserAppointmentList(userId);
            resultMsg = ResultUtil.success("获取成功", appointments);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg, SerializerFeature.WriteMapNullValue);
    }

    @ApiOperation(value = "获取管理员会见申请列表", notes = "管理员获取申请列表")
    @ResponseBody
    @RequestMapping(value = "/getAdminList", method = RequestMethod.GET)
    public String getAdminList() {
        ResultMsg resultMsg;
        try {
            List<Appointment> appointments = baseService.getAdminAppointmentList();
            resultMsg = ResultUtil.success("获取成功", appointments);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg, SerializerFeature.WriteMapNullValue);
    }

    @ApiOperation(value = "获取狱警会见申请列表", notes = "获取狱警会见申请列表")
    @ResponseBody
    @RequestMapping(value = "/getPoliceList", method = RequestMethod.GET)
    public String getPoliceList() {
        ResultMsg resultMsg;
        try {
            List<Appointment> appointments = baseService.getPoliceAppointmentList();
            resultMsg = ResultUtil.success("获取成功", appointments);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg, SerializerFeature.WriteMapNullValue);
    }

    @ApiOperation(value = "修改会见申请信息", notes = "修改会见申请信息")
    @ResponseBody
    @RequestMapping(value = "/updateAppointmentInfo", method = RequestMethod.PUT)
    public String updateAppointmentInfo(@RequestBody @ApiParam(name = "会见申请对象", value = "传入json格式", required = true) Appointment appointment) {
        ResultMsg resultMsg;
        try {
            Appointment updateAppointment = baseService.updateAppointmentInfo(appointment);
            resultMsg = ResultUtil.success("获取成功", updateAppointment);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg, SerializerFeature.WriteMapNullValue);
    }
    @ApiOperation(value = "新增会见申请信息", notes = "新增会见申请信息")
    @ResponseBody
    @RequestMapping(value = "/addNewAppointmentInfo", method = RequestMethod.POST)
    public String addNewAppointmentInfo(@RequestBody @ApiParam(name = "会见申请对象", value = "传入json格式", required = true) Appointment appointment) {
        ResultMsg resultMsg;
        try {
            baseService.addNewAppointment(appointment);
            resultMsg = ResultUtil.success("新增成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg, SerializerFeature.WriteMapNullValue);
    }
}
