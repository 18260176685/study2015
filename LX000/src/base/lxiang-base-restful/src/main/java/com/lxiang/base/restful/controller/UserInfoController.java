package com.lxiang.base.restful.controller;

import com.lxiang.base.core.dao.GenericHBDAO;
import com.lxiang.base.core.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserInfoController
 *
 * @author Administrator
 * @since 2015/4/16
 */
@RestController
public class UserInfoController {

    private GenericHBDAO<UserInfo, Long> userHBDAO = null;

    @Autowired
    public void setUserHBDAO(GenericHBDAO<UserInfo, Long> userHBDAO) {
        this.userHBDAO = userHBDAO;
    }

    private static final String GET_ALL_USERINFO = "/users";

    @RequestMapping(value = GET_ALL_USERINFO, method = RequestMethod.GET)
    public List<UserInfo> allUserInfo() {
        List<UserInfo> userInfoList = userHBDAO.findAll();
        return userInfoList;
    }

}

