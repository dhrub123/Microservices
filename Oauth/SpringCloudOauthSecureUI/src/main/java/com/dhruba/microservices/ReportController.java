package com.dhruba.microservices;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private OAuth2ClientContext clientContext;
	
	@Autowired
	private OAuth2RestTemplate oAuth2RestTemplate;
	
	@RequestMapping("/")
	public String loadHome() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/properties")
	public String loadProperties() {
		return "properties";
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/", "/login**")
			.permitAll().anyRequest().authenticated();
	}
	
	@RequestMapping("/reports")
	public String loadReport(Model model) {
		System.out.println("Token : " + clientContext.getAccessToken());
		
		ResponseEntity<ArrayList<TollUsage>> tolls = 
				oAuth2RestTemplate.exchange(
						"http://localhost:9001/services/tolldata", 
						HttpMethod.GET,
						null,
						new ParameterizedTypeReference<ArrayList<TollUsage>>(){});
		model.addAttribute("tolls", tolls.getBody());
		return "reports";
	}
}
