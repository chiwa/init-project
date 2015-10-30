package com.zengcode.intercetor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@Component
public class ApplicationInterceptor  extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(ApplicationInterceptor.class);

    /**
     * Handle only the buildVersion property
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception { //NOSONAR Override method from base class
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception { //NOSONAR this is actually an override
        String requestUri = request.getRequestURI();

        log.debug("In preHandle, requestUri = {}", requestUri);
        return super.preHandle(request, response, handler);
    }


}
