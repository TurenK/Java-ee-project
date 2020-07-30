package cn.itcast.crm.controller;

import cn.itcast.crm.pojo.User;
import cn.itcast.crm.service.UserService;
import cn.itcast.crm.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 11877 on 2017/12/28.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String Login(HttpServletRequest httpServletRequest){
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setUser_name(httpServletRequest.getParameter("userName"));
        user.setUser_password(httpServletRequest.getParameter("userPass"));
        if(userService.login(user)){
            return "loginSuc";
        }else{
            return "LoginFail";
        }
    }

    @RequestMapping(value = "regist.do", method = RequestMethod.POST)
    public String Regist(HttpServletRequest httpServletRequest){
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setUser_code("m000"+String.valueOf((int)Math.random()*10.0));
        if(httpServletRequest.getParameter("userName")==null||httpServletRequest.getParameter("userName").isEmpty()
                ||httpServletRequest.getParameter("userPass")==null||httpServletRequest.getParameter("userPass").isEmpty())
            return "RegistFail";
        user.setUser_name(httpServletRequest.getParameter("userName"));
        user.setUser_password(httpServletRequest.getParameter("userPass"));
        user.setUser_state('1');
        if(userService.register(user)){
            return "RegistSucc";
        }else{
            return "RegistFail";
        }
    }
}
