package com.Brand.db;

import com.Brand.core.Brand;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class BrandMapper implements ResultSetMapper<Brand>{

	public Brand map(int i, ResultSet resultSet, StatementContext statementContext)throws SQLException {
		return new Brand( Long.parseLong( resultSet.getString("id") ), resultSet.getString("name") );
	}

}
