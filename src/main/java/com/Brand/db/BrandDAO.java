package com.Brand.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.Brand.core.Brand;
public interface BrandDAO {

	@SqlQuery("select * from brand")
	@Mapper(BrandMapper.class)
	public List<Brand> getBrandList();
	
	@SqlUpdate("insert into brand (name) values (:name)")
	public void insertToBrand(@Bind("name") String name);
	
	@SqlQuery("select COUNT(*) from brand where id = :id")
	public boolean existsBrand( @Bind("id") String id );
	
	@SqlUpdate("UPDATE brand SET name = :name WHERE id = :id")
	public void updateBrand( @Bind("id") String id, @Bind("name") String name );
	
	@SqlUpdate("DELETE FROM brand WHERE id = :id")
	public void deleteBrand( @Bind("id") String id );
	
}
