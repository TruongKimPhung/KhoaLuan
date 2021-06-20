package com.dtu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/admin", "/admin/*").access("hasRole('ADMIN')")
				.antMatchers("/member").access("hasAnyRole('ADMIN','MEMBER')")
				.antMatchers("/thanhtoan", "/user", "/user/*").access("hasAnyRole('ADMIN','MEMBER', 'GUEST')").and()
				.authorizeRequests()
				.antMatchers("/login**").permitAll().and().formLogin().loginPage("/login")
				.loginProcessingUrl("/loginAction").permitAll()
				.failureHandler((req,res,exp)->{  // Failure handler invoked after authentication failure
			         String errMsg="";
			         if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
			            errMsg="Invalid username or password.";
			         }else{
			            //errMsg="Invalid username or password."+exp.getMessage();
			        	 errMsg="Invalid username or password."; // loi khi disable username
			         }
			         req.getSession().setAttribute("message", errMsg);
			         res.sendRedirect("/ecommerce/login"); 
			      })
				.and().logout().logoutSuccessUrl("/login").permitAll()
				.and().exceptionHandling().accessDeniedPage("/404").and().csrf().disable();
	}
}
