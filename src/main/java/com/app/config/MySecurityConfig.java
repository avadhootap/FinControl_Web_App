package com.app.config;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.security.authentication.AuthenticationManager;
	import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
	import org.springframework.security.config.http.SessionCreationPolicy;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

	import com.app.service.CustomUserDetailService;

	@Configuration
	@EnableWebSecurity
	public class MySecurityConfig  extends WebSecurityConfigurerAdapter{
		
		@Autowired
		private CustomUserDetailService customUserDetailsService;
		
		@Autowired
		private UserDetailsService userDetailsService;
		
		@Autowired
		private JwtAuthenticationFilter jwtFilter;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
			.csrf()//disable csrf
			.disable()
			.cors() // disable cors
			.disable()
			.authorizeRequests()
			.antMatchers("/token","/signup").permitAll() // allow every requests for /token
			.antMatchers("/**", "/auth/**", "/swagger*/**", "/v*/api-docs/**").permitAll()
			.anyRequest().authenticated()   //for any other request authenticate it.
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			 
			 System.out.println("inside security congigration class in httpsecurity method");
			 
			 http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class );
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			auth.userDetailsService(customUserDetailsService);
		}
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			{
				return new BCryptPasswordEncoder();
			}
		}
		
		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception
		{
			return super.authenticationManagerBean();
		}

}
