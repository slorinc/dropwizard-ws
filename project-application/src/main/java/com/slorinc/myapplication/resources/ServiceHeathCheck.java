package com.slorinc.myapplication.resources;

import com.codahale.metrics.health.HealthCheck;
import com.slorinc.myapplication.dao.UserDAO;

/**
 * ServiceHeathCheck
 *
 */
public class ServiceHeathCheck extends HealthCheck {

    private final UserDAO dao;

    public ServiceHeathCheck(UserDAO conf) {
        this.dao = conf;
    }

    /**
     * Checks if all three users where inserted into the DB
     *
     * @return
     * @throws Exception
     */
    @Override
    protected Result check() throws Exception {
        return dao.listUsers().size() == 3 ? Result.healthy() : Result.unhealthy("Data migration error!");
    }
}
