package com.hdjd.springboot.service;

import com.hdjd.springboot.model.Admin;
import com.hdjd.springboot.model.LoginBean;
import com.hdjd.springboot.model.Police;
import com.hdjd.springboot.model.User;

/**
 * @Author: wuyungen
 * @Date: 2018/5/19 23:50
 */
public interface UserService {
    User register(User user);
    User loginUser(LoginBean loginBean);
    Police loginPolice(LoginBean loginBean);
    Admin loginAdmin(LoginBean loginBean);
    int exist(LoginBean loginBean);
}