package com.lxiang.base.restful.constants;

/**
 * ErrorEnum
 *
 * @author Administrator
 * @since 2015/5/26
 */
public enum ErrorEnum {

    OK("200"),
    BAD_REQUEST("400"),
    FORBIDDEN("403"),
    NOT_FOUNT("404"),
    INTNERNAL_SERVER_ERROR("503");


    private String code = null;

    private ErrorEnum(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    @Override
    public String toString() {
        return String.valueOf ( this.code);
    }

}
