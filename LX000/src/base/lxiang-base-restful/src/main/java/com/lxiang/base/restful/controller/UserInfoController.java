package com.lxiang.base.restful.controller;

import com.lxiang.base.core.dao.GenericHBDAO;
import com.lxiang.base.core.domain.UserInfo;
import com.lxiang.base.restful.constants.UserRestURLConstants;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    private static Logger logger = Logger.getLogger(UserInfoController.class);

    private GenericHBDAO<UserInfo, Long> userHBDAO = null;

    @Autowired
    public void setUserHBDAO(GenericHBDAO<UserInfo, Long> userHBDAO) {
        this.userHBDAO = userHBDAO;
    }

    @RequestMapping(value = UserRestURLConstants.GET_ALL_USER, method = RequestMethod.GET)
    public List<UserInfo> getAllUser(){
        return userHBDAO.findAll();
    }

    /**
     * Get a user by ID
     * @return UserInfo
     */
    @RequestMapping(value = UserRestURLConstants.GET_USER, method = RequestMethod.GET)
    public UserInfo getUser(@PathVariable String id){
        logger.info("Method getUser() is starting");
        Long userId = Long.valueOf(id);
        logger.error("Method getUser is error, user is not exist");
        return userHBDAO.findById(userId);
    }

    @RequestMapping(value = UserRestURLConstants.CREATE_USER, method = RequestMethod.POST)
    public UserInfo addUser(){
        logger.info("Method addUser() is starting");
        logger.error("Method addUser is error");
        return new UserInfo();
    }

    @RequestMapping(value = UserRestURLConstants.DELETE_USER, method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id){
        logger.info("Method deleteuser() is starting");
        logger.debug("Method deleteuser is running");
        logger.error("Method deleteuser is error");
        UserInfo userInfo = userHBDAO.findById(Long.valueOf(id));
        userHBDAO.delete(userInfo);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}

