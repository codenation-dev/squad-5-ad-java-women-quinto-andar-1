package br.com.quintoandar.sakuraerrorcaptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import br.com.quintoandar.sakuraerrorcaptor.dto.LoginUserDTO;
import br.com.quintoandar.sakuraerrorcaptor.repository.SystemUserRepository;

@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, SystemUserRepository systemUserRepository) throws Exception {
	    builder.userDetailsService(email -> new LoginUserDTO(systemUserRepository.findByEmail(email)));
	}
}
