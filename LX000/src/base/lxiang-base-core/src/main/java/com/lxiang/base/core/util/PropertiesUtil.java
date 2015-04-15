package com.lxiang.base.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesUtil
 *
 * @author Administrator
 * @since 2015/4/6
 */
public class PropertiesUtil {

    private static Properties prop = new Properties();

    private static PropertiesUtil instance = null;

    //初始化属性prop对象
    private PropertiesUtil(){
        InputStream in = PropertiesUtil.class.getResourceAsStream("/config/persistence-mysql");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * 返回PropertiesUtil的单例对象
     */
    public static PropertiesUtil getInstance() {
        if(instance == null){
            instance = new PropertiesUtil();
        }
        return instance;
    }
    /*
     * 读属性对象prop读对应的健值
     */
    public String getProperty(String key){
        return (String) prop.get(key);
    }

}
