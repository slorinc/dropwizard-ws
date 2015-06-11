package com.slorinc.myapplication.resources.views;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
