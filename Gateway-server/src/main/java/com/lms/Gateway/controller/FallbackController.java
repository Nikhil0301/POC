package com.lms.Gateway.controller;

import org.springframework.context.annotation.Fallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
	
	@RequestMapping("/failFetchBookTransactionDetails")
	public Mono<String> failFetchBookTransactionDetails(){
		return Mono.just("Unable to fetch book of particular user");
	}
}
