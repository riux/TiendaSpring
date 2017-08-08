
 package com.rem.spring.configuration;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ScurityConfiguration  extends  WebSecurityConfigurerAdapter{

	
	@Autowired
	@Qualifier("usuarioService")
	UserDetailsService usuarioService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());

	}
	 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/*", "/products/*","/images/*","/images/products/*" , "/js/*", "/fonts/*").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login/login").loginProcessingUrl("/login/validar")
		.usernameParameter("nombreUsuario").passwordParameter("contrasenia")
		.defaultSuccessUrl("/compra/comprar").permitAll()
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/index")
		.permitAll();
		
	}

}
	

