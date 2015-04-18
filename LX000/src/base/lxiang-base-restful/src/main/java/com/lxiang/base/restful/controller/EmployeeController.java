package com.lxiang.base.restful.controller;

import com.lxiang.base.core.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * EmployeeController
 *
 * @author Administrator
 * @since 2015/4/17
 */
@Controller
public class EmployeeController {

    @RequestMapping(value = "/rest/emps", method = RequestMethod.GET)
    public @ResponseBody UserInfo getDummyEmployee() {

        UserInfo user = new UserInfo();

        user.setTitle("wife");
        user.setName("Alice");

        return user;
    }

}
