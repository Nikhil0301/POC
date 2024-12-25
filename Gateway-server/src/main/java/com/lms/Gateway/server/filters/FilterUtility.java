package com.lms.Gateway.server.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

import org.springframework.http.HttpHeaders;

@Component
public class FilterUtility {
	public static final String CORRELATION_ID = "lms-correlation-id";
	
	public String getCorrelationId(HttpHeaders requestHeaders) {
		if (requestHeaders.get(CORRELATION_ID) != null) {
			List<String> requestHttpHeadersList = requestHeaders.get(CORRELATION_ID);
			return requestHttpHeadersList.stream().findFirst().get();
		} else
			return null;
	}
	
	public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
		return exchange.mutate()
				       .request(exchange.getRequest()
				    		             .mutate()
				    		             .header(name, value)
				    		             .build())
				       .build();
	}
	
	public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
		return this.setRequestHeader(exchange, CORRELATION_ID, correlationId);
	}
	
}
