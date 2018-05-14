package com.Brand;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import org.skife.jdbi.v2.DBI;

import com.Brand.db.BrandDAO;
import com.Brand.health.DatabaseHealthCheck;
import com.Brand.resources.BrandResource;
import com.Brand.resources.HtmlPageResource;

import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BrandApplication extends Application<BrandConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BrandApplication().run(args);
    }

    @Override
    public String getName() {
        return "Brand";
    }

    @Override
    public void initialize(final Bootstrap<BrandConfiguration> bootstrap) {
    	bootstrap.addBundle(new MigrationsBundle<BrandConfiguration>() {
    	      @Override
    	      public PooledDataSourceFactory getDataSourceFactory(final BrandConfiguration configuration) {
    	        return configuration.getDataSourceFactory();
    	      }
    	    });
    	bootstrap.addBundle(new AssetsBundle("/assets/"));
    }

    @Override
    public void run(final BrandConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    	 final DBIFactory factory = new DBIFactory();
    	    final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
    	    final BrandDAO dao = jdbi.onDemand(BrandDAO.class);
    	    
    	    environment.jersey().register(new BrandResource(dao));
    	    environment.jersey().register(new HtmlPageResource());
    	    environment.healthChecks().register("health",
    	            new DatabaseHealthCheck(jdbi, configuration.getDataSourceFactory().getValidationQuery()));
    }

}
