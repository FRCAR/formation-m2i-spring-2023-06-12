package com.bigcorp.booking.correction.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.correction.model.Plane;

@Repository
public interface PlaneDao extends CrudRepository<Plane, Long>{

}