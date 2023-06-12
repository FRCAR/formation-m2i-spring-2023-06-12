package com.bigcorp.booking.correction.service;

import org.springframework.beans.factory.annotation.Value;

public class SuperBean {
	
	@Value("${prop1}")
	private String superBeanString;

	public String getSuperBeanString() {
		return superBeanString;
	}

	public void setSuperBeanString(String superBeanString) {
		this.superBeanString = superBeanString;
	}

}
