package com.lxiang.base.core.controller;

import com.lxiang.base.core.dao.impl.UserHBDAO;
import com.lxiang.base.core.domain.UserInfo;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Validate servlet configure whether is successful.
 *
 * @author Administrator
 * @since 2015/4/15
 */
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private WebApplicationContext webApplicationContext = null;


    public void init() throws ServletException {
        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserHBDAO userHBDAO = (UserHBDAO) webApplicationContext.getBean("userHBDAO");
        List<UserInfo> userInfoList = userHBDAO.findAll();
        for (UserInfo userInfo : userInfoList) {
            resp.getOutputStream().write(userInfo.getName().getBytes());
        }
    }
}
