package cn.cuiper.config;

import cn.cuiper.annotation.MyLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class MyLogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            MyLog myLog = handlerMethod.getMethodAnnotation(MyLog.class);
            if (myLog != null) {
                log.info("MyLog信息为:" + myLog.toString());
            }
        }
        return true;
    }
}
