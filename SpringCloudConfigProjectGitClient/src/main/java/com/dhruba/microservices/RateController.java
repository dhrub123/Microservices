package com.dhruba.microservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class RateController {
	
	@Value("${rate}")
	public String rate;
	
	@Value("${tollstart}")
	public String tollstart;

	@Value("${lanecount}")
	public String lanecount;
	
	@Value("${connstring}")
	public String connstring;
	
	@RequestMapping("/rate")
	public String getData(Model m) {
		m.addAttribute("rate", rate);
		m.addAttribute("tollstart", tollstart);
		m.addAttribute("lanecount", lanecount);
		m.addAttribute("connstring", connstring);
		return "rateview";
	}

}

