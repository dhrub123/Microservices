package org.kafka.dhruba;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerApp {

	public static void main(String[] args) {

		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092, localhost:9093");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

		// topic, partition , timestamp, key, value
		// ProducerRecord message = new ProducerRecord("my_topic", 1, 124535353325l,
		// "Course-001", "My MEssage 1");
		// ProducerRecord message = new ProducerRecord("my_topic", "Course-001", "My
		// MEssage 1");
		// producer.send(message);

		try {
			for (int i = 0; i < 150; i++) {
				producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i),
						"My message: " + Integer.toString(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		} 
	}

}
