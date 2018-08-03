package org.kc.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @EnableWebSecurity Annotation is used to enable web security in any web
	 * application.
	 * 
	 * @EnableWebMVCSecurity Annotation is used to enable web security in Spring MVC
	 * based web application. NOTE:-
	 * 
	 * @EnableWebSecurity = @EnableWebMVCSecurity + Extra features. That’s
	 * why @EnableWebMVCSecurity Annotation is deprecated in Spring 4.x Framework.
	 * 
	 * “LoginSecurityConfig” class or any class which is designated to configure
	 * Spring Security, should extend “WebSecurityConfigurerAdapter” class or
	 * implement related interface. configureGlobal() method is used to store and
	 * mange User Credentials. In configureGlobal() method, we can use authorities()
	 * method to define our application Roles like “ROLE_USER”. We can also use
	 * roles() method for same purpose. Difference between authorities() and roles()
	 * methods: authorities() needs complete role name like “ROLE_USER” roles()
	 * needs role name like “USER”. It will automatically adds “ROLE_” value to this
	 * “USER” role name.
	 * 
	 * Important method to take care of Login and Logout Security is
	 * configure(HttpSecurity http) The following code snipped is used to avoid
	 * unauthorized access to “/homePage”. If you try to access this page directly,
	 * we will redirected to “/loginPage” page automatically.
	 * 
	 * .antMatchers("/homePage").access("hasRole('ROLE_USER')") If we remove
	 * access(“hasRole(‘ROLE_USER’)”) method call, then we can access this page
	 * without login to our application.
	 * 
	 * We have configured login and logout features using formLogin() and logout()
	 * methods.
	 */
	// method is to store and manage user credintial
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("kc").password("kc").authorities("ROLE_ADMIN");
		// auth.inMemoryAuthentication().withUser("admin").password("123456").authorities("ROLE_ADMIN");
		auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
		  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests()		 .antMatchers("/admin").access("hasRole('ROLE_ADMIN')").and().formLogin();	 
		 http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
			.and().formLogin();

	}
}
