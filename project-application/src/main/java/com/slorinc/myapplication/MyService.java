package com.slorinc.myapplication;

import com.slorinc.myapplication.configuration.MyApplicationConfiguration;
import com.slorinc.myapplication.dao.UserDAO;
import com.slorinc.myapplication.resources.ServiceHeathCheck;
import com.slorinc.myapplication.resources.ServiceResourceImpl;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * MyService
 *
 * @author <a href="mailto:lorinc.sonnevend@betvictor.com">Lorinc Sonnevend</a>
 *         6/10/2015
 */
public class MyService extends Application<MyApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyService().run(args);
    }

    @Override
    public String getName() {
        return "my-service";
    }

    @Override
    public void initialize(Bootstrap<MyApplicationConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<MyApplicationConfiguration>() {
            public DataSourceFactory getDataSourceFactory(MyApplicationConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(MyApplicationConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

        final UserDAO dao = jdbi.onDemand(UserDAO.class);
        final ServiceHeathCheck noMessageHeathCheck = new ServiceHeathCheck(dao);
        environment.healthChecks().register("DAO check",noMessageHeathCheck);
        environment.jersey().register(new ServiceResourceImpl(dao));

    }

}