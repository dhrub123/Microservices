package pluralsight.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastPassRestController {
	
	@Autowired
	TollSource tollSource;
	
	@RequestMapping(path="/toll", method=RequestMethod.POST)
	public String publishMessage(@RequestBody String payload) {
		System.out.println(payload);
		Random random = new Random();
		tollSource.fastpassToll().send(
			MessageBuilder.withPayload(payload)	
				.setHeader("speed", random.nextInt(8)*10)
				.build()
				);
		return "success";
	}
	
}
