package com.usermanagement.assignment.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor {
    //Request start time identification
    private static final String LOGGER_SEND_TIME = "_send_time";
    //Request log entity ID
    private static final String LOGGER_ENTITY = "_logger_entity";

 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //Create a log entity
        Syslog sysLog = new Syslog();

        //Get request parameter information
        String param = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);

        //Set the request parameters
        sysLog.setParams(param);

        //Set the IP address
        sysLog.setIp(AddressUtils.getIpAddr(request));

        sysLog.setLocation(AddressUtils.getCityInfo(sysLog.getIp()));

        //Set the request method, GET, POST...
        sysLog.setMethod(request.getMethod());

        //Set the request path
        sysLog.setUrl(request.getRequestURI());

        //Set the request start time
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());

        //Set the request entity to the request, convenient afterCompletion method call
        request.setAttribute(LOGGER_ENTITY,sysLog);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        int status = httpServletResponse.getStatus();

        / / According to different status codes, jump to different pages, such as
        if(status==404){
            modelAndView.setViewName("/404");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

        //Get the bean
        SyslogRepo sysLogRepo = SpringContextUtils.getBean("sysLogRepo",SyslogRepo.class);

        / / Get the request error code, stored in the database according to demand, not saved here
        int status = response.getStatus();

        //current time
        long currentTime = System.currentTimeMillis();

        / / Request start time
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());

        / / Get this request log entity
        Syslog sysLog = (Syslog) request.getAttribute(LOGGER_ENTITY);

        / / Set visitors
        sysLog.setUsername("admin");

        / / Set the request time difference
        sysLog.setTime(Integer.valueOf((currentTime - time)+""));

        / / Execute the log into the database, you can save according to actual needs
        if(!sysLog.getMethod().equals("GET")){

        }
        sysLogRepo.save(sysLog);
    }
}