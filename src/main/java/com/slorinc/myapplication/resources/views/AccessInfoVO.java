package com.slorinc.myapplication.resources.views;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.util.Objects;

/**
 * AccessInfo
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessInfoVO that = (AccessInfoVO) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, timestamp);
    }
}
