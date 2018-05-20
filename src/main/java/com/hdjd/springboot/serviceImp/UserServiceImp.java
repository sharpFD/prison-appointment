package com.hdjd.springboot.serviceImp;

import com.hdjd.springboot.dao.UserMapper;
import com.hdjd.springboot.model.Admin;
import com.hdjd.springboot.model.LoginBean;
import com.hdjd.springboot.model.Police;
import com.hdjd.springboot.model.User;
import com.hdjd.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wuyungen
 * @Date: 2018/5/20 00:12
 */

@Service(value = "userService")
public class UserServiceImp implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    /**
     * 用户注册类
     * @param user
     * @return
     */
    @Override
    public User register(User user) {
        userMapper.insertUser(user);
        return user;
    }

    /**
     * 用户登录类
     * @param user
     * @return
     */
    @Override
    public User loginUser(LoginBean loginBean) {
        return userMapper.queryUser(loginBean);
    }

    /**
     * 狱警登陆类
     * @param police
     * @return
     */
    @Override
    public Police loginPolice(LoginBean loginBean) {
        return userMapper.queryPolice(loginBean);
    }

    /**
     * 管理员登陆类
     * @param admin
     * @return
     */
    @Override
    public Admin loginAdmin(LoginBean loginBean) {
        return userMapper.queryAdmin(loginBean);
    }

    @Override
    public int exist(LoginBean loginBean) {
        return userMapper.exist(loginBean);
    }

}
