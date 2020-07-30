package cn.itcast.crm.service;

import cn.itcast.crm.mapper.UserMapper;
import cn.itcast.crm.mapper.UserMapperImpl;
import cn.itcast.crm.pojo.User;
import org.springframework.stereotype.Service;

/**
 * Created by 11877 on 2017/12/28.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public UserServiceImpl(){
        userMapper = new UserMapperImpl();
    }

    @Override
    public boolean register(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public boolean login(User user) {
        return userMapper.checkUser(user);
    }
}
