package com.lxiang.base.core;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BaseTest
 *
 * @author Administrator
 * @since 2015/4/12
 */
public class BaseTest {

    private static ApplicationContext context = null;

    public static ApplicationContext getAppContext(){
        if(context == null){
            context = new ClassPathXmlApplicationContext("config/applicationContext-*.xml");
        }
        return context;
    }
}
