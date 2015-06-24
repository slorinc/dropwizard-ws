package com.slorinc.myapplication.resources.views;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.joda.time.DateTime;

/**
 * AccessInfo
 *
 * @author <a href="mailto:lorinc.sonnevend@betvictor.com">Lorinc Sonnevend</a>
 *         6/11/2015
 */
@JsonRootName("user")
public class AccessInfoVO {

    private String email;
    private DateTime timestamp;

    public AccessInfoVO() {
    }
    public AccessInfoVO(String email, DateTime timestamp) {
        this.email = email;
        this.timestamp = timestamp;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty
    public DateTime getTimestamp() {
        return timestamp;
    }

    @JsonProperty
    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }
}
