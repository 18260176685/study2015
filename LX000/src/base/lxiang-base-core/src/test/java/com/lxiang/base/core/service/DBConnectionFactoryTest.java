package com.lxiang.base.core.service;

import com.lxiang.base.core.service.DBConnectionFactory;
import com.lxiang.base.core.service.DBParameterType;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

public class DBConnectionFactoryTest {

    @Test
    public void getConnectionTest() throws Exception{
        Connection conn = DBConnectionFactory.getInstance().getConnection(DBParameterType.INNER);
        assertNotNull(conn);
        conn = DBConnectionFactory.getInstance().getConnection(DBParameterType.PROPERTY);
        assertNotNull(conn);
    }

}
