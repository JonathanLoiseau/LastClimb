package com.last_climb.climb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/index", "/account", "/resources/**", "/css/**", "/images/**", "/site/**", "/style**",
						"/find_site", "/secteur_display","/script/**","/img/**")
				.permitAll().antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated().and().formLogin()
				.loginPage("/connexion").permitAll().and().logout().permitAll();

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
