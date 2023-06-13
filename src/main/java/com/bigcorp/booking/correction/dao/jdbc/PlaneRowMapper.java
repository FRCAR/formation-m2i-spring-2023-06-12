package com.bigcorp.booking.correction.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bigcorp.booking.correction.model.Plane;

public class PlaneRowMapper implements RowMapper<Plane> {

	@Override
	public Plane mapRow(ResultSet rs, int rowNum) throws SQLException {
		Plane plane = new Plane();
		plane.setId(rs.getLong("ID"));
		plane.setName(rs.getString("NAME"));
		return plane;
	}

}
