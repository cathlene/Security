package springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users= User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("John").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("Mary").password("test123").roles("EMPLOYEE","MANAGER"))
		.withUser(users.username("Susan").password("test123").roles("EMPLOYEE","ADMIN"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.anyRequest().authenticated() dit weg want nu wil je roles die bepaalde websites niet kunnen bereiken
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")  // controller nodig
				.loginProcessingUrl("/authenticateTheUser")// hier geen controller voor nodig, spring doet dit automatisch
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}

	
}
