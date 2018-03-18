package org.imta.fila1.spring.informationgare;

import java.util.concurrent.LinkedTransferQueue;

import org.emn.messageBroker.CatalogueConsumer;
import org.emn.messageBroker.MajConsumer;
import org.imta.fila1.spring.informationgare.converter.CatalogueToCourseConverter;
import org.imta.fila1.spring.informationgare.converter.MajToCourseConverter;
import org.imta.fila1.spring.informationgare.modele.catalogue.CourseCatalogue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InformationgareApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationgareApplication.class, args);

		// ###RECEPTION DES FLUX### //

		// ###CATALOGUE### //

		LinkedTransferQueue<CourseCatalogue> catalogueTransferQueue = new LinkedTransferQueue<>();

		Thread threadCatalogueConsumer = new Thread(new CatalogueConsumer(catalogueTransferQueue));
		threadCatalogueConsumer.start();

		Thread threadCatalogueConverter = new Thread(new CatalogueToCourseConverter(catalogueTransferQueue));
		threadCatalogueConverter.start();

		// ###Maj### //
		LinkedTransferQueue<CourseCatalogue> majTransferQueue = new LinkedTransferQueue<>();

		Thread threadMajConsumer = new Thread(new MajConsumer(majTransferQueue));
		threadMajConsumer.start();

		Thread threadMajConverter = new Thread(new MajToCourseConverter(majTransferQueue));
		threadMajConverter.start();

	}
}
