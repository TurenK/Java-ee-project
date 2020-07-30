package cn.itcast.crm.service;

import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
import cn.itcast.crm.utils.Page;

/**
 * Created by 11877 on 2017/12/26.
 */
public interface CustomerService {
    /**
     * 根据条件分页查询客户
     *
     * @param queryVo
     * @return
     */
    Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    Customer queryCustomerById(Long id);

    /**
     * 根据id编辑客户
     *
     * @param customer
     */
    int updateCustomerById(Customer customer);

    int deleteCustomerById(Long id);
}
