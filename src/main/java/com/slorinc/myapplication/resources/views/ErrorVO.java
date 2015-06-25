package com.slorinc.myapplication.resources.views;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by s_lor_000 on 6/25/2015.
 */
public class ErrorVO {
    @JsonProperty
    private int code;

    @JsonProperty
    private String message;

    public ErrorVO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
