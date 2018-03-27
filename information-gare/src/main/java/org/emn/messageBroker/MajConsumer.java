package org.emn.messageBroker;

import java.util.concurrent.LinkedTransferQueue;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.imta.fila1.spring.informationgare.modele.maj.MajObject;

public class MajConsumer extends MessageConsumer {

	LinkedTransferQueue<MajObject> queue;

	public MajConsumer(LinkedTransferQueue<MajObject> queue) {
		super("ing");
		this.queue = queue;
	}

	public void listen() {
		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				// print the offset,key and value for the consumer records.
				// System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(),
				// record.key(), record.value());
				MajObject obj;
				try {
					obj = mapper.readValue(record.value(), MajObject.class);
					// System.out.println("OBJ Read");

					queue.put(obj);

					// System.out.println("Object Add to queue");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}

			}
		}
	}

}
