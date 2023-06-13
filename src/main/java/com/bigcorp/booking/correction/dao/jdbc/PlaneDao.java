package com.bigcorp.booking.correction.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.bigcorp.booking.correction.model.Plane;

@Component
public class PlaneDao {

	private NamedParameterJdbcTemplate jdbcTemplateObject;

	/**
	 * La Datasource est nécessaire pour instancier l'unique JdbcTemplate de ce DAO
	 * 
	 * @param dataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
	}
	
	/**
	 * Supprime la table EXAMPLE si elle existe, puis la recréee.
	 */
	public void dropAndCreateTable() {
		jdbcTemplateObject.getJdbcTemplate().execute("DROP TABLE IF EXISTS PLANE");
		jdbcTemplateObject.getJdbcTemplate().execute("CREATE TABLE PLANE(ID IDENTITY PRIMARY KEY, NAME VARCHAR(255))");
	}
	
	/**
	 * Sauvegarde plane : exécute une requête SQL INSERT si plane.getId() == null,
	 * ou un UPDATE sinon.
	 * @param plane
	 */
	public void save(Plane plane) {
		
		if(plane.getId() == null) {
			String insertQuery = "INSERT INTO PLANE(NAME) VALUES (:planeName)";
			Map<String, Object> params = new HashMap<>();
			params.put("planeName", plane.getName());
			jdbcTemplateObject.update(insertQuery, params);
		}else {
			String updateQuery = "UPDATE PLANE SET NAME = :planeName WHERE ID = :planeId";
			Map<String, Object> params = new HashMap<>();
			params.put("planeId", plane.getId());
			params.put("planeName", plane.getName());
			jdbcTemplateObject.update(updateQuery, params);
		}
		
		
	}
	
	/**
	 * Récupère les planes dont le nom vaut planeName
	 * @param planeName
	 * @return
	 */
	public List<Plane>findByName(String planeName) {
		Map<String, Object> params = new HashMap<>();
		params.put("planeName", planeName);
		return jdbcTemplateObject.query("SELECT * FROM PLANE WHERE NAME = :planeName",
				params,
				new PlaneRowMapper());
	}

}
