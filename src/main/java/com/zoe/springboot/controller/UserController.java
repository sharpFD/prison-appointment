package com.zoe.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.zoe.springboot.service.UserService;
import com.zoe.springboot.utils.ResultUtil;
import com.zoe.springboot.view.ResultMsg;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zoe on 2017/12/2.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    /**
     * 用户注册
     * @param userName
     * @param userPassword
     * @return
     */
    @ApiOperation(value="用户注册", notes="根据用户名和密码进行注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "userPassword", value = "密码", required = true, paramType = "form", dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam(required = true) String userName,
                              @RequestParam(required = true) String userPassword){
        ResultMsg resultMsg;
        try {
            userService.insert(userName,userPassword);
            resultMsg = ResultUtil.success("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg);
    }
}
