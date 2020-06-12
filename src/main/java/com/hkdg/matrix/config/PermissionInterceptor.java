package com.hkdg.matrix.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hkdg.matrix.controller.LoginController;
import com.xxl.sso.core.entity.ReturnT;
import com.xxl.sso.core.login.SsoTokenLoginHelper;
import com.xxl.sso.core.user.XxlSsoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.net.HttpURLConnection;

/**
 * @author xuxueli 2015-12-12 18:09:04
 */
@Component
public class PermissionInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String sessionId = request.getParameter("sessionId");
        ReturnT<XxlSsoUser> loginCheck = loginCheck(sessionId);
        if (loginCheck.getCode() == ReturnT.SUCCESS_CODE) {
            return true;
        } else {
            sendJsonMessage(response, loginCheck);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 将某个对象转换成json格式并发送到客户端
     *
     * @param response
     * @param obj
     * @throws Exception
     */
    private static void sendJsonMessage(HttpServletResponse response, Object obj) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
        writer.close();
        response.flushBuffer();
    }

    /**
     * @param sessionId
     * @return
     */
    private static ReturnT<XxlSsoUser> loginCheck(String sessionId) {

        // logout
        XxlSsoUser xxlUser = SsoTokenLoginHelper.loginCheck(sessionId);
        if (xxlUser == null) {
            return new ReturnT<>(HttpURLConnection.HTTP_FORBIDDEN, "用户未登录!");
        }
        return new ReturnT<>(xxlUser);
    }

}
