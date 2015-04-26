package com.lxiang.base.restful.domain;

import com.lxiang.base.restful.constants.ErrorEnum;

/**
 * ExceptionModel
 *
 * @author Administrator
 * @since 2015/4/20
 */
public class ExceptionModel {

    private int status ;

    private String moreInfo = null;

    private String errorCode = null;

    private String message = null;

    private ErrorEnum errorEnum = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
}
