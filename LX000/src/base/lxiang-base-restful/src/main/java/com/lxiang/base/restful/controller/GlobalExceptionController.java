package com.lxiang.base.restful.controller;

import com.lxiang.base.restful.constants.ErrorEnum;
import com.lxiang.base.restful.domain.ExceptionModel;
import com.lxiang.base.restful.exception.*;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * GlobalExceptionController
 *
 * @author Administrator
 * @since 2015/4/20
 */
@ControllerAdvice
public class GlobalExceptionController {

    private static Logger logger = Logger.getLogger(UserInfoController.class);

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handleSQLException(HttpServletRequest request,
                                                  SQLException ex) {
        handleLog(request, ex);
        Map<String, Object> errorMap = new HashMap<String, Object>();
        errorMap.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
        errorMap.put("Requested", request.getRequestURL());
        errorMap.put("message", ex.toString());

        return errorMap;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionModel handleBadRequestException(
            HttpServletRequest request, BadRequestException ex) {
        handleLog(request, ex);
        ExceptionModel exceptionModel = getExceptionModel(
                HttpStatus.BAD_REQUEST, ex);
        return exceptionModel;
    }

    @ExceptionHandler(ServerRejectException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ResponseBody
    public ExceptionModel handleServerRejectException(
            HttpServletRequest request, ServerRejectException ex) {
        handleLog(request, ex);
        ExceptionModel exceptionModel = getExceptionModel(HttpStatus.FORBIDDEN,
                ex);
        return exceptionModel;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionModel handleNotFoundException(HttpServletRequest request,
                                                  NotFoundException ex) {
        handleLog(request, ex);
        ExceptionModel exceptionModel = getExceptionModel(HttpStatus.NOT_FOUND,
                ex);
        return exceptionModel;
    }

    @ExceptionHandler(SystemException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionModel handleSystemException(HttpServletRequest request,
                                                SystemException ex) {
        handleLog(request, ex);
        ExceptionModel exceptionModel = getExceptionModel(
                HttpStatus.INTERNAL_SERVER_ERROR, ex);
        return exceptionModel;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handleAllException(HttpServletRequest request,
                                                  Exception ex) {

        handleLog(request, ex);
        Map<String, Object> errorMap = new HashMap<String, Object>();
        errorMap.put("code",
                Integer.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        errorMap.put("message", ex.toString());
        return errorMap;

    }

    private ExceptionModel getExceptionModel(HttpStatus httpStatus,
                                             CommonException ex) {
        ExceptionModel exceptionModel = new ExceptionModel();
        ErrorEnum errorEnum = ex.getErrorEnum();
        exceptionModel.setStatus(httpStatus.value());
        exceptionModel.setMoreInfo(ex.getMoreInfo());
        if (errorEnum != null) {
            exceptionModel.setErrorCode(errorEnum.getCode());
            exceptionModel.setMessage(errorEnum.toString());
        }
        return exceptionModel;
    }

    private void handleLog(HttpServletRequest request, Exception ex) {
        Map parameter = request.getParameterMap();
        StringBuffer logBuffer = new StringBuffer();
        if (request != null) {
            logBuffer.append("  request method=" + request.getMethod());
            logBuffer.append("  url=" + request.getRequestURL());
        }
        if (ex instanceof CommonException) {
            logBuffer.append("  moreInfo="
                    + ((CommonException) ex).getMoreInfo());
        }
        if (ex != null) {
            logBuffer.append("  exception:" + ex);
        }
        logger.error(logBuffer.toString());
    }
}
