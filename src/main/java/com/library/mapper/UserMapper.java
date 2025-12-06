package com.library.mapper;

import com.library.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsernameAndPassword(String username, String password);
    User findById(Integer id);
}
