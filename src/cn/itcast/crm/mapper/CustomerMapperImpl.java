package cn.itcast.crm.mapper;

import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
import cn.itcast.crm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11877 on 2017/12/26.
 */
public class CustomerMapperImpl implements CustomerMapper {
    private SqlSession sqlSession;

    @Override
    public List<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
        List<Customer> customerList = new ArrayList<>();
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            if (sqlSession != null) {
                customerList = sqlSession.selectList("queryCustomerByQueryVo",queryVo);
            }
            if (sqlSession != null) {
                sqlSession.commit();
            }
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return customerList;
    }

    @Override
    public int queryCountByQueryVo(QueryVo queryVo) {
        int customerCount = 0;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            if (sqlSession != null) {
                customerCount = sqlSession.selectOne("queryCountByQueryVo",queryVo);
            }
            if (sqlSession != null) {
                sqlSession.commit();
            }
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return customerCount;
    }

    @Override
    public Customer queryCustomerById(Long id) {
        Customer customer = new Customer();
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            if (sqlSession != null) {
                customer = sqlSession.selectOne("queryCustomerById",id);
            }
            if (sqlSession != null) {
                sqlSession.commit();
            }
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return customer;
    }

    @Override
    public int updateCustomerById(Customer customer) {
        int result = -1;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            if (sqlSession != null) {
                result = sqlSession.update("updateCustomerById",customer);
            }
            if (sqlSession != null) {
                sqlSession.commit();
            }
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return result;
    }

    @Override
    public int deleteCustomerById(Long id) {
        int result = -1;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            if (sqlSession != null) {
                result = sqlSession.delete("deleteCustomerById",id);
            }
            if (sqlSession != null) {
                sqlSession.commit();
            }
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return result;
    }
}
