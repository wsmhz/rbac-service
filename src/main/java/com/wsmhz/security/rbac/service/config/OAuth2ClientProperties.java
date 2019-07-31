package com.wsmhz.security.rbac.service.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * create by tangbj on 2018/4/8
 * 认证服务器注册的第三方应用配置项
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OAuth2ClientProperties {
	
	/**
	 * 第三方应用appId
	 */
	private String clientId;
	/**
	 * 第三方应用appSecret
	 */
	private String clientSecret;

}
