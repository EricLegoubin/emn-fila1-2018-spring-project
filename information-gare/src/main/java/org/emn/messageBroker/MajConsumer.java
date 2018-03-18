package org.emn.messageBroker;

import java.io.IOException;
import java.util.concurrent.LinkedTransferQueue;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.imta.fila1.spring.informationgare.modele.catalogue.CourseCatalogue;

public class MajConsumer extends MessageConsumer {

	LinkedTransferQueue<CourseCatalogue> queue;

	public MajConsumer(LinkedTransferQueue<CourseCatalogue> queue) {
		super("maj");
		this.queue = queue;
	}

	public void listen() {
		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				// print the offset,key and value for the consumer records.
				System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
				CourseCatalogue obj;
				try {
					obj = mapper.readValue(record.value(), CourseCatalogue.class);
					queue.add(obj);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

}
