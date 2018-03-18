package org.emn.messageBroker;

import java.io.IOException;
import java.util.concurrent.LinkedTransferQueue;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.imta.fila1.spring.informationgare.converter.CatalogueToCourseConverter;
import org.imta.fila1.spring.informationgare.modele.catalogue.CourseCatalogue;

/**
 * Ecoute kafka, récupère les données au format JSON, les désérialise puis les
 * transfere pour conversion.
 * 
 * @see CatalogueToCourseConverter
 * 
 * @author valentin
 *
 */

public class CatalogueConsumer extends MessageConsumer {

	LinkedTransferQueue<CourseCatalogue> queue;

	public CatalogueConsumer(LinkedTransferQueue<CourseCatalogue> catalogueTransferQueue) {
		super("Catalogue");
		this.queue = catalogueTransferQueue;
	}

	public void listen() {
		// consumer.seekToBeginning(null);
		// consumer.seekToBeginning(consumer.assignment());
		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				// print the offset,key and value for the consumer records.
				System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
				try {
					// CourseCatalogue obj = mapper.readValue(record.value(),
					// CourseCatalogue.class);
					// queue.add(obj);
					CourseCatalogue[] obj = mapper.readValue(record.value(), CourseCatalogue[].class);
					for (CourseCatalogue course : obj) {
						queue.add(course);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
