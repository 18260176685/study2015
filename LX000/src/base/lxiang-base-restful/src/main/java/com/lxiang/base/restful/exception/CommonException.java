package com.lxiang.base.restful.exception;

import com.lxiang.base.restful.constants.ErrorEnum;

/**
 * CommonException
 *
 * @author Administrator
 * @since 2015/4/20
 */
public class CommonException extends Exception {

    private String moreInfo = null;

    private ErrorEnum errorEnum = null;

    public CommonException(String msg) {
        super(msg);
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }


}
