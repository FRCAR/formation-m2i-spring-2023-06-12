package com.bigcorp.booking.correction.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PlaneService {
	
	private Integer maxPlane;

	public Integer getMaxPlane() {
		return maxPlane;
	}

	@Value("${planeService.max}")
	public void setMaxPlane(Integer maxPlane) {
		this.maxPlane = maxPlane;
	}
	
}
