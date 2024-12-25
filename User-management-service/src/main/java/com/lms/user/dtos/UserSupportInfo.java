package com.lms.user.dtos;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "user-management-service")
@Getter
@Setter
public class UserSupportInfo {
	private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}
