package com.wondersgroup.mapper;

import com.wondersgroup.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectLibrarian();

    void save(User user);
}
