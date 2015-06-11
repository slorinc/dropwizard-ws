package com.slorinc.myapplication.resources.mappers;

import com.slorinc.myapplication.resources.entities.UserEO;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserEOMappper
 *
 * @author <a href="mailto:lorinc.sonnevend@betvictor.com">Lorinc Sonnevend</a>
 *         6/11/2015
 */
public class UserEOMappper implements ResultSetMapper<UserEO> {


    public UserEO map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new UserEO(resultSet.getLong("id"),resultSet.getString("name"),resultSet.getString("email"));
    }
}
