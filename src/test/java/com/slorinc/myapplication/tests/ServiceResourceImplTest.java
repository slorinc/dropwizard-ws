package com.slorinc.myapplication.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slorinc.myapplication.dao.UserDAO;
import com.slorinc.myapplication.exceptions.UserNotFoundException;
import com.slorinc.myapplication.resources.ServiceResourceImpl;
import com.slorinc.myapplication.resources.views.AccessInfoVO;
import com.slorinc.myapplication.resources.views.VisitorVO;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * ServiceResourceImplTest
 */
public class ServiceResourceImplTest {

    private static final UserDAO dao = mock(UserDAO.class);
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ServiceResourceImpl(dao))
            .build();

    private final List<AccessInfoVO> returnList = Arrays.asList(new AccessInfoVO("ragnar@gmail.com", new DateTime(1435145298438L, DateTimeZone.UTC)), new AccessInfoVO("bjorn@gmail.com", new DateTime(1435145297966L, DateTimeZone.UTC)));
    private final VisitorVO visitorVO = new VisitorVO(1L);

    @Before
    public void setup() {
        when(dao.checkUser(1L)).thenReturn(true);
        when(dao.checkUser(4L)).thenReturn(false);
        when(dao.accessListByUserID(1L)).thenReturn(returnList);
    }

    @Test
    public void testAccessListByUserID() throws Exception {
        final List<AccessInfoVO> list = MAPPER.readValue(resources.client().target("/1/list").request().get(String.class), new TypeReference<ArrayList<AccessInfoVO>>() {
        });
        assertThat(list).isEqualTo(returnList);
        verify(dao).accessListByUserID(1L);
    }

    @Test
    public void testAccessListByNonExistingUserID(){
        assertThat(resources.client().target("/4/list").request().get(Response.class).getStatus()).isEqualTo(404);
        verify(dao).checkUser(4L);
    }

    @Test
    public void testLogAccess() throws Exception {
        final int status = resources.client().target("/1").request().post(Entity.json(visitorVO)).getStatus();
        assertThat(status).isEqualTo(200);
    }

}