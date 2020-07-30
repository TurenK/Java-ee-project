package cn.itcast.crm.service;

import cn.itcast.crm.pojo.User;

/**
 * Created by 11877 on 2017/12/28.
 */
public interface UserService {
    public boolean register(User user);

    public boolean login(User user);
}
