package cn.itcast.crm.mapper;

import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.User;
import cn.itcast.crm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11877 on 2017/12/28.
 */
public class UserMapperImpl implements UserMapper {
    private SqlSession sqlSession;

    @Override
    public boolean insertUser(User user) {
        int result = -1;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            if (sqlSession != null) {
                result = sqlSession.insert("insertUser",user);
            }
            if (sqlSession != null) {
                sqlSession.commit();
            }
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        if(result<0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean checkUser(User user) {
        List<User> userList = new ArrayList<>();
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            if (sqlSession != null) {
                userList = sqlSession.selectList("checkUser",user);
            }
            if (sqlSession != null) {
                sqlSession.commit();
            }
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        if(userList!=null&&!userList.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
