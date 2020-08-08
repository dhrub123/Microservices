package com.dhruba.microservices;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudOauthSecureCliToCallCustomAuthServerFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOauthSecureCliToCallCustomAuthServerFlowApplication.class, args);
	}
	
	@RequestMapping("/result")
	public void getResult() {
		
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		
		resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
		resourceDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");
		resourceDetails.setScope(Arrays.asList("toll_read")); //if we keep empty, all scopes are provided
		
		resourceDetails.setClientId("pluralsight");
		resourceDetails.setClientSecret("pluralsightsecret");
		
		resourceDetails.setUsername("agoldberg");
		resourceDetails.setPassword("pass1");
		
		OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
		System.out.println("Token: " + template.getAccessToken());
		
		System.out.println("Result : " + template.getForObject("http://localhost:9001/services/tolldata", String.class));

	}

}
