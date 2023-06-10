package com.bigcorp.booking.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bigcorp.booking.model.Example;

/**
 * Service pour l'entité Example.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Component
public class ExampleService {

	
	/**
	 * Sauvegarde example
	 * @param example
	 */
	@Transactional
	public void save(Example example) {
//		this.exampleSpringDao.save(example);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Example findById(Long id) {
		return null;
//		return this.exampleSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Example présents en base
	 */
	public Iterable<Example> findAll(){
		return null;
//		return this.exampleSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Example présentes en base
	 * @return
	 */
	public long count() {
		return 0;
//		return this.exampleSpringDao.count();
	}

	/**
	 * Supprime un Example par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
//		this.exampleSpringDao.deleteById(id);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public List<Example> findByNom(String nom) {
		return null;
//		return this.exampleSpringDao.maMethodeDeRechercheAvecUneQueryExplicite(nom);
	}
	
	

}