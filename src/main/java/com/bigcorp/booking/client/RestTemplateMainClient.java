package com.bigcorp.booking.client;

public class RestTemplateMainClient {

	
//	public static String getNameFromWebService(Integer id) {
//		RestTemplate restTemplate = new RestTemplate();
//		String url
//		  = "http://localhost:8080/sprg-frw/planes/" + id;
//		ResponseEntity<PlaneRestDto> response
//		  = restTemplate.getForEntity(url, PlaneRestDto.class);
//		return response.getBody().getName();
//	}
//	
//	public static void getNameFromWebServiceWebFlux(Integer id) {
//		WebClient client = WebClient.builder()
//				.baseUrl("http://localhost:8080/sprg-frw")
//				.build();
//		
//		Mono<PlaneRestDto> monoPlane = client.get().uri("/planes/" + id).retrieve().bodyToMono(PlaneRestDto.class);
//		
//		monoPlane.subscribe(p -> System.out.println(p.getName()));
//		//Block ici bloquerait le thread en cours...
//	}
}
