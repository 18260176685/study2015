package com.lxiang.base.core.service;

import com.lxiang.base.core.util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnectionFactory
 *
 * @author Administrator
 * @since 2015/4/6
 */
public class DBConnectionFactory {

    private static DBConnectionFactory instance = null;

    // 驱动程序名
    private String driver = "com.mysql.jdbc.Driver";

    // URL指向要访问的数据库名scutcs
    private String url = "jdbc:mysql://127.0.0.1:3306/test";

    // MySQL配置时的用户名
    private String user = "root";

    // MySQL配置时的密码
    private String password = "xiang1LIANG2";

    public static DBConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DBConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection(DBParameterType type) {
        if (DBParameterType.INNER.equals(type)) {
            return getConnection(driver, url, user, password);
        }
        if (DBParameterType.PROPERTY.equals(type)) {
            return getConnectionByProperty();
        }
        return null;
    }

    /**
     * 在方法中固化连接参数
     *
     * @return 数据库连接
     */
    private Connection getConnection(String driver, String url, String user, String password) {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        } catch (SQLException ce) {
            ce.printStackTrace();
        } catch (Exception ce) {
            ce.printStackTrace();
        }
        return connection;
    }

    /**
     * 通过properties配置文件的方式灵活配置连接参数，properties中的属性名固化
     *
     * @return 数据库连接
     */
    private Connection getConnectionByProperty() {
        PropertiesUtil propertiesUtil = PropertiesUtil.getInstance();
        driver = propertiesUtil.getProperty("jdbc.driverClassName");
        url = propertiesUtil.getProperty("jdbc.url");
        user = propertiesUtil.getProperty("jdbc.user");
        password = propertiesUtil.getProperty("jdbc.pass");
        return getConnection(driver, url, user, password);
    }
}
