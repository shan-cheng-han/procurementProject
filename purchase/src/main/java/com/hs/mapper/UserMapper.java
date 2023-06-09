package com.hs.mapper;

import com.hs.bean.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/5 12:20
 */
@Mapper
public interface UserMapper {

    List<User> getUserList();
}
