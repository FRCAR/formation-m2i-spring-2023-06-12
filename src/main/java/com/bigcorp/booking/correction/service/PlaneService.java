package com.bigcorp.booking.correction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.correction.dao.jpa.PlaneDao;
import com.bigcorp.booking.correction.model.Plane;

@Component
public class PlaneService {
	
	private Integer maxPlane;
	
	@Autowired
	private PlaneDao planeDao;

	public Integer getMaxPlane() {
		return maxPlane;
	}

	@Value("${planeService.max}")
	public void setMaxPlane(Integer maxPlane) {
		this.maxPlane = maxPlane;
	}
	
	@Transactional
	public void deleteById(Long id) {
		planeDao.deleteById(id);
	}
	
	/**
	 * Sauvegarde plane. Renvoie 
	 * un Plane qu'il vaut mieux utiliser pour la suite : 
	 * la persistence peut avoir changé l'objet
	 * @param plane
	 * @return
	 */
	@Transactional
	public Plane save(Plane plane) {
		return planeDao.save(plane);
	}
	
	@Transactional
	public void findById(Long id) {
		planeDao.findById(id);
	}
	
}
