package pluralsight.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomServiceHealthcheck implements HealthIndicator{
	
	int errorCode = 0;
	
	@Override
	public Health health() {
		System.out.println("HealthCheck performed. Error code is " + errorCode);
		if(errorCode > 4 && errorCode < 8) {
			errorCode++;
			return Health.down().withDetail("Custom Error Code ", errorCode).build();
		}
		errorCode++;
		return Health.up().build();
	}

}
