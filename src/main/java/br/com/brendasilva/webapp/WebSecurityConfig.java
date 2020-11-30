package br.com.brendasilva.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
import br.com.brendasilva.webapp.service.UsuarioService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UsuarioService usuarioService;
 
	/**
	 * REALIZA AS CONFIGURAÇÕES DE ACESSO
	 * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
		http
        .authorizeRequests()
            .antMatchers("/api/**").permitAll();
		
		http
        .authorizeRequests()
            .anyRequest().authenticated()
            .and()
        .formLogin()
        	.defaultSuccessUrl("/home", true)
            .loginPage("/")
            .permitAll()
            .and()
            .logout()
            .permitAll();
		
	}
 
 
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
        /*INFORMA A CRIPTOGRAFIA QUE DEVE SER USADA PARA A SENHA DO USUÁRIO*/				
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
 
    }
	
	/*CRIPTOGRAFANDO A SENHA PARA TESTE
	public static void main(String[] args) {
 
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}*/
	
}
