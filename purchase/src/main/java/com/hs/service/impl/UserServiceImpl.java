package com.hs.service.impl;

import com.hs.common.ResultVo;
import com.hs.bean.user.User;
import com.hs.mapper.UserMapper;
import com.hs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/5 12:20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultVo getUserList() {
        List<User> userList = userMapper.getUserList();
        return ResultVo.success(userList);
    }
}
