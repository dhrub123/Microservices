package pluralsight.demo;

import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(TollSource.class)
public class CustomTollPublisher {
	
	Random random = new Random();
	
	@Bean
	//@InboundChannelAdapter(channel="fastpassTollChannel", poller=@Poller(fixedDelay="2000"))
	public MessageSource<Toll> sendTollCharge() {
		return ()-> MessageBuilder.withPayload(new Toll("20","100","2020-10-0612:05:00"))
				.setHeader("speed", random.nextInt(8)*10)
				.build();
	}
	
	class Toll{
		public String stationId;
		public String customerId;
		public String timestamp;
		
		public Toll(String stationId, String customerId, String timestamp) {
			this.stationId = stationId;
			this.customerId = customerId;
			this.timestamp = timestamp;
		}
		
		
	}

}
