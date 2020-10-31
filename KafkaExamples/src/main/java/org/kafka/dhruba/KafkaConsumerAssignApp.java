package org.kafka.dhruba;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

public class KafkaConsumerAssignApp {
	 
	public static void main(String[] args) {
		
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092, localhost:9093");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		//properties.put("group.id", "test");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		ArrayList<TopicPartition> partitions = new ArrayList<TopicPartition>();
		
		TopicPartition myTopicpart0 = new TopicPartition("my-topic", 0);
		TopicPartition myOtherTopicPart2 = new TopicPartition("my-other-topic", 2);
		
		partitions.add(myTopicpart0);partitions.add(myOtherTopicPart2);
		
		consumer.assign(partitions);
		
		try {
			while(true) {
				ConsumerRecords<String, String> records = consumer.poll(10);
				for(ConsumerRecord<String, String> record : records) {
					System.out.println(
							String.format(
									"Topic: %s, Partition: %d, Offset: %d, Key: %s, Value: %s", 
									record.topic(), record.partition(), record.offset(), record.key(), record.value()
									
							)
					);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			consumer.close();
		}
		
	}
}
