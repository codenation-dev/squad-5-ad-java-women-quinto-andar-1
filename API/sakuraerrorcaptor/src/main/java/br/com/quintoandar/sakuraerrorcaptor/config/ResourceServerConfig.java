package br.com.quintoandar.sakuraerrorcaptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/v2/api-docs", 
        			"/configuration/ui", 
        			"/swagger-resources", 
        			"/configuration/security", 
        			"/swagger-ui.html", 
        			"/webjars/**",
        			"/swagger-resources/configuration/ui",
        			"/swagger-ui.html").permitAll()
            .antMatchers(HttpMethod.POST, "/tenant").permitAll()
            .antMatchers(HttpMethod.GET, "/tenant").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()            
            .antMatchers(HttpMethod.GET, "/login").authenticated()
            .anyRequest().authenticated();
        
    }
}