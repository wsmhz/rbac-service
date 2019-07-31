package com.wsmhz.security.rbac.service.config;

import com.wsmhz.common.business.utils.OAuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * Created By TangBiJing On 2019/5/15
 * Description: 重写资源服务向认证服务验证token步骤，从缓存里面获取进行初步校验，没有直接打回减少http请求
 */
public class WsmhzRemoteTokenServices extends RemoteTokenServices {

    @Autowired
    private OAuthUtil oAuthUtil;

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        if(oAuthUtil.checkToken(accessToken)){
            return super.loadAuthentication(accessToken);
        }
        throw new InvalidTokenException(accessToken);
    }
}
