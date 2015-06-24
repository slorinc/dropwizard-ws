package com.slorinc.myapplication.resources.views;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * VisitorVO
 *
 */
public class VisitorVO {
    private Long id;

    public VisitorVO(Long id) {
        this.id = id;
    }

    public VisitorVO() {
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonProperty
    public void setId(Long id) {
        this.id = id;
    }
}
