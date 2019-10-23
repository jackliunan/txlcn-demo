package com.wondersgroup.service.user;

import com.wondersgroup.entity.User;
import com.wondersgroup.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectLibrarian() {
        return userMapper.selectLibrarian();
    }
}
