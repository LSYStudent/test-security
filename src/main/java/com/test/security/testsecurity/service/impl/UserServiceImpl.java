package com.test.security.testsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.security.testsecurity.mapper.UserMapper;
import com.test.security.testsecurity.model.User;
import com.test.security.testsecurity.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
