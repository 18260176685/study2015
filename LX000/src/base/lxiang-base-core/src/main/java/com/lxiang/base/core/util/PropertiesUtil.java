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

    //��ʼ������prop����
    private PropertiesUtil(){
        InputStream in = PropertiesUtil.class.getResourceAsStream("/config/persistence-mysql");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * ����PropertiesUtil�ĵ�������
     */
    public static PropertiesUtil getInstance() {
        if(instance == null){
            instance = new PropertiesUtil();
        }
        return instance;
    }
    /*
     * �����Զ���prop����Ӧ�Ľ�ֵ
     */
    public String getProperty(String key){
        return (String) prop.get(key);
    }

}
