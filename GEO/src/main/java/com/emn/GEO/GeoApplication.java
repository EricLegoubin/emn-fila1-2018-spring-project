package com.emn.GEO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emn.GEO.simulateur.Simulateur;

@SpringBootApplication
public class GeoApplication {

	private static Simulateur simulateur;
	
	public static void main(String[] args) {
		SpringApplication.run(GeoApplication.class, args);
	}

	public static Simulateur getSimulateur() {
		return simulateur;
	}

	public static void setSimulateur(Simulateur simulateur) {
		GeoApplication.simulateur = simulateur;
	}
	
	
}
