package com.slorinc.myapplication.resources.mappers;

import com.slorinc.myapplication.resources.views.AccessInfoVO;
import org.joda.time.DateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AccessInfoMapper
 *
 * @author <a href="mailto:lorinc.sonnevend@betvictor.com">Lorinc Sonnevend</a>
 *         6/11/2015
 */
public class AccessInfoMapper implements ResultSetMapper<AccessInfoVO> {
    public AccessInfoVO map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new AccessInfoVO(resultSet.getString("email"),new DateTime(resultSet.getTimestamp("timestamp")));
    }
}
