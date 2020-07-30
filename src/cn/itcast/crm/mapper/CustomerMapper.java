package cn.itcast.crm.mapper;

import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

import java.util.List;

/**
 * Created by 11877 on 2017/12/26.
 */
public interface CustomerMapper {
    /**
     * 根据queryVo分页查询数据
     *
     * @param queryVo
     * @return
     */
    List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    /**
     * 根据queryVo查询数据条数
     *
     * @param queryVo
     * @return
     */
    int queryCountByQueryVo(QueryVo queryVo);

    Customer queryCustomerById(Long id);

    /**
     * 根据id编辑客户
     *
     * @param customer
     */
    int updateCustomerById(Customer customer);

    int deleteCustomerById(Long id);
}
