package cn.itcast.crm.controller;

import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
import cn.itcast.crm.service.BaseDictService;
import cn.itcast.crm.service.BaseDictServiceImpl;
import cn.itcast.crm.service.CustomerService;
import cn.itcast.crm.service.CustomerServiceImpl;
import cn.itcast.crm.utils.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 11877 on 2017/12/26.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @RequestMapping("/list.do")
    public String queryCustomerList(QueryVo queryVo, Model model) {
        BaseDictService baseDictService = new BaseDictServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        try {
            // 解决get请求乱码问题
            if (StringUtils.isNotBlank(queryVo.getCustName())) {
                queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 客户来源
        String CUSTOMER_FROM_TYPE = "009";
        List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_FROM_TYPE);
        // 所属行业
        String CUSTOMER_INDUSTRY_TYPE = "001";
        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_INDUSTRY_TYPE);
        // 客户级别
        String CUSTOMER_LEVEL_TYPE = "006";
        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_LEVEL_TYPE);

        // 把前端页面需要显示的数据放到模型中
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        // 分页查询数据
        Page<Customer> page = customerService.queryCustomerByQueryVo(queryVo);
        // 把分页查询的结果放到模型中
        model.addAttribute("page", page);

        // 数据回显
        model.addAttribute("custName", queryVo.getCustName());
        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustry());
        model.addAttribute("custLevel", queryVo.getCustLevel());

        return "customer";
    }

    /**
     * 根据id查询用户,返回json格式数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/edit.do")
    @ResponseBody
    public Customer queryCustomerById(Long id) {
        CustomerService customerService = new CustomerServiceImpl();
        return customerService.queryCustomerById(id);
    }

    /**
     * 根据id查询用户,返回json格式数据
     *
     * @param httpServletRequest
     */
    @RequestMapping(value = "/update.do",method = RequestMethod.POST)
    @ResponseBody
    public String updateCustomer(HttpServletRequest httpServletRequest){
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = new Customer();
        Map<String,String[]> stringStringMap = httpServletRequest.getParameterMap();

        customer.setCust_id(Long.decode(stringStringMap.get("cust_id")[0]));
        customer.setCust_name(stringStringMap.get("cust_name")[0]);
        customer.setCust_source(stringStringMap.get("cust_source")[0]);
        customer.setCust_industry(stringStringMap.get("cust_industry")[0]);
        customer.setCust_level(stringStringMap.get("cust_level")[0]);
        customer.setCust_linkman(stringStringMap.get("cust_linkman")[0]);
        customer.setCust_phone(stringStringMap.get("cust_phone")[0]);
        customer.setCust_mobile(stringStringMap.get("cust_mobile")[0]);
        customer.setCust_zipcode(stringStringMap.get("cust_zipcode")[0]);
        customer.setCust_address(stringStringMap.get("cust_address")[0]);
        int result = customerService.updateCustomerById(customer);
        if(result<0){
            System.out.println("更新失败");
            return "failed";
        }
        return "succeed";
    }

    /**
     * 根据id查询用户,返回json格式数据
     *
     * @param httpServletRequest
     */
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCustomer(HttpServletRequest httpServletRequest){
        CustomerService customerService = new CustomerServiceImpl();
        Long tempid = Long.decode(httpServletRequest.getParameterMap().get("id")[0]);
        if(customerService.deleteCustomerById(tempid)<0){
            System.out.println("更新失败");
            return "failed";
        }
        return "succeed";
    }
}
