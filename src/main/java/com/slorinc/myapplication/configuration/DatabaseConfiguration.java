package com.slorinc.myapplication.configuration;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.constraints.NotNull;

/**
 * DatabaseConfiguration
 *
 */
public class DatabaseConfiguration extends Configuration {

    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
