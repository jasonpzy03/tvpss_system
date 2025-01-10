package config;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//using database auth
@Autowired
 private DataSource dataSource;
	
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.jdbcAuthentication()
	            .dataSource(dataSource)
	            .passwordEncoder(new BCryptPasswordEncoder())
	            .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
	            .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
	    }
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	            // Restrict access based on roles
	            .antMatchers("/ppd/**").hasRole("PPDADMIN")      // URLs under /admin/ require ADMIN role
	            .antMatchers("/jpnj/**").hasRole("JPNJADMIN")      // URLs under /sales/ require SALES role
	            .antMatchers("/teacher/**").hasRole("TEACHER")
	            .antMatchers("/student/**").hasRole("STUDENT")// URLs under /customer/ require CUSTOMER role
	            .antMatchers("/", "/home").permitAll()       
	            .antMatchers("/register").permitAll()   // Public access to "/" and "/home"
	            .anyRequest().authenticated()                  // All other requests require authentication
	            .and()
	            .formLogin()                      // Custom login page URL
	                .permitAll()
	                .successHandler(customAuthenticationSuccessHandler())
	            .and()
	            .logout()
	                .permitAll();
	    }
	    
	    private AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
	        return (request, response, authentication) -> {
	            String role = authentication.getAuthorities().toString();

	            if (role.contains("ROLE_PPDADMIN")) {
	                response.sendRedirect("ppd/dashboard");
	            } else if (role.contains("ROLE_JPNJADMIN")) {
	                response.sendRedirect("jpnj/dashboard");
	            } else if (role.contains("ROLE_TEACHER")) {
	                response.sendRedirect("teacher/dashboard");
	            } else if (role.contains("ROLE_STUDENT")) {
	                response.sendRedirect("home");
	            }
	        };
	    }
}