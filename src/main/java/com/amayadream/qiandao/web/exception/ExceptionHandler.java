package com.amayadream.qiandao.web.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring MVC 统一异常处理器
 * @author :  Amayadream
 * @date :  2016.08.13 12:38
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("e", e);
        if(e instanceof AuthorizationException){
            model.put("overtime", true);
            return new ModelAndView("redirect:/auth/login?target=" + request.getRequestURI(), model);
        } else if(e instanceof BeyondPermissionException){
            model.put("button", "close");
            return new ModelAndView("error", model);
        } else if (e instanceof PageNotFoundException) { //页面未找到错误
            return new ModelAndView("404", model);
        } else if(e instanceof UndeclaredThrowableException){   //这里造成这个异常的原因是切面代理里抛出的异常但是被切的方法并没有抛这个异常,所以jdk无法识别异常
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            model.put("e", exception.getUndeclaredThrowable());
            return new ModelAndView("error", model);
        } else {
            return new ModelAndView("error", model);
        }
    }


}
