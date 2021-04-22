
package com.farm.config;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.farm.exception.FarmAccessDeniedHandler;

import com.farm.services.authentication.FarmUserDetailsService;
import com.farm.settings.Constants;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FarmSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private FarmUserDetailsService farmUserDetailsService;

	@Autowired
	private FarmJwtTokenUtil farmJwtTokenUtil;

	@Autowired
	private FarmAuthenticationEntryPoint farmAuthenticationEntryPoint;

	@Autowired
	private FarmAccessDeniedHandler farmAccessDeniedHandler;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs", Constants.BASE_URI + "/login", Constants.BASE_URI + "/register",
				
				Constants.BASE_URI + "/resend-code",Constants.BASE_URI + "/role", Constants.BASE_URI + "/home/page-data",
				
				Constants.BASE_URI + "/forgot-password",Constants.BASE_URI + "/verify",Constants.BASE_URI + "/reset-password",
				
				Constants.BASE_URI + "/home/vacancies", Constants.BASE_URI + "/home/vacancies/{id}", Constants.BASE_URI + "/home/companies" ,
				
				Constants.BASE_URI + "/home/companies/{id}", Constants.BASE_URI +"/users/cover_image/{imageName}",  Constants.BASE_URI+"/users/avatar/{imageName}",
				
				Constants.BASE_URI +"/cv/{imageName}",Constants.BASE_URI +"/vacancybanner/{imageName}",Constants.BASE_URI +"/job-seekers/email-verification",
		
		        Constants.BASE_URI +"/home/companies",Constants.BASE_URI +"/home/job-seekers"
		        
		        ,Constants.BASE_URI +"/job-seekers/page-data",Constants.BASE_URI +"/job-seeker/expiry");
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(farmUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().anonymous().disable().cors().and().authorizeRequests().antMatchers("/v2/api-docs")
				.permitAll().antMatchers(Constants.BASE_URI + "/home/companies/{id}").permitAll()
				.antMatchers(Constants.BASE_URI + "/register").permitAll().antMatchers(Constants.BASE_URI + "/role")
				.permitAll().antMatchers(Constants.BASE_URI + "/home/page-data").permitAll()
				.antMatchers(Constants.BASE_URI + "/home/vacancies").permitAll()
				.antMatchers(Constants.BASE_URI + "/home/vacancies/{id}").permitAll()
				.antMatchers(Constants.BASE_URI + "/home/companies").permitAll()
				.antMatchers(Constants.BASE_URI + "/reset-password").permitAll()
				.antMatchers(Constants.BASE_URI + "/forgot-password").permitAll()
				.antMatchers(Constants.BASE_URI + "/verify").permitAll()
				.antMatchers(Constants.BASE_URI + "/resend-code").permitAll()
				.antMatchers(  Constants.BASE_URI+"/users/avatar/{imageName}").permitAll()
				.antMatchers( Constants.BASE_URI +"/users/cover_image/{imageName}").permitAll()
				.antMatchers( Constants.BASE_URI +"/cv/{imageName}").permitAll()
				.antMatchers( Constants.BASE_URI +"/vacancybanner/{imageName}").permitAll()
				.antMatchers( Constants.BASE_URI +"/job-seekers/email-verification").permitAll()
				.antMatchers( Constants.BASE_URI +"/home/companies").permitAll()
				.antMatchers( Constants.BASE_URI +"/home/job-seekers").permitAll()
				.antMatchers( Constants.BASE_URI +"/job-seekers/page-data").permitAll()
				.antMatchers( Constants.BASE_URI +"/job-seeker/expiry").permitAll()
				.anyRequest().authenticated().and()
				.exceptionHandling().authenticationEntryPoint(farmAuthenticationEntryPoint)
				.accessDeniedHandler(farmAccessDeniedHandler).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(new FarmJwtAuthenticationFilter(authenticationManagerBean(), farmJwtTokenUtil,
				farmUserDetailsService), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public RegistrationBean jwtAuthFilterRegister(FarmJwtAuthenticationFilter filter) {
		FilterRegistrationBean<FarmJwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<>(filter);
		registrationBean.setEnabled(false);
		return registrationBean;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}
	

