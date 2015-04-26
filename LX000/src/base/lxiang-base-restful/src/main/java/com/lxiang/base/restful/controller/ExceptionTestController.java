package com.lxiang.base.restful.controller;

import com.lxiang.base.restful.constants.ExceptionTestURLConstants;
import com.lxiang.base.restful.constants.UserRestURLConstants;
import com.lxiang.base.restful.exception.BadRequestException;
import com.lxiang.base.restful.exception.ServerRejectException;
import com.lxiang.base.restful.exception.SystemException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * ExcpetionTestController
 *
 * @author Administrator
 * @since 2015/4/26
 */
@RestController
public class ExceptionTestController {

    private static Logger logger = Logger.getLogger(ExceptionTestController.class);

    @RequestMapping(value = ExceptionTestURLConstants.EXCEPTION, method = RequestMethod.GET)
    public void testExceptionHandler(@PathVariable Integer id) throws Exception{
        switch(id) {
            case 4:
                throw new SQLException();
            case 5:
                throw new BadRequestException("Bad Request");
            case 6:
                throw new ServerRejectException("Server Reject");
            case 7:
                throw new SystemException("System Exception");
            default:
                throw new Exception("Normal Exception");
        }
    }


}
