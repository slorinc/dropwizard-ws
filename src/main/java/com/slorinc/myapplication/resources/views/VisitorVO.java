package com.slorinc.myapplication.resources.views;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * VisitorVO
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitorVO visitorVO = (VisitorVO) o;
        return Objects.equals(id, visitorVO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
