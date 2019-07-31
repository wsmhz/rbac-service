package com.wsmhz.security.rbac.service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * Created By TangBiJing On 2019/5/11
 * Description:
 */
@Slf4j
@Configuration
@EnableResourceServer
public class WsmhzResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Primary
    @Bean
    public RemoteTokenServices tokenServices() {
        final RemoteTokenServices tokenService = new WsmhzRemoteTokenServices();
        log.info("oauth检验token路径为：{}", securityProperties.getCheckTokenEndpointUrl());
        tokenService.setCheckTokenEndpointUrl(securityProperties.getCheckTokenEndpointUrl());
        tokenService.setClientId(securityProperties.getClients()[0].getClientId());
        tokenService.setClientSecret(securityProperties.getClients()[0].getClientSecret());
        return tokenService;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/select","/insert").permitAll()
                .anyRequest().authenticated();

//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .requestMatchers()
//                .antMatchers("/api/**");

//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .and()
//                .authorizeRequests().anyRequest().permitAll();
    }
}
