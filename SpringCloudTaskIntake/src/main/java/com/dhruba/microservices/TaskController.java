package com.dhruba.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	
	@Autowired
	private TaskProcessor taskProcessor;
	
	@RequestMapping(path="/tasks", method=RequestMethod.POST)
	private @ResponseBody String launchTask(@RequestBody String request) {
		taskProcessor.publishRequest(request);
		System.out.println("Request Made");
		return "success";
	}
}
