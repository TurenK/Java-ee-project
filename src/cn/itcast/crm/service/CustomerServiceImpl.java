package cn.itcast.crm.service;

import cn.itcast.crm.mapper.CustomerMapper;
import cn.itcast.crm.mapper.CustomerMapperImpl;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
import cn.itcast.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 11877 on 2017/12/26.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerMapper customerMapper;

    public CustomerServiceImpl(){
        customerMapper = new CustomerMapperImpl();
    }

    @Override
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
        // 设置查询条件,从哪一条数据开始查
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

        // 查询数据结果集
        List<Customer> list = this.customerMapper.queryCustomerByQueryVo(queryVo);
        // 查询到的数据总条数
        int total = this.customerMapper.queryCountByQueryVo(queryVo);

        // 封装返回的page对象
        return new Page<>(total, queryVo.getPage(), queryVo.getRows(), list);
    }

    @Override
    public Customer queryCustomerById(Long id) {
        return customerMapper.queryCustomerById(id);
    }

    @Override
    public int updateCustomerById(Customer customer) {
        return this.customerMapper.updateCustomerById(customer);
    }

    @Override
    public int deleteCustomerById(Long id) {
        return customerMapper.deleteCustomerById(id);
    }
}

