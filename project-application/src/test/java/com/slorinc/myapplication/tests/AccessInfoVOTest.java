package com.slorinc.myapplication.tests;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slorinc.myapplication.resources.views.AccessInfoVO;
import io.dropwizard.jackson.Jackson;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * AccessInfoVOTest
 */
public class AccessInfoVOTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final AccessInfoVO accessInfoVO = new AccessInfoVO("ragnar@gmail.com", new DateTime(1435145298438L));

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/accessInfo.json"), AccessInfoVO.class));

        assertThat(MAPPER.writeValueAsString(accessInfoVO)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final AccessInfoVO accessInfoVO = new AccessInfoVO("ragnar@gmail.com", new DateTime(1435145298438L, DateTimeZone.UTC));
        final AccessInfoVO expected = MAPPER.readValue(fixture("fixtures/accessInfo.json"), AccessInfoVO.class);
        assertThat(expected.getEmail()).isEqualTo(accessInfoVO.getEmail());
        assertThat(expected.getTimestamp()).isEqualTo(accessInfoVO.getTimestamp());
    }

    @Test(expected = JsonParseException.class)
    public void detectMalformedJSON() throws Exception {
        MAPPER.readValue(fixture("fixtures/malformed.json"), AccessInfoVO.class);
    }

}