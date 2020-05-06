package com.test.security.testsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.security.testsecurity.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
