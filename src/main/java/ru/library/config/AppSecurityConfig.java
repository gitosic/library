package ru.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests()
				.antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')")
				.antMatchers("/free/**").permitAll()
				.antMatchers("/free2/**").access("hasRole('ROLE_USER')")
				.antMatchers("/booksList/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/addBook/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/editBook/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/update/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/delete/**").access("hasRole('ROLE_ADMIN')")
				.and().formLogin().defaultSuccessUrl("/", false);
	}
}
