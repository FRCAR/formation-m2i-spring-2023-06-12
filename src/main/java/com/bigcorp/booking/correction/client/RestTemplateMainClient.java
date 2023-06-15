package com.bigcorp.booking.correction.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.bigcorp.booking.correction.model.Plane;

import reactor.core.publisher.Mono;

/**
 * Simple classe de client HTTP
 */
public class RestTemplateMainClient {
	
	public static void main(String[] args) throws InterruptedException {
		getNameFromWebServiceWebFlux(1);
		Thread.sleep(5_000);
	}
	
	/**
	 * Utilise RestTemplate pour faire un appel 	
	 * @param id
	 * @return
	 */
	public static String getNameFromWebServiceRestTemplate(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		String url
		  = "http://localhost:8080/sprg-frw/rest/v1/planes/" + id;
		ResponseEntity<Plane> response
		  = restTemplate.getForEntity(url, Plane.class);
		return response.getBody().getName();
	}
	
	/**
	 * 
	 * @param id
	 */
	public static void getNameFromWebServiceWebFlux(Integer id) {
		WebClient client = WebClient.builder()
				.baseUrl("http://localhost:8080/sprg-frw/rest/v1/")
				.build();
		
		Mono<Plane> monoPlane = client.get().uri("/planes/" + id).retrieve()
					.bodyToMono(Plane.class);
		
		//Plane plane = monoPlane.block();
		//System.out.println("Avec Webclient, le nom de l'avion est : " + plane.getName());
		monoPlane.subscribe(p -> System.out.println(p.getName()));
		//Block ici bloquerait le thread en cours...
		System.out.println("cette ligne de code s'exécute quelque soit le temps d'attente");
	}
	
}
