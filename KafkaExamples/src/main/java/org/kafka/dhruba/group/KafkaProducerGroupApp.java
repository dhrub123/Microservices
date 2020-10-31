package org.kafka.dhruba.group;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerGroupApp {

	public static void main(String[] args) {

		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092, localhost:9093");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

		try {
			for (int i = 0; i < 150; i++) {
				producer.send(new ProducerRecord<String, String>("my-big-topic", "abcdefghijklmnopqrstuvwxyz"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		} 
	}

}
