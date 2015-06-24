package com.slorinc.myapplication.resources.mappers;

import com.slorinc.myapplication.resources.entities.UserEO;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserEOMappper
 *
 */
public class UserEOMappper implements ResultSetMapper<UserEO> {


    public UserEO map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new UserEO(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("email"));
    }
}
