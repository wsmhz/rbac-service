package com.wsmhz.security.rbac.service.interceptor;

import com.wsmhz.common.business.utils.OAuthUtil;
import com.wsmhz.common.business.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * Created By tangbj On 2019/7/31
 * Description:
 */
public class RbacPermission implements HandlerInterceptor {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private OAuthUtil oAuthUtil;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = oAuthUtil.getTokenByRequest(request);




        boolean hasPermission = false;
        // 读取用户所拥有权限的所有URL
        Set<String> resources = redisUtil.getSet().get(token);
        // 所有管理员都可以获取到自己的资源
        resources.add("manage/admin/*/resource");
        String uri = StringUtils.substringAfter(request.getRequestURI(),"/");
        for (String resource : resources) {
            if(StringUtils.isNotBlank(resource) && antPathMatcher.match(resource, uri)){
                hasPermission = true;
                break;
            }
        }
        return hasPermission;
    }
}
