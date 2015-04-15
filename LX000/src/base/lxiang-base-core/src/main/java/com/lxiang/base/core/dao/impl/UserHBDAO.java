package com.lxiang.base.core.dao.impl;

import com.lxiang.base.core.dao.GenericHBDAO;
import com.lxiang.base.core.domain.UserInfo;

/**
 * UserHBDAO
 *
 * @author Administrator
 * @since 2015/4/12
 */
public class UserHBDAO extends GenericHBDAO<UserInfo,Long> {

    public UserHBDAO(){
        super(UserInfo.class);
    }

    public UserHBDAO(Class<UserInfo> persistentClass){
        super(persistentClass);
    }
}
