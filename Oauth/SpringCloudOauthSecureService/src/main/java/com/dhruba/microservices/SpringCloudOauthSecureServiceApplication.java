package com.dhruba.microservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SpringCloudOauthSecureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOauthSecureServiceApplication.class, args);
	}
	
	@Autowired
	private ResourceServerProperties sso;
	
	@Bean
	public ResourceServerTokenServices myuserInfoTokenService() {
		return new CustomUserInfoTokenService(sso.getUserInfoUri(), sso.getClientId());
	}
	
	@PreAuthorize("#oauth2.hasScope('toll_read') and hasAuthority('ROLE_OPERATOR')")
	@RequestMapping("/tolldata")
	public List<TollUsage> getTollData(){
		
		TollUsage instance1 = new TollUsage("200", "station150", "B65GT1W", "2016-0-30T06:31:22");
		TollUsage instance2 = new TollUsage("201", "station119", "AHY6738", "2016-0-30T06:3254");
		TollUsage instance3 = new TollUsage("202", "station150", "ZN2GP04", "2016-0-30T06:48:07");
		
		List<TollUsage> tolls = new ArrayList<TollUsage>();
		tolls.add(instance1);
		tolls.add(instance2);
		tolls.add(instance3);
		
		return tolls;
	}

}
