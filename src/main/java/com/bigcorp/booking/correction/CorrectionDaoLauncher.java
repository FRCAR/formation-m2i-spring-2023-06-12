package com.bigcorp.booking.correction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigcorp.booking.correction.configuration.TpServiceConfiguration;
import com.bigcorp.booking.correction.dao.PlaneDao;
import com.bigcorp.booking.correction.model.Plane;

public class CorrectionDaoLauncher {

	public static void main(String[] args) {

		// Instanciation du contexte Spring
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext()) {

			appContext.register(TpServiceConfiguration.class);
			appContext.refresh();

			PlaneDao planeDao = appContext.getBean(PlaneDao.class);
			
			planeDao.dropAndCreateTable();
			
			Plane plane = new Plane();
			plane.setName("MonAvion");
			
			planeDao.save(plane);
			String nom = "Hey!!";
			plane.setName(nom);
			planeDao.save(plane);
			
			
			System.out.println("Il y a "  + planeDao.findByName(nom).size() + " avions qui ont le nom " + nom);
			

		}
	}

}