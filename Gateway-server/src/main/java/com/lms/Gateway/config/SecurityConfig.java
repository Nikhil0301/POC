package com.lms.Gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;


//@Configuration
//@EnableWebFluxSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
		serverHttpSecurity.csrf().disable().authorizeExchange(exchanges -> exchanges.pathMatchers(HttpMethod.GET).permitAll()
				//.pathMatchers("/lms/user-management-service/**").authenticated()
				//.pathMatchers("/lms/book-management-service/**").authenticated())
		        ).oauth2ResourceServer(oauth2ResourceServerSpec -> oauth2ResourceServerSpec
		        		.jwt(Customizer.withDefaults()));
		//serverHttpSecurity.csrf(csrfSpec -> csrfSpec.disable());
		return serverHttpSecurity.build();
	}
	

}
