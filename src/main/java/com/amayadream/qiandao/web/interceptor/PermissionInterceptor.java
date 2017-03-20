package com.amayadream.qiandao.web.interceptor;

import com.amayadream.qiandao.common.util.Constants;
import com.amayadream.qiandao.core.model.User;
import com.amayadream.qiandao.web.exception.AuthorizationException;
import com.amayadream.qiandao.web.exception.BeyondPermissionException;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限切面, 优先级最高
 * @author :  Amayadream
 * @date :  2017.03.15 17:44
 */
@Order(1)
@Aspect
@Component
public class PermissionInterceptor {

    /**
     * 管理员权限拦截切面, 负责对非管理员用户进行的敏感操作进行拦截
     */
    @Before(value = "execution(@com.amayadream.qiandao.common.annotation.AdminOnly * *(..))")
    public void adminOnly() throws AuthorizationException, BeyondPermissionException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User token = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        if(token != null){
            if(StringUtils.isEmpty(token.getRole()) || !Constants.ROLE_ADMIN.equals(token.getRole())){
                throw new BeyondPermissionException();
            }
        }else{
            throw new AuthorizationException();
        }
    }

}
