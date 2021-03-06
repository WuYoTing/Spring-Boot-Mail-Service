package com.example.Spring.Boot.Mail.Service.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = {
		"/authenticate",
		"/swagger-resources/**",
		"/swagger-ui/**",
		"/v3/api-docs/**",
		"/webjars/**",
		"/api/auth/**",
		"/api/test/**"
	};


	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}



	/**
	 * configure CORS and CSRF,
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
			.csrf().disable()
			// permitAll do not need to auth
			.authorizeRequests()
			.antMatchers(AUTH_WHITELIST).permitAll()
			// other need to auth
			.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(),
			UsernamePasswordAuthenticationFilter.class);
	}
}
