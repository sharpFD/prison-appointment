package com.hdjd.springboot.dao;

import com.hdjd.springboot.model.*;
import org.springframework.stereotype.Repository;
/**
 * @Author: wuyungen
 * @Date: 2018/5/19 23:41
 */
@Repository
public interface UserMapper {
    int insertUser(User user);
    User queryUser(LoginBean loginBean);
    Police queryPolice(LoginBean loginBean);
    Admin queryAdmin(LoginBean loginBean);
    int exist(LoginBean loginBean);
}