package org.kafka.dhruba;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerSubscribeApp {

	public static void main(String[] args) {

		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092, localhost:9093");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("group.id", "test");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		ArrayList<String> topics = new ArrayList<String>();
		topics.add("my-topic");
		topics.add("my-other-topic");

		consumer.subscribe(topics);

		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(10);
				for (ConsumerRecord<String, String> record : records) {
					System.out.println(String.format("Topic: %s, Partition: %d, Offset: %d, Key: %s, Value: %s",
							record.topic(), record.partition(), record.offset(), record.key(), record.value()

					));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			consumer.close();
		}

	}
}
