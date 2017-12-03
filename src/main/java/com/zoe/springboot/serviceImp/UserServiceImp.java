package com.zoe.springboot.serviceImp;

import com.zoe.springboot.dao.UserMapper;
import com.zoe.springboot.model.User;
import com.zoe.springboot.service.UserService;
import com.zoe.springboot.utils.UuidUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by zoe on 2017/12/2.
 */

@Service(value = "userService")
public class UserServiceImp implements UserService{

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    /**
     * 添加用户信息
     * @param userName
     * @param userPassword
     * @return
     */
    @Override
    public int insert(String userName,String userPassword) {
        User user = new User();
        user.setUserId(UuidUtil.getUuid());
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setCreateTime(new Date());
        return userMapper.insert(user);
    }
}
