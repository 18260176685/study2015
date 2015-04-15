package com.lxiang.base.core.dao.impl;

import com.lxiang.base.core.BaseTest;
import com.lxiang.base.core.domain.UserInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * UserHBDAOTest
 *
 * @author Administrator
 * @since 2015/4/12
 */
public class UserHBDAOTest{

    private UserHBDAO userHBDAO;

    @Before
    public void init(){
        userHBDAO = (UserHBDAO)BaseTest.getAppContext().getBean("userHBDAO");
    }

    @Test
    public void saveTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Alice");
        userInfo.setTitle("Good Wife");
        userHBDAO.save(userInfo);
        assertNotNull(userInfo.getId());
    }

    @Test
    public void findAllTest(){
        List<UserInfo> list = userHBDAO.findAll();
        for(UserInfo user: list){
            assertNotNull(user.getName());
        }
    }

    @Test
    public void findByIdTest(){
        UserInfo user = userHBDAO.findById(Long.valueOf("1"));
        assertNotNull(user);
    }

}
