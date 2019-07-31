package com.wsmhz.security.rbac.service.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created By TangBiJing On 2019/5/13
 * Description:
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "wsmhz.security.oauth2")
public class SecurityProperties {

    /**
     * 客户端配置
     */
    private OAuth2ClientProperties[] clients = {};
    /**
     * 资源服务检查token的url
     */
    private String checkTokenEndpointUrl;
}
