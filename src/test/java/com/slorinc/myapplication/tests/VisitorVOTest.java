package com.slorinc.myapplication.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slorinc.myapplication.resources.views.VisitorVO;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * VisitorVOTest
 *
 */
public class VisitorVOTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final VisitorVO visitorVO = new VisitorVO(1L);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/visitor.json"), VisitorVO.class));

        assertThat(MAPPER.writeValueAsString(visitorVO)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final VisitorVO visitorVO = new VisitorVO(1L);
        assertThat(MAPPER.readValue(fixture("fixtures/visitor.json"), VisitorVO.class).getId()).isEqualTo(visitorVO.getId());
    }

}
