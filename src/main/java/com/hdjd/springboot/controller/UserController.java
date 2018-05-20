package com.hdjd.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hdjd.springboot.model.Admin;
import com.hdjd.springboot.model.LoginBean;
import com.hdjd.springboot.model.Police;
import com.hdjd.springboot.model.User;
import com.hdjd.springboot.service.UserService;
import com.hdjd.springboot.utils.ResultUtil;
import com.hdjd.springboot.view.ResultMsg;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wuyungen
 * @Date: 2018/5/19 23:35
 */
@Controller
@RequestMapping(value = "/api")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "根据邮箱、身份证号、姓名和密码进行注册")
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody @ApiParam(name = "用户对象", value = "传入json格式", required = true) User user) {
        ResultMsg resultMsg;
        try {
            int count = userService.exist(new LoginBean(user.getMail(), user.getPwd(), "user"));
            if (count != 0) {
                resultMsg = ResultUtil.success("用户已存在", user);
            } else {
                userService.register(user);
                resultMsg = ResultUtil.success("注册成功", user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultUtil.systemError();
        }
        return JSON.toJSONString(resultMsg);
    }


    @ApiOperation(value = "用户登陆", notes = "根据邮箱和密码进行登陆")
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody @ApiParam(name = "用户对象", value = "传入json格式", required = true) LoginBean loginBean) {
        ResultMsg resultMsg;
        if (!loginBean.getUserType().equals("user")
                && !loginBean.getUserType().equals("police")
                && !loginBean.getUserType().equals("admin")) {
            resultMsg = ResultUtil.error(304, "用户类型出错", null);
        } else {
            try {
                int count = userService.exist(loginBean);
                if (count == 0) {
                    resultMsg = ResultUtil.success("用户不存在", null);
                } else {
                    Map<String, Object> map = new HashMap<>();
                    switch (loginBean.getUserType()) {
                        case "police":
                            Police police = userService.loginPolice(loginBean);
                            map.put("userType", "police");
                            map.put("userInfo", police);
                            if (police == null) {
                                resultMsg = ResultUtil.success("用户名或密码错误", null);
                            } else {
                                map.put("userType", "police");
                                map.put("userInfo", police);
                                resultMsg = ResultUtil.success("登陆成功", map);
                            }
                            break;
                        case "admin":
                            Admin admin = userService.loginAdmin(loginBean);
                            map.put("userType", "admin");
                            map.put("userInfo", admin);
                            if (admin == null) {
                                resultMsg = ResultUtil.success("用户名或密码错误", null);
                            } else {
                                map.put("userType", "admin");
                                map.put("userInfo", admin);
                                resultMsg = ResultUtil.success("登陆成功", map);
                            }
                            break;
                        default:
                            User user = userService.loginUser(loginBean);
                            if (user == null) {
                                resultMsg = ResultUtil.success("用户名或密码错误", null);
                            } else {
                                map.put("userType", "user");
                                map.put("userInfo", user);
                                resultMsg = ResultUtil.success("登陆成功", map);
                            }
                            break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                resultMsg = ResultUtil.systemError();
            }
        }
        return JSON.toJSONString(resultMsg, SerializerFeature.WriteMapNullValue);
    }
}
