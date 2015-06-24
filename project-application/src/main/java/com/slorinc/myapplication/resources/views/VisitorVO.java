package com.slorinc.myapplication.resources.views;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * VisitorVO
 *
 * @author <a href="mailto:lorinc.sonnevend@betvictor.com">Lorinc Sonnevend</a>
 *         6/11/2015
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
