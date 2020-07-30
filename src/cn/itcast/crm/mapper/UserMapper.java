package cn.itcast.crm.mapper;

import cn.itcast.crm.pojo.User;

/**
 * Created by 11877 on 2017/12/28.
 */
public interface UserMapper {
    public boolean insertUser(User user);

    public boolean checkUser(User user);
}
