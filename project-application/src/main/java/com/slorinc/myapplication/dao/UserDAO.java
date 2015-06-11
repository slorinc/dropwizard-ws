package com.slorinc.myapplication.dao;

import com.slorinc.myapplication.resources.entities.UserEO;
import com.slorinc.myapplication.resources.mappers.AccessInfoMapper;
import com.slorinc.myapplication.resources.mappers.UserEOMappper;
import com.slorinc.myapplication.resources.views.AccessInfoVO;
import org.joda.time.DateTime;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * UserDAO
 *
 * @author <a href="mailto:lorinc.sonnevend@betvictor.com">Lorinc Sonnevend</a>
 *         6/10/2015
 */
@RegisterMapper(UserEOMappper.class)
public interface UserDAO {

    /**
     * Logs visit to ACCESSLOG table
     *
     * @param userid userId
     * @param visitorid visitorId
     * @param timestamp Timestamp
     */
    @SqlUpdate("INSERT INTO ACCESSLOG (userid,visitorid,timestamp) VALUES( :userid, :visitorid, :timestamp)")
    void logAccess(@Bind("userid") Long userid, @Bind("visitorid") Long visitorid, @Bind("timestamp") DateTime timestamp);

    /**
     * Last 10 visitor Ids and timestamp of the last 10 days for userId
     *
     * @param userId userId
     * @return
     */
    @SqlQuery("SELECT TOP 10 US.email, AL.timestamp FROM USER US INNER JOIN ACCESSLOG AL ON US.id = AL.visitorid WHERE AL.userid = :userid AND AL.timestamp > SYSDATE-10 ORDER BY AL.timestamp DESC")
    @RegisterMapper(AccessInfoMapper.class)
    List<AccessInfoVO> accessListByUserID(@Bind("userid") Long userId);

    /**
     * Query implemented for HealthCheck
     * @return list of Users
     */
    @SqlQuery("SELECT id,name,email FROM USER")
    List<UserEO> listUsers();

}
