package com.lms.Gateway.server;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}
	
	@Bean
	public RouteLocator lmsConfig(RouteLocatorBuilder routeLocatorBuilder) {
		//return builder.routes().route(p -> p.path("lms/user/**"))
		return routeLocatorBuilder.routes()
				                  .route(p -> p.path("/lms/user-management-service/**")
				                		      .filters(f -> f.rewritePath("/lms/user-management-service/(?<segment>.*)", "/${segment}")
				                		      .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
				                		      .circuitBreaker(config -> config.setName("userManagementCircuitBreaker")
				                		      //.setFallbackUri("forward:/failFetchBookTransactionDetails")))
				                		    		  ))
				                		      .uri("lb://USER-MANAGEMENT-SERVICE"))
				                  .route(p -> p.path("/lms/book-management-service/**")
				                		      .filters(f -> f.rewritePath("lms/book-management-service/(?<segment>.*)", "/${segment}")
				                		      .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
//				                		      .retry(retryConfig -> retryConfig.setRetries(3)
//				                		    		                           .setMethods(HttpMethod.GET)
//				                		    		                           .setBackoff(Duration.ofMillis(1000), Duration.ofMillis(10000), 2, true))
				                		      )
				                		      .uri("lb://BOOK-MANAGEMENT-SERVICE"))
				                  .build();
	}

}
